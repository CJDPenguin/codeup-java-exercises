package shapes;

public class Square extends Quadrilateral {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public double getPerimeter() {
        return getLength() * 4;
    }

    @Override
    public double getArea() {
        return Math.pow(this.getLength(), 2);
    }

    @Override
    public void setLength() {
    }

    @Override
    public void setWidth() {
    }
}
