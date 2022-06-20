package shapes;

public class Square extends Rectangle {
    public void squareSide(double side) {
        setDimensions(side, side);
    }

    @Override
    public double getArea() {
        return 4 * this.getLength();
    }

    @Override
    public double getPerimeter() {
        return Math.pow(this.getLength(), 2);
    }
}
