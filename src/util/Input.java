package util;

import java.util.Scanner;

public class Input {
    private final Scanner input = new Scanner(System.in);

    String getString(boolean prompt) {
        if (prompt) {
            System.out.println("Enter a string");
        }
            return input.nextLine();
    }

    String getString(){
        return input.nextLine();
    }

    int getInt(int min, int max, boolean prompt) {
        if (prompt) {
            System.out.printf("Enter a whole number between %d & %d\n", min, max);
        }
            int check = input.nextInt();
            if (check >= min && check <= max) {
                return check;
            } else {
                return getInt(min, max, prompt);
            }
        }

    int getInt(int min, int max) {
        int check = input.nextInt();
        if (check >= min && check <= max) {
            return check;
        } else {
            return getInt(min, max);
        }
    }

    int getInt(boolean prompt) {
        if (prompt) {
            System.out.println("Enter a whole number");
        }
        return input.nextInt();
    }

    int getInt() {
        return input.nextInt();
    }

    double getDouble(double min, double max, boolean prompt) {
        if (prompt) {
            System.out.printf("Enter a number between %f & %f\n", min, max);
        }
        double check = input.nextDouble();
        if (check >= min && check <= max) {
            return check;
        } else {
            return getDouble(min, max, prompt);
        }
    }

    double getDouble(double min, double max) {
        double check = input.nextDouble();
        if (check >= min && check <= max) {
            return check;
        } else {
            return getDouble(min, max);
        }
    }

    double getDouble(boolean prompt) {
        if (prompt) {
            System.out.println("Enter a number");
        }
        return input.nextDouble();
    }

    double getDouble() {
        return input.nextDouble();
    }

    boolean yesNo(boolean prompt) {
        if (prompt) {
            System.out.println("Enter yes, y, or agree to enter into an eternal blood contract with Cthulu");
        }
        String check = input.next();
        return check.equalsIgnoreCase("yes") || check.equalsIgnoreCase("y") || check.equalsIgnoreCase("agree");
    }

    boolean yesNo() {
        String check = input.next();
        return check.equalsIgnoreCase("yes") || check.equalsIgnoreCase("y") || check.equalsIgnoreCase("agree");
    }

}
