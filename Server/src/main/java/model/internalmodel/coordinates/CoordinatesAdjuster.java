package model.internalmodel.coordinates;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CoordinatesAdjuster {
    private final double positionX;
    private final double positionY;
    private final double upY;
    private final double adjustX;
    private final double adjustY;

    public CoordinatesAdjuster(Map<String, NodeCoordinates> coordinatesMap, Map<String, List<Coordinates>> arcCoordinates) {
        double leftX = Double.MAX_VALUE;
        double rightX = Double.MIN_VALUE;
        double upY = Double.MIN_VALUE;
        double downY = Double.MAX_VALUE;
        for (NodeCoordinates nodeCoordinate : coordinatesMap.values()) {
            downY = Math.min(downY, nodeCoordinate.getY() - nodeCoordinate.getHeight() / 2);
            upY = Math.max(upY, nodeCoordinate.getY() + nodeCoordinate.getHeight() / 2);
            rightX = Math.max(rightX, nodeCoordinate.getX() + nodeCoordinate.getWidth() / 2);
            leftX = Math.min(leftX, nodeCoordinate.getX() - nodeCoordinate.getWidth() / 2);
        }
        double nodeWidth = coordinatesMap.values().stream().findFirst().get().getWidth();
        double nodeHeight = coordinatesMap.values().stream().findFirst().get().getHeight();
        for (List<Coordinates> list : arcCoordinates.values()) {
            for (Coordinates arcCoordinate : list) {
                downY = Math.min(downY, arcCoordinate.getY());
                upY = Math.max(upY, arcCoordinate.getY());
                rightX = Math.max(rightX, arcCoordinate.getX());
                leftX = Math.min(leftX, arcCoordinate.getX());
            }
        }
        this.adjustX = nodeWidth - leftX;
        this.adjustY = nodeHeight - downY;
        this.upY = upY;
        this.positionX = rightX + adjustX + nodeWidth;
        this.positionY = upY + adjustY + nodeHeight;
    }

    public Map<String, NodeCoordinates> adjustNodeCoordinates(Map<String, NodeCoordinates> coordinatesMap) {
        Map<String, NodeCoordinates> adjustedVales = new HashMap<>();
        coordinatesMap.forEach((id, node) ->
                adjustedVales.put(id, new NodeCoordinates(node.getX() + adjustX, (upY - node.getY()) + adjustY,
                        node.getWidth(), node.getHeight())));
        return adjustedVales;
    }

    public Map<String, List<Coordinates>> adjustArcCoordinates(Map<String, List<Coordinates>> arcCoordinates) {
        Map<String, List<Coordinates>> adjustedVales = new HashMap<>();
        arcCoordinates.forEach((id, listCoordinates) -> {
            LinkedList<Coordinates> resultCoordinates = new LinkedList<>();
            listCoordinates.forEach(coordinate ->
                    resultCoordinates.add(new Coordinates(coordinate.getX() + adjustX,
                            (upY - coordinate.getY()) + adjustY)));
            adjustedVales.put(id, resultCoordinates);
        });
        return adjustedVales;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }
}
