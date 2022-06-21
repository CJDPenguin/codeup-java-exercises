package grades;

import java.util.ArrayList;

public class Student {
    private final String name;
    private final ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade){
        this.grades.add(grade);
    }

    public ArrayList<Integer> getGrades(){
        return this.grades;
    }

    public double getGradeAverage(){
        double gradeSum = 0;
        for ( int grade : this.grades) {
            gradeSum += grade;
        }
        return gradeSum / this.grades.size();
    }
}
