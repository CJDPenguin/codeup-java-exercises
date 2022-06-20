package shapes;

public class ShapesTest {
    public static void main(String[] args) {
        Rectangle box1 = new Rectangle();
        box1.setDimensions(5, 4);

        System.out.println(box1.getPerimeter());
        System.out.println(box1.getArea());

        Square box2 = new Square();
        box2.squareSide(5);

        System.out.println(box2.getPerimeter());
        System.out.println(box2.getArea());
    }
}
