package grades;

public class StudentTest {
    public static void main(String[] args) {
        Student chris = new Student("Chris");
        Student julie = new Student("Julie");
        Student chuck = new Student("Chuck");

        chris.addGrade(90);
        chris.addGrade(90);
        chris.addGrade(90);

        System.out.println("------------");
        System.out.println(chris.getName());
        System.out.println(chris.getGradeAverage());

        julie.addGrade(100);
        julie.addGrade(100);
        julie.addGrade(95);
        julie.addGrade(100);

        System.out.println("------------");
        System.out.println(julie.getName());
        System.out.println(julie.getGradeAverage());

        chuck.addGrade(15);
        chuck.addGrade(45);
        chuck.addGrade(10);
        chuck.addGrade(84);
        chuck.addGrade(13);

        System.out.println("------------");
        System.out.println(chuck.getName());
        System.out.println(chuck.getGradeAverage());
    }

}
