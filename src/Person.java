public class Person {

    private String name = "Dave";


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.printf("Hello, %s!", name);
    }


    public static void main(String[] args) {
        Person chris = new Person();
        chris.setName("Chris");
        chris.sayHello();
    }
}
