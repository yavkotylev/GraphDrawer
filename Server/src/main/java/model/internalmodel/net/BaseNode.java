package model.internalmodel.net;

public class BaseNode extends BaseElement {
    public BaseNode(String id) {
        super(id);
    }

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
