package shapes;

public class ShapesTest {
    public static void main(String[] args) {
        Measurable myShape = new Rectangle(4, 5);

        System.out.println(myShape.getArea());
        System.out.println(myShape.getPerimeter());

        Measurable mySquare = new Square(5);

        System.out.println(mySquare.getArea());
        System.out.println(mySquare.getPerimeter());


    }
}
