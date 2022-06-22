package grades;

import util.Input;

import java.util.HashMap;
import java.util.Map;

public class GradesApplication {

    static Input in = new Input();

    public static void student(HashMap <String, Student> hash) {
        System.out.println("\nWhich student do you need details on?");
        String input = in.getString();
        if (hash.containsKey(input)){
            Student detailed = hash.get(input);
            System.out.printf("Name: %s - GitHub Username: %s\n", detailed.getName(), input);
            System.out.printf("Average: %.2f\n", detailed.getGradeAverage());
            System.out.println("Grades: " + detailed.getGrades());
            System.out.println("Would you like to find another student?");
            boolean check = in.yesNo();
            if(check){
                student(hash);
            } else {
                studentDetails(hash);
            }
        } else {
            System.out.printf("Sorry, no student found with the GitHub username: %s.\n", input);
            System.out.println("Would you like to find another student?");
            boolean check = in.yesNo();
            if (check) {
                student(hash);
            } else {
                studentDetails(hash);
            }
        }
    }

    public static void studentDetails(HashMap <String, Student> hash) {
        System.out.println("Are you looking for a report, information on overall class performance, or a individual student?");
        System.out.println("Enter \"report\", \"overall\", \"student\", or \"quit\"");
        String choice = in.getString();
        switch (choice) {
            case "student" : student(hash); break;

            case "overall":
                System.out.printf("Number of students: %d\n",hash.size());
                double gradeTotal = 0;
                for (Student student : hash.values()) {
                    gradeTotal += student.getGradeAverage();
                }
                System.out.printf("Class average: %.2f\n", gradeTotal/hash.size());
                studentDetails(hash);
                break;
            case "report":
                System.out.println("Here's your report");
                System.out.println("name,github_username,average");
                for (Map.Entry<String, Student> student : hash.entrySet()) {
                    System.out.printf("%s,%s,%.2f\n", student.getValue().getName(), student.getKey(), student.getValue().getGradeAverage());
                }
                studentDetails(hash);
                break;
            case "quit":
                System.out.println("Thank you for using Eighties Gradies");
                break;
            default:
                System.out.println("Command unknown, please enter \"report\", \"overall\", \"student\", or \"quit\"");
                    studentDetails(hash);
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

        System.out.println("Welcome to the Eighties Gradies Academic Performance Tracking Application.\nHere are our student's GitHub usernames:\n");

        for (Map.Entry<String, Student> student : students.entrySet()) System.out.printf("|%s|", student.getKey());
        studentDetails(students);
    }
}
