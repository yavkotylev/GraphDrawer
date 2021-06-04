package model.internalmodel.coordinates;

public class Coordinates {
    private final double x;
    private final double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinates)) {
            return false;
        }
        Coordinates co = (Coordinates) obj;
        return x == co.x && y == co.y;
    }
}
