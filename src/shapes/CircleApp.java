package shapes;

import util.Input;

public class CircleApp {

    static Input in = new Input();

    public static void main(String[] args) {
            System.out.println("Would you like to make a circle with me, little child?");
            boolean go = in.yesNo(true);

            while(go) {
                System.out.println("What's the radius of your circle, small one?");
                double rad = in.getDouble();
                Circle rosie = new Circle(rad);
                System.out.printf("Good job! That wasn't too hard was it?\nThe circumference of your circle would be %.2f and the area of your circle would be %.2f\n", rosie.getCircumference(), rosie.getArea());
                go = in.yesNo(true);
            }
        }
    }

