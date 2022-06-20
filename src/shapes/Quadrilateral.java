package shapes;

abstract class Quadrilateral extends Shape implements Measureable{
    private final double length;
    private final double width;

    public Quadrilateral(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public abstract double setLength();

    public double getWidth() {
        return width;
    }

    public abstract double setWidth();
}
