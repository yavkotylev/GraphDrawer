package model.internalmodel.net;

public class BaseElement {
    private final String id;
    private String name;

    public BaseElement(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
