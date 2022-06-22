import java.util.Arrays;

import static java.util.Arrays.fill;

public class ArraysExercises {


    public static String[] people = new String[3];

    public static String[] addPerson (String[] string, String add1) {
        String[] added = Arrays.copyOf(string, string.length + 1);
        added [string.length] = add1;
        return added;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(numbers);

        fill(people, "Bob");

        String[] check = addPerson(ArraysExercises.people,"Steve");

        for (String person : ArraysExercises.people) {
            System.out.println(person);
        }
        for (String person : check) {
            System.out.println(person);
        }
    }

}
