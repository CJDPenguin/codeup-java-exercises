import java.util.Locale;
import java.util.Scanner;

public class ControlFlowExercises {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i = 5;
        while (i <= 15) {
            System.out.print(i++ + " ");
        }

        int count = 0;

        do {
            System.out.println(count);
            count += 2;
        } while (count <= 100);

        int backCount = 100;

        do{
            System.out.println(backCount);
            backCount -= 5;
        } while (backCount >= -10);

        long square = 2;

        do {
            System.out.println(square);
            square *= square;
        } while (square <= 1000000);

        for (int a = 5; a <= 15; a ++) {
            System.out.print(a);
        }

        for (int iterator = 2; iterator <= 100; iterator += 2) {
            System.out.println(iterator);
        }

        for (int backIterator = 100; backIterator >= -10; backIterator -= 5) {
            System.out.println(backIterator);
        }

        for (long stupidSquare = 2; stupidSquare <= 1000000; stupidSquare *= stupidSquare) {
            System.out.println(stupidSquare);
        }

        for (int fizzBuzz = 1; fizzBuzz <=100; fizzBuzz++) {
            if (fizzBuzz % 15 == 0) {
                System.out.println("FizzBuzz");
                continue;
            } if (fizzBuzz % 5 == 0) {
                System.out.println("Buzz");
                continue;
            } if (fizzBuzz % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(fizzBuzz);
            }
        }

        System.out.print("Would you like to see your table? ");
        String doIt = in.next();

        while (doIt.equalsIgnoreCase("yes")) {
            System.out.print("How many numbers would you like to see in your table? ");
            int tableNum = in.nextInt();
                System.out.println("| Number | Squared | Cubed |");
                System.out.println("|--------|---------|-------|");
                int num = 1;
            do {
                System.out.printf("| %d      | %.0f       | %.0f     |\n",num, Math.pow(num, 2), Math.pow(num, 3));
                num++;
            } while (num <= tableNum);
            System.out.print("Would you like to see another table? ");
            doIt = in.next();
        }

        System.out.print("Convert to Letter Grade? \n(y/n)");
        String leshGo = in.next();

        while (leshGo.equalsIgnoreCase("y")) {
            System.out.print("What percentile grade did they get? ");
            int gradePercent = in.nextInt();
            if (gradePercent >= 98) {
                System.out.println("A+");
            } else if (gradePercent >=91) {
                System.out.println("A");
            } else if (gradePercent >= 88) {
                System.out.println("B+");
            } else if (gradePercent >=81) {
                System.out.println("B");
            } else if (gradePercent >= 78) {
                System.out.println("C+");
            } else if (gradePercent >=71) {
                System.out.println("C");
            }else if (gradePercent >= 68) {
                System.out.println("D+");
            } else if (gradePercent >=61) {
                System.out.println("D");
            } else if (gradePercent >=58) {
                System.out.println("F+");
            } else {
                System.out.println("F");
            }
            System.out.print("Input another grade? \n(y/n)");
            leshGo = in.next();
        }

        }
    }
