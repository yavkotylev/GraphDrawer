package model.internalmodel.trace;

import java.awt.*;
import java.util.Random;

public class EventType {
    private final String id;
    private final String name;
    private long importance = 0;
    private final Color color;

    public EventType(String id, String name) {
        this.id = id;
        this.name = name;
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        this.color = new Color(r, g, b);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getImportance() {
        return importance;
    }

    public void setImportance(long importance) {
        this.importance = importance;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EventType) {
            return this.id.equals(((EventType) obj).getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
