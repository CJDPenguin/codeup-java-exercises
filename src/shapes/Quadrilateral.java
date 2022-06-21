package shapes;

abstract class Quadrilateral extends Shape implements Measureable{
    protected double length;
    protected double width;

    public Quadrilateral(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public abstract void setLength();

    public double getWidth() {
        return width;
    }

    public abstract void setWidth();
}
