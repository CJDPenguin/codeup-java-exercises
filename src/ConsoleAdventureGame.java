import java.util.Scanner;

public class ConsoleAdventureGame {

    static Scanner in = new Scanner(System.in);

    public static int attack() {
        return (int) ((Math.random() * 5) + 1);
    }

    public static int heal() {
        return attack()*2;
    }

    public static int special(String job) {
        switch (job) {
            case "FIGHTER" -> {
                return (int) ((attack() + attack())*1.5);
            }
            case "THIEF" -> {
                return (attack() * 3);
            }
            case "MAGE" -> {
                return attack() + 5;
            }
            default -> {
                return attack() + 1;
            }
        }
    }

    public static void action(int heroHP, int baddieHP, String job, int pot, String lastMove) {
        if (baddieHP < 30) {
            System.out.println("*The dragon strikes at you with burning claws, raking you viciously*");
            heroHP -= attack();
        }
        if (heroHP <= 0) {
            System.out.println("*The dragon opens its maw and swallows you in a single great gulp.*");
        } else if (baddieHP <=0) {
            System.out.println("*The dragon falls under your onslaught, crumbling to the ground with a crash. You stand victoriously over it as the fell beast breathes its last.*");
        } else {
            System.out.println("\n*You have " + heroHP + " health and the dragon is left with " + baddieHP + " health.*\nWhat will you do?\n(Attack / Heal / Special / Run)");
            String action = in.next().toLowerCase();

            if (action.equalsIgnoreCase(lastMove) && !lastMove.equals("attack")) {
                System.out.println("*The dragon sees through your tactics and defends himself.*");
                action(heroHP, baddieHP, job,pot, "");
            } else {
                switch (action) {
                    case "attack": {
                        System.out.println("*You take a swing with your sword, striking the dragon!*");
                        action(heroHP, baddieHP - attack(), job, pot, action);
                        break;
                    }
                    case "heal": {
                        if (job.equals("CLERIC") || pot > 0) {
                            pot--;
                            System.out.println("*You pause for a moment, and the Great Lady restores you!*");
                            action(heroHP + heal(), baddieHP, job, pot, action);
                        } else {
                            System.out.println("*You try to pause, but cannot catch your breath before the dragon's next attack.*");
                            action(heroHP, baddieHP, job, pot, action);
                        }
                        break;
                    }
                    case "special": {
                        System.out.println("*You gather your strength and release the technique of your mentors!*");
                        action(heroHP, baddieHP - special(job), job, pot, action);
                        break;
                    }
                    case "run": {
                        System.out.println("*You take the coward's way out, and cast your weapons aside. You turn to sprint away, but the dragon makes a small coughing noise and you are suddenly engulfed in brilliant flames, your flesh cooked to cinders before you hit the ground.*");
                        break;
                    }
                    default: {
                        System.out.println("*You hear a voice from inside you whispering. Although you cannot understand it's words you know it is urging you not to give up.*");
                        action(heroHP, baddieHP, job, pot, action);
                    }
                }
            }
        }
    }

    public static void move (String job) {
        System.out.println("*You survey the rubble of the village before you, smoke rising in the distance from the burning fields, the air strangely silent in the absence of the calls of birds and other animals. Not a single other soul in sight. The hair stands on end on the back of your neck, you need only set off in a direction*\n(Forward, Left, Right, Back)");
        String direction = in.next().toLowerCase();
        switch (direction) {
            case "forward" -> {
                System.out.println("*You step forward, picking your way through the rubble in front of you. The faint tinge of sulfur burns your nostrils as you pause for a moment to evaluate your direction.*");
                move(job);
            }
            case "left" -> {
                System.out.println("*You turn to the left, stepping carefully around the charred remains of what may have been a wagon at some other time, in some other place. Your thoughts turn towards your home, childhood memories travelling with your siblings to the market in the back of the old family wagon. After a moment you give your head a shake and evaluate your direction.*");
                move(job);
            }
            case "right" -> {
                System.out.println("*You search to your right, crossing quickly through the small open space to lean against the house on the far side. A weathered old woman pokes her head out the door at the noise and squints at you suspiciously for a moment. A voice calls from inside the house and she closes the door and steps further inside. Obviously unwelcome in the house you evaluate your direction*");
                move(job);
            }
            case "back" -> {
                System.out.println("*You spin on your heel to return whence you came, but before you can take a step a loud whooshing of leathery wings in the sky portends of the arrival of a greater danger. The dragon lands directly in front of you, its green scales flashing in the light of the flames that it had created. It bellows out a challenge and you see no way through but to complete your task.*");
                action(20, 30, job, 1, "heal");
            }
            default -> {
                System.out.println("*You hear a small voice from inside you whispering. It's words are unintelligible but you understand that you need to keep moving*");
                move(job);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("*The reddened chubby cheeks of an middle aged barkeep greet your eyes as they flutter open. The faint aroma of alcohol wafting in front of your nose as he asks a question.*\nWhat is your name, brave adventurer?");
        String name = in.next().toUpperCase();
        System.out.printf("Well met, %s. I've never seen one of your ilk, how do you make your way through this world?\n(Are you a FIGHTER, THIEF, MAGE, or CLERIC?)",name);
        String job = in.next().toUpperCase();
        System.out.printf("Ah... I've heard tell of those that follow the path of the %s, but haven't met one. Mayhaps you are precisely the deliverance we have been praying for. There is a terrible dragon plaguing the village, having burned the harvest and eaten the livestock, it now hunts for the villagers themselves. No one is safe outside their homes. What say you, can we count on you to slay this dragon?\n(Yes/No)", job);
        String answer = in.next();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Good on ye! I knew ye had the stones fo' it. Remember, it's dangerous to go alone, so you might be wanting this.\n*The barkeep hands you a long familiar package, which you unwrap to reveal your sword. You buckle it about your waist and head for the door*\nOne last thing, lad. May the Good Lady be with you.\n*You open the door and head into the village.*");
            move(job);
        } else {
            System.out.println("Ooooh, you almost had it.");
        }
    }
}
