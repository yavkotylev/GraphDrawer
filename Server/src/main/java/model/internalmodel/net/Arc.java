package model.internalmodel.net;

import model.internalmodel.coordinates.Coordinates;

import java.util.LinkedList;

public class Arc extends BaseElement {
    private String sourceId;
    private String targetId;
    private final LinkedList<Coordinates> coordinatesList = new LinkedList<>();

    public Arc(String id) {
        super(id);
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setCoordinates(LinkedList<Coordinates> coordinates) {
        coordinatesList.clear();
        coordinatesList.addAll(coordinates);
    }

    public LinkedList<Coordinates> getCoordinatesList() {
        return coordinatesList;
    }
}
