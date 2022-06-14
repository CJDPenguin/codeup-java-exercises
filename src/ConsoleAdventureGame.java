import java.util.Scanner;

public class ConsoleAdventureGame {

    static Scanner in = new Scanner(System.in);

    public static int damage() {
        return (int) ((Math.random() * 5) + 1);
    }

    public static void attack(int ghp, int bhp) {
        System.out.printf("\nDo you want to attack?");
        String answer = in.next();

        if (answer.equalsIgnoreCase("yes")) {
            int strike = damage();
            int counter = damage();
            bhp -= strike;
            ghp -= counter;

            System.out.printf("\nYou attack for %d, your opponent now has %d health.\nYour opponent responds with an attack for %d, you now have %d health",strike, bhp, counter, ghp);

            if(ghp <= 0 || bhp <= 0) {
                System.out.println("\nOne has fallen!");
            } else {
                attack(ghp, bhp);
            }
        }
    }

    public static void main(String[] args) {
        attack(20,20);
    }
}
