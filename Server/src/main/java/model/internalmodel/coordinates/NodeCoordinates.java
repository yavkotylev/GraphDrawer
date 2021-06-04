package model.internalmodel.coordinates;

public class NodeCoordinates {
    private final double x;
    private final double y;
    private final double width;
    private final double height;

    public NodeCoordinates(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
