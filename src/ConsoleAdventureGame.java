import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class ConsoleAdventureGame {

    static Scanner in = new Scanner(System.in);

    public static int damage() {
        return (int) ((Math.random() * 5) + 1);
    }

    public static int attack() {
            return damage();
        }

    public static int heal(@NotNull String job, int pot) {
        if (job.equals("CLERIC")) {
            return damage()*2;
        } else if (pot > 0) {
            return damage()*2;
        } else {
            return 0;
        }
    }

    public static int special(@NotNull String job) {
        switch (job) {
            case "FIGHTER" -> {
                return damage() + damage();
            }
            case "THIEF" -> {
                return damage() * 2;
            }
            case "MAGE" -> {
                return damage() + 2;
            }
        }
        return 0;
    }

    public static void action(int heroHP, int baddieHP, String job, int pot) {
        if (baddieHP < 20) {
            System.out.println("The dragon strikes at you with burning claws, raking you viciously");
            heroHP -= damage();
        }
        if (heroHP <= 0) {
            System.out.println("The dragon opens its maw and swallows you in a single great gulp.");
        } else if (baddieHP <=0) {
            System.out.println("The dragon falls under your onslaught, crumbling to the ground with a crash. You stand victoriously over it as the fell beast breathes its last.");
        } else {
            System.out.println("\nYou have " + heroHP + " health and the dragon is left with " + baddieHP + " health.\nWhat will you do?\n(Attack / Heal / Special / Run)");
            String action = in.next();

            switch (action.toLowerCase()) {
                case "attack": {
                    System.out.println("You take a swing with your sword, striking the dragon!");
                    action(heroHP, baddieHP - attack(), job, pot);
                    break;
                }
                case "heal": {
                    if (job.equals("CLERIC") || pot > 0) {
                        pot--;
                        System.out.println("You pause for a moment, rejuvinating yourself from within!");
                        action(heroHP + heal(job, pot), baddieHP, job, pot);
                    } else {
                        System.out.println("You try to pause, but cannot catch your breath before the dragon's next attack");
                        action(heroHP, baddieHP, job, pot);
                    }
                    break;
                }
                case "special": {
                    System.out.println("You gather your strength and release the technique of your mentors!");
                    action(heroHP, baddieHP - special(job), job, pot);
                    break;
                }
                case "run": {
                    System.out.println("You take the coward's way out, and cast your weapons aside. You turn to sprint away, but the dragon makes a small coughing noise and you are suddenly engulfed in brilliant flames, your flesh cooked to cinders before you hit the ground.");
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("*The reddened chubby cheeks of an middle aged barkeep greet your eyes as the flutter open. The faint aroma of alcohol wafting in front of your nose as he asks a question.*\nWhat is your name, brave adventurer?");
        String name = in.next();
        System.out.printf("Well met, %s. I've never seen one of your ilk, how do you make your way through this world?\n(Are you a FIGHTER, THIEF, MAGE, or CLERIC?)",name);
        String job = in.next().toUpperCase();
        System.out.printf("Ah... I've heard tell of those that follow the path of the %s, but haven't met one. Mayhaps you are precisely the deliverance we have been praying for. There is a terrible dragon plaguing the village, having burned the harvest and eaten the livestock, it now hunts for the villagers themselves. No one is safe outside their homes. What say you, can we count on you to slay this dragon?\n(Yes/No)", job);
        String answer = in.next();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Good on ye lad! I knew ye had the stones fo' it. Remember, it's dangerous to go alone, so you might be wanting this.\n*The barkeep hands you a long familiar package, which you unwrap to reveal your sword. You buckle it about your waist and head for the door*\nOne last thing, lad. May the lady of the lake be with you.");
            action(20,20,job,1);
        } else {
            System.out.println("Ooooh, you almost had it.");
        }
    }
}
