package shapes;

public class ShapesTest {
    public static void main(String[] args) {
        Measureable myShape = new Rectangle(4, 5);

        System.out.println(myShape.getArea());
        System.out.println(myShape.getPerimeter());

        Measureable mySquare = new Square(5);

        System.out.println(mySquare.getArea());
        System.out.println(mySquare.getPerimeter());


    }
}
