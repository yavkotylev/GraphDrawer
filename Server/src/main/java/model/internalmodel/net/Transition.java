package model.internalmodel.net;

public class Transition extends BaseNode {
    private double width;
    private double height;

    public Transition(String id) {
        super(id);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
