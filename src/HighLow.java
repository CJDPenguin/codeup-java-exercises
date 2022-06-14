import java.util.Scanner;

public class HighLow {
static Scanner in = new Scanner(System.in);

    public static int random() {
        return (int) ((Math.random() * 100) + 1);
    }

    public static int valid () {
        System.out.println("Enter a number between 1 & 100: ");
        int num = in.nextInt();
        if (num <= 100 && num >= 1){
            return num;
        } return valid();
    }

    public static void guess(int number, int answer, int guesses) {
        if (guesses > 0) {
            if (number == answer) {
                System.out.println("Great Guess");
            }
            if (number > answer) {
                System.out.println("Lower");
                guess(valid(), answer, (guesses - 1));
            }
            if (number < answer) {
                System.out.println("Higher");
                guess(valid(), answer, (guesses - 1));
            }
        } else {
            System.out.println("You're out of guesses. You lose. Goodbye");
        }
    }

    public static void main(String[] args) {
        System.out.println("Wanna play a game?\n(Yes/No)");
        String go = in.next();

        if (go.equalsIgnoreCase("yes")) {
            int number = random();

            System.out.println("*cackles*\nGood, good!\nYou have 10 guesses to guess the number I have in my head that's between 1 & 100.\nI'll even make it easier for you and tell you if your guess was lower or higher than my number.");
            guess(valid(),number,10);
        }
    }
}
