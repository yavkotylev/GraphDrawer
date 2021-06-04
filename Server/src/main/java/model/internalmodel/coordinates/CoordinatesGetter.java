package model.internalmodel.coordinates;

import com.google.common.collect.BiMap;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sender.RunSender;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CoordinatesGetter {

    private final Map<String, NodeCoordinates> nodeCoordinates;
    private final Map<String, List<Coordinates>> arcCoordinates;
    private final double xPosition;
    private final double yPosition;

    public CoordinatesGetter(MutableGraph mutableGraph, BiMap<String, String> inversed) {
        String jsonString = Graphviz.fromGraph(mutableGraph)
                .render(Format.JSON)
                .toString();
        //TODO: remove
        RunSender runSender = new RunSender();
        //runSender.saveToFile(jsonString, "mutGraph");
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            Map<String, NodeCoordinates> nodeCoordinatesMap = getNodesCoordinates(jsonObject, inversed);
            Map<String, List<Coordinates>> arcCoordinates = getArcsCoordinates(jsonObject, inversed);
            CoordinatesAdjuster coordinatesAdjuster = new CoordinatesAdjuster(nodeCoordinatesMap, arcCoordinates);
            this.nodeCoordinates = coordinatesAdjuster.adjustNodeCoordinates(nodeCoordinatesMap);
            this.arcCoordinates = coordinatesAdjuster.adjustArcCoordinates(arcCoordinates);
            this.xPosition = coordinatesAdjuster.getPositionX();
            this.yPosition = coordinatesAdjuster.getPositionY();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public NodeCoordinates getNodeCoordinate(String nodeId) {
        return this.nodeCoordinates.get(nodeId);
    }

    public List<Coordinates> getArcCoordinate(String arcId) {
        return this.arcCoordinates.get(arcId);
    }

    public double getPositionX() {
        return xPosition;
    }

    public double getPositionY() {
        return yPosition;
    }

    private Map<String, NodeCoordinates> getNodesCoordinates(JSONObject jsonObject, BiMap<String, String> inversed) {
        Map<String, NodeCoordinates> nodeCoordinates = new HashMap<>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("objects");
        for (Object jsonElement : jsonArray) {
            JSONObject node = (JSONObject) jsonElement;
            String id = (String) node.get("name");
            String position = (String) node.get("pos");
            String[] positions = position.split(",");
            double x = Double.parseDouble(positions[0]);
            double y = Double.parseDouble(positions[1]);
            JSONArray draw = (JSONArray) node.get("_draw_");
            for (Object drawObject : draw) {
                JSONObject drawJSONObject = (JSONObject) drawObject;
                if ((drawJSONObject.get("op")).equals("p")) {
                    JSONArray pointsJsonArray = (JSONArray) drawJSONObject.get("points");
                    JSONArray zero = (JSONArray) pointsJsonArray.get(0);
                    JSONArray first = (JSONArray) pointsJsonArray.get(1);
                    JSONArray second = (JSONArray) pointsJsonArray.get(2);
                    double width = Math.abs((Double) zero.get(0) - (Double) first.get(0));
                    double height = Math.abs((Double) zero.get(1) - (Double) second.get(1));
                    nodeCoordinates.put(inversed.get(id), new NodeCoordinates(x, y, width, height));
                } else if ((drawJSONObject.get("op")).equals("e")) {
                    JSONArray rectArray = (JSONArray) drawJSONObject.get("rect");
                    double width = (Double) rectArray.get(2) * 2;
                    double height = (Double) rectArray.get(3) * 2;
                    nodeCoordinates.put(inversed.get(id), new NodeCoordinates(x, y, width, height));
                }
            }
        }
        return nodeCoordinates;
    }

    private Map<String, List<Coordinates>> getArcsCoordinates(JSONObject jsonObject,
                                                              BiMap<String, String> inversed) {
        Map<String, List<Coordinates>> arcsCoordinates = new HashMap<>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("edges");
        for (Object jsonElement : jsonArray) {
            JSONObject node = (JSONObject) jsonElement;
            String id = (String) node.get("label");
            String[] positions = ((String) node.get("pos")).split(" ");
            List<Coordinates> coordinates = new LinkedList<>();
            String[] first = positions[0].split(",");
            if (!first[0].equals("e")) {
                throw new RuntimeException("not e, kek!");
            }
            positions[0] = first[1] + "," + first[2];
            for (String position : positions) {
                String[] coord = position.split(",");
                double x = Double.parseDouble(coord[0]);
                double y = Double.parseDouble(coord[1]);
                Coordinates newCoord = new Coordinates(x, y);
                if (!coordinates.contains(newCoord)) {
                    coordinates.add(newCoord);
                }
            }
            arcsCoordinates.put(inversed.get(id), coordinates);
        }
        return arcsCoordinates;
    }
}
