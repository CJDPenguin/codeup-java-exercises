package grades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private final String name;
    private final ArrayList<Integer> grades;
    private final HashMap<String, String> attendance;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
        this.attendance = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade){
        this.grades.add(grade);
    }

    public void recordAttendance (String date, String presence) {
        if (presence.equalsIgnoreCase("A") || presence.equalsIgnoreCase("P")) {
            this.attendance.put(date, presence);
        }
    }

    public ArrayList<Integer> getGrades(){
        return this.grades;
    }

    public HashMap<String, String> getAttendance() {
        return this.attendance;
    }

    public ArrayList<String> getAbsences() {
        ArrayList<String> absences = new ArrayList<>();
        for (Map.Entry<String, String> day : this.attendance.entrySet()) {
            if (day.getValue().equalsIgnoreCase("A")) {
                absences.add(day.getKey());
            }
        }
        return absences;
    }

    public double getAttendancePercentage(){
        double attended = 0;
        double days = 0;
        for (Map.Entry<String, String> day : this.attendance.entrySet()) {
            if (day.getValue().equalsIgnoreCase("P")) {
                attended++;
            }
            days++;
        }
        return (attended / days) * 100;
    }

    public double getGradeAverage(){
        double gradeSum = 0;
        for ( int grade : this.grades) {
            gradeSum += grade;
        }
        return gradeSum / this.grades.size();
    }
}
