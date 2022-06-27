package util;

import java.util.Scanner;

public class Input {
    private final Scanner input = new Scanner(System.in);

    public String getString(boolean prompt) {
        if (prompt) {
            System.out.println("Enter a string");
        }
            return input.next();
    }

    public String getString(){
        return input.next();
    }

    public int getInt(int min, int max, boolean prompt) {
        if (prompt) {
            System.out.printf("Enter a whole number between %d & %d\n", min, max);
        }
        int num = 0;
        try {
            num = Integer.parseInt(getString());
            if (num >= min && num <= max) {
                return num;
            } else {
                return getInt(min, max, prompt);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            getInt(min, max, prompt);
        }
        return num;
    }

    public int getInt(boolean prompt) {
        if (prompt) {
            System.out.println("Enter a whole number");
        }
        int num = 0;
        try {
            num = Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            getInt(prompt);
        }
        return num;
    }

    public int getInt() {
        int num = 0;
        try {
            num = Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            getInt(true);
        }
        return num;
    }

    public double getDouble(double min, double max, boolean prompt) {
        if (prompt) {
            System.out.printf("Enter a number between %f & %f\n", min, max);
        }
        double num = 0;
        try {
            num = Double.parseDouble(getString());
            if (num >= min && num <= max){
                return num;
            } else {
                return getDouble(min, max, prompt);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            getDouble(min, max, prompt);
        }
        return num;
    }

    public double getDouble(boolean prompt) {
        if (prompt) {
            System.out.println("Enter a number");
        }
        double num = 0;
        try {
            num = Double.parseDouble(getString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            getDouble(prompt);
        }
        return num;
    }

    public double getDouble() {
        double num = 0;
        try {
            num = Double.parseDouble(getString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            getDouble(true);
        }
        return num;
    }

    public boolean yesNo(boolean prompt) {
        if (prompt) {
            System.out.println("Enter yes, y, or agree to enter into an eternal blood contract with Cthulu");
        }
        String check = input.next();
        return check.equalsIgnoreCase("yes") || check.equalsIgnoreCase("y") || check.equalsIgnoreCase("agree");
    }

    public boolean yesNo() {
        String check = input.next();
        return check.equalsIgnoreCase("yes") || check.equalsIgnoreCase("y") || check.equalsIgnoreCase("agree");
    }

}
