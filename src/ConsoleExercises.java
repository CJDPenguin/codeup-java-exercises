import java.util.Scanner;

public class ConsoleExercises {
    public static void main(String[] args) {

        double pi = 3.14159;

        System.out.printf("The value of pi is approximately %.2f%n", pi);

        Scanner in = new Scanner(System.in);
        System.out.print("Enter an interger: ");
        int integer = in.nextInt();
        System.out.println(integer);

        System.out.print("Enter a word: ");
        String first = in.next();
        System.out.print("Enter another word: ");
        String second = in.next();
        System.out.print("Enter another another word: ");
        String third = in.next();
        System.out.printf("Your first word is %s \nYour second word is %s \nYour third word is %s \n", first, second, third);

        System.out.println("Enter a sentence: ");
        in.nextLine();
        String sentence = in.nextLine();
        System.out.println(sentence);

        in.useDelimiter("\n");
        System.out.print("Enter the length of the room: ");
        float length = Float.parseFloat(String.valueOf(in.nextInt()));
        System.out.print("Enter the width of the room: ");
        float width = Float.parseFloat(String.valueOf(in.nextInt()));
        System.out.printf("The perimeter of the room is: %.2f\nThe area of the room is: %.2f\n", (length * 2 + width * 2), (length * width));
        System.out.println("Enter the height of the room: ");
        float height = Float.parseFloat(String.valueOf(in.nextInt()));
        System.out.print("The volume of the room is: " + (length * width * height));

    }

}
