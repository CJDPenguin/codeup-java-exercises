package grades;

import util.Input;

import java.util.HashMap;
import java.util.Map;

public class GradesApplication {

    static Input in = new Input();

    public static void studentDetails(HashMap hash) {
        System.out.println("Are you looking for a report, information on overall class performance, or a individual student?");
        System.out.println("Enter \"report\", \"overall\", or \"student\"");
        String choice = in.getString();
        switch (choice) {
            case "student" :
                System.out.println("\nWhich student do you need details on?");
                String input = in.getString();
                if (hash.containsKey(input)){
                    Student detailed = (Student) hash.get(input);
                    System.out.printf("Name: %s - GitHub Username: %s\n", detailed.getName(), input);
                    System.out.printf("Average: %.2f\n", detailed.getGradeAverage());
                    System.out.println("Grades: " + detailed.getGrades());
                    System.out.println("Would you like to find another student?");
                    boolean check = in.yesNo();
                    if(check){
                        studentDetails(hash);
                    } else {
                        System.out.println("Thank you for using Eighties Gradies");
                    }
                } else {
                    System.out.printf("Sorry, no student found with the GitHub username: %s.\n", input);
                    System.out.println("Would you like to find another student?");
                    boolean check = in.yesNo();
                    if (check) {
                        studentDetails(hash);
                    } else {
                        System.out.println("Thank you for using Eighties Gradies");
                    }
                }
            case "overall":
                System.out.printf("Number of students: %d\n",hash.size());
                System.out.printf("Class average: %.2f\n", 40.0);
        }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        students.put("CJDPenguin", new Student("Chris"));
        students.put("JuliSimps", new Student("Julie"));
        students.put("LuckyChucky", new Student("Chuck"));
        students.put("ScarriTerri", new Student("Terrie"));
        students.put("AlwaysAdam", new Student("Adam"));

        students.get("CJDPenguin").addGrade(75);
        students.get("CJDPenguin").addGrade(80);
        students.get("CJDPenguin").addGrade(65);
        students.get("CJDPenguin").addGrade(100);
        students.get("CJDPenguin").addGrade(95);
        students.get("JuliSimps").addGrade(98);
        students.get("JuliSimps").addGrade(99);
        students.get("JuliSimps").addGrade(100);
        students.get("JuliSimps").addGrade(97);
        students.get("JuliSimps").addGrade(94);
        students.get("LuckyChucky").addGrade(60);
        students.get("LuckyChucky").addGrade(80);
        students.get("LuckyChucky").addGrade(85);
        students.get("LuckyChucky").addGrade(55);
        students.get("LuckyChucky").addGrade(90);
        students.get("ScarriTerri").addGrade(84);
        students.get("ScarriTerri").addGrade(89);
        students.get("ScarriTerri").addGrade(76);
        students.get("ScarriTerri").addGrade(93);
        students.get("ScarriTerri").addGrade(100);
        students.get("AlwaysAdam").addGrade(69);
        students.get("AlwaysAdam").addGrade(64);
        students.get("AlwaysAdam").addGrade(69);
        students.get("AlwaysAdam").addGrade(71);
        students.get("AlwaysAdam").addGrade(79);

        System.out.println("Welcome to the Eighties Gradies Academic Performance Tracking Application.\nHere are our student's GitHub usernames:");

        for (Map.Entry<String, Student> student : students.entrySet()) System.out.printf("|%s|", student.getKey());
        studentDetails(students);
    }
}
