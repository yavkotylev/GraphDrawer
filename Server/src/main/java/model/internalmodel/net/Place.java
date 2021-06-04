package model.internalmodel.net;

public class Place extends BaseNode {
    private double width;
    private double height;

    public Place(String id) {
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
