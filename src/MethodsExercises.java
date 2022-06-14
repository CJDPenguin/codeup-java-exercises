import java.util.Scanner;

public class MethodsExercises {
    static Scanner in = new Scanner(System.in);

    public static double addition (double a, double b) {
        return a + b;
    }

    public static double subtraction (double a, double b) {
        return a - b;
    }

    public static double multiplication (double a, double b, double product) {
        double answer = product;
        if (b <= 0) {
            return answer;
        } else {
            answer += a;
        }
        return multiplication(a, b -1, answer );
    }

    public static double division (double a, double b) {
        return a / b;
    }

    public static double modulus (double a, double b) {
        return a % b;
    }

    public static int valid () {
        System.out.println("Enter a number between 1 & 20: ");
        int num = in.nextInt();
        if (num <= 20 && num >= 1){
            return num;
        } return valid();
    }

    public static long factorialAnswer(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorialAnswer(n - 1);
    }

    public static void factorial(int number) {
        long start = 1;
        String factor = number + "! = ";
        while (start < number) {
            factor = factor + start++ + " x ";
         } if (start == number) {
            factor = factor + start + " = " + factorialAnswer(number);
        }
        System.out.println(factor);
    }

    public static int dice(int sides) {
        return (int) ((Math.random() * ((sides - 1) + 1)));
    }

    public static void main(String[] args) {

//        System.out.println("Enter your first number: ");
//
//        double first = in.nextDouble();
//
//        System.out.println("Enter your second number: ");
//
//        double second = in.nextDouble();
//
//        System.out.println(addition(first, second));
//
//        System.out.println(subtraction(first, second));
//
//        System.out.println(multiplication(first, second, 0));
//
//        System.out.println(division(first, second));
//
//        System.out.println(modulus(first, second));

//        factorial(valid());

        System.out.println("Would you like to roll the dice?\n(y/n)");

        String go = in.next();
        while (go.equals("y")){
            System.out.println("How big are the dice?");
            int die = in.nextInt();
            int roll1 = dice(die);
            int roll2 = dice(die);
            System.out.println("You rolled a " + roll1 + " & a " + roll2);
            System.out.println("Would you like to roll again?\n(y/n)");
            go = in.next();
        }


    }
}
