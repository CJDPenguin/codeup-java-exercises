package grades;

import util.Input;

import java.util.HashMap;
import java.util.Map;

public class GradesApplication {

    static Input in = new Input();

    public static void student(HashMap <String, Student> hash) {
        System.out.println("\nWhich student do you need details on?");
        for (Map.Entry<String, Student> student : hash.entrySet()) System.out.printf("|%s|\n", student.getKey());
        String input = in.getString();
        if (hash.containsKey(input)){
            Student detailed = hash.get(input);
            System.out.printf("Name: %s - GitHub Username: %s\n", detailed.getName(), input);
            System.out.printf("Grade Average: %.2f\n", detailed.getGradeAverage());
            System.out.printf("Attendance Average: %.2f\n",detailed.getAttendancePercentage());
            System.out.println("Would you like to see detailed information for this student?");
            boolean details = in.yesNo();
            if(details) {
                System.out.print("Grades: ");
                System.out.println(detailed.getGrades());
                System.out.print("Absences: ");
                System.out.println(detailed.getAbsences());
            }
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
                double attendanceTotal= 0;
                for (Student student : hash.values()) {
                    gradeTotal += student.getGradeAverage();
                }
                for (Student student : hash.values()) {
                    attendanceTotal += student.getAttendancePercentage();
                }
                System.out.printf("Class GPA: %.2f\n", gradeTotal/hash.size());
                System.out.printf("Class Attendance Average: %.2f\n", attendanceTotal/hash.size());
                studentDetails(hash);
                break;
            case "report":
                System.out.println("Here's your report");
                System.out.println("name,github_username,average");
                for (Map.Entry<String, Student> student : hash.entrySet()) {
                    System.out.printf("%s,%s,%.2f,%.2f\n", student.getValue().getName(), student.getKey(), student.getValue().getGradeAverage(), student.getValue().getAttendancePercentage());
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
        students.get("CJDPenguin").recordAttendance("2022-06-01", "P");
        students.get("CJDPenguin").recordAttendance("2022-06-02", "P");
        students.get("CJDPenguin").recordAttendance("2022-06-03", "A");
        students.get("CJDPenguin").recordAttendance("2022-06-04", "P");
        students.get("CJDPenguin").recordAttendance("2022-06-05", "P");
        students.get("JuliSimps").addGrade(98);
        students.get("JuliSimps").addGrade(99);
        students.get("JuliSimps").addGrade(100);
        students.get("JuliSimps").addGrade(97);
        students.get("JuliSimps").addGrade(94);
        students.get("JuliSimps").recordAttendance("2022-06-01", "P");
        students.get("JuliSimps").recordAttendance("2022-06-02", "P");
        students.get("JuliSimps").recordAttendance("2022-06-03", "P");
        students.get("JuliSimps").recordAttendance("2022-06-04", "A");
        students.get("JuliSimps").recordAttendance("2022-06-05", "P");
        students.get("LuckyChucky").addGrade(60);
        students.get("LuckyChucky").addGrade(80);
        students.get("LuckyChucky").addGrade(85);
        students.get("LuckyChucky").addGrade(55);
        students.get("LuckyChucky").addGrade(90);
        students.get("LuckyChucky").recordAttendance("2022-06-01", "P");
        students.get("LuckyChucky").recordAttendance("2022-06-02", "A");
        students.get("LuckyChucky").recordAttendance("2022-06-03", "P");
        students.get("LuckyChucky").recordAttendance("2022-06-04", "P");
        students.get("LuckyChucky").recordAttendance("2022-06-05", "A");
        students.get("ScarriTerri").addGrade(84);
        students.get("ScarriTerri").addGrade(89);
        students.get("ScarriTerri").addGrade(76);
        students.get("ScarriTerri").addGrade(93);
        students.get("ScarriTerri").addGrade(100);
        students.get("ScarriTerri").recordAttendance("2022-06-01", "P");
        students.get("ScarriTerri").recordAttendance("2022-06-02", "P");
        students.get("ScarriTerri").recordAttendance("2022-06-03", "P");
        students.get("ScarriTerri").recordAttendance("2022-06-04", "P");
        students.get("ScarriTerri").recordAttendance("2022-06-05", "P");
        students.get("AlwaysAdam").addGrade(69);
        students.get("AlwaysAdam").addGrade(64);
        students.get("AlwaysAdam").addGrade(69);
        students.get("AlwaysAdam").addGrade(71);
        students.get("AlwaysAdam").addGrade(79);
        students.get("AlwaysAdam").recordAttendance("2022-06-01", "A");
        students.get("AlwaysAdam").recordAttendance("2022-06-02", "A");
        students.get("AlwaysAdam").recordAttendance("2022-06-03", "A");
        students.get("AlwaysAdam").recordAttendance("2022-06-04", "P");
        students.get("AlwaysAdam").recordAttendance("2022-06-05", "A");

        System.out.println("Welcome to the Eighties Gradies Academic Performance Tracking Application");
        studentDetails(students);
    }
}
