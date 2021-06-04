package model.internalmodel;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import guru.nidi.graphviz.model.MutableGraph;
import model.internalmodel.coordinates.Coordinates;
import model.internalmodel.coordinates.CoordinatesGetter;
import model.GraphBuilder;
import model.internalmodel.coordinates.NodeCoordinates;
import model.internalmodel.interval.ActiveNetTime;
import model.internalmodel.net.BaseNet;
import model.internalmodel.net.SystemNet;
import model.internalmodel.trace.Trace;
import protobuf.run.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static utils.InternalUtils.*;

public class RunBuilder {
    private final GraphBuilder graphBuilder;
    private final SystemNet systemNet;
    private final Trace trace;
    private final Map<String, ActiveNetTime> activeNetTimeMap;

    public RunBuilder(SystemNet systemNet, Trace trace, Map<String, ActiveNetTime> activeNetTimeMap) {
        this.graphBuilder = new GraphBuilder();
        this.systemNet = systemNet;
        this.trace = trace;
        this.activeNetTimeMap = activeNetTimeMap;
    }

    public Run buildRun() {
        safeParallelStream(systemNet.getAgentNets())
                .forEach(this::addCoordinates);
        addCoordinates(systemNet);
        return Run.newBuilder()
                .addAllNetActions(getNetActions(trace))
                .setNet(buildNet())
                .setEndTime(trace.getEndTime())
                .build();
    }


    private void addCoordinates(BaseNet baseNet) {
        BiMap<String, String> idDictionary = getDictionary(baseNet);
        MutableGraph mutableGraph = graphBuilder.buildGraph(baseNet, idDictionary);
        BiMap<String, String> inversed = idDictionary.inverse();
        CoordinatesGetter coordinatesGetter = new CoordinatesGetter(mutableGraph, inversed);
        baseNet.getPlaces().forEach((placeId, place) -> {
            NodeCoordinates placeCoordinate = coordinatesGetter.getNodeCoordinate(placeId);
            place.setX(placeCoordinate.getX());
            place.setY(placeCoordinate.getY());
            place.setWidth(placeCoordinate.getWidth());
            place.setHeight(placeCoordinate.getHeight());
        });

        baseNet.getTransitions().forEach((transitionId, transition) -> {
            NodeCoordinates transitionCoordinates = coordinatesGetter.getNodeCoordinate(transitionId);
            transition.setX(transitionCoordinates.getX());
            transition.setY(transitionCoordinates.getY());
            transition.setWidth(transitionCoordinates.getWidth());
            transition.setHeight(transitionCoordinates.getHeight());
        });

        baseNet.getArcs().forEach((arcId, arc) -> {
            List<Coordinates> coordinatesList = coordinatesGetter.getArcCoordinate(arcId);
            LinkedList<Coordinates> arcCoordinates = new LinkedList<>();
            for (int i = 1; i < coordinatesList.size(); i++) {
                arcCoordinates.addLast(coordinatesList.get(i));
            }
            arcCoordinates.addLast(coordinatesList.get(0));
            arc.setCoordinates(arcCoordinates);
        });
        baseNet.setPositionX(coordinatesGetter.getPositionX());
        baseNet.setPositionY(coordinatesGetter.getPositionY());
    }

    private List<NetAction> getNetActions(Trace trace) {
        List<NetAction> netActions = new ArrayList<>();
        trace.getNetActions().forEach((netId, actions) -> {
            NetAction.Builder builder = NetAction.newBuilder()
                    .setNetId(netId);
            safeStream(actions)
                    .forEach(action -> {
                        Color color = action.getEventType().getColor();
                        protobuf.run.Color.Builder colorBuilder = protobuf.run.Color.newBuilder()
                                .setR(color.getRed())
                                .setG(color.getGreen())
                                .setB(color.getBlue());
                        Action.Builder protoActionBuilder = Action.newBuilder()
                                .setStartTime(action.getTime())
                                .setEventTypeId(action.getEventType().getId())
                                .setViaTransitionId(action.getTransitionId())
                                .setColor(colorBuilder);
                        safeStream(action.getRemoveTokens())
                                .map(tokenMove -> buildTokenMove(tokenMove.getTokenId(), tokenMove.getPlaceId()))
                                .forEach(protoActionBuilder::addRemoveTokens);
                        safeStream(action.getAddTokens())
                                .map(tokenMove -> buildTokenMove(tokenMove.getTokenId(), tokenMove.getPlaceId()))
                                .forEach(protoActionBuilder::addAddTokens);
                        builder.addActions(protoActionBuilder);
                    });
            netActions.add(builder.build());
        });
        return netActions;
    }

    private TokenMove.Builder buildTokenMove(String tokenId, String placeId) {
        return TokenMove.newBuilder()
                .setTokenId(tokenId)
                .setPlaceId(placeId);
    }

    private Net.Builder buildNet() {
        return Net.newBuilder()
                .setId(systemNet.getId())
                .setName(safeString(systemNet.getName()))
                .addAllPlaces(buildPlaces(systemNet))
                .addAllTransitions(buildTransitions(systemNet))
                .addAllArcs(buildArcs(systemNet))
                .addAllTokens(buildTokens(systemNet))
                .addAllInitialMarking(buildInitialMarkings(systemNet))
                .addAllAgentNets(buildAgentNets())
                .setPositionX(systemNet.getPositionX())
                .setPositionY(systemNet.getPositionY());
    }

    private List<Place> buildPlaces(BaseNet baseNet) {
        return safeStream(baseNet.getPlaces().values())
                .map(internalPlace -> Place.newBuilder()
                        .setId(internalPlace.getId())
                        .setName(safeString(internalPlace.getName()))
                        .setX(internalPlace.getX())
                        .setY(internalPlace.getY())
                        .setWidth(internalPlace.getWidth())
                        .setHeight(internalPlace.getHeight())
                        .build()
                ).collect(Collectors.toList());
    }

    private List<Transition> buildTransitions(BaseNet baseNet) {
        return safeStream(baseNet.getTransitions().values())
                .map(internalTransition -> Transition.newBuilder()
                        .setId(internalTransition.getId())
                        .setName(safeString(internalTransition.getName()))
                        .setX(internalTransition.getX())
                        .setY(internalTransition.getY())
                        .setWidth(internalTransition.getWidth())
                        .setHeight(internalTransition.getHeight())
                        .build()
                ).collect(Collectors.toList());
    }

    private List<Arc> buildArcs(BaseNet baseNet) {
        return safeStream(baseNet.getArcs().values())
                .map(internalArc -> Arc.newBuilder()
                        .setId(internalArc.getId())
                        .setName(safeString(internalArc.getName()))
                        .setSourceId(internalArc.getSourceId())
                        .setTargetId(internalArc.getTargetId())
                        .addAllCoordinates(safeStream(internalArc.getCoordinatesList())
                                .map(internalCoordinate -> Coordinate.newBuilder()
                                        .setX(internalCoordinate.getX())
                                        .setY(internalCoordinate.getY())
                                        .build())
                                .collect(Collectors.toList()))
                        .build()
                ).collect(Collectors.toList());
    }

    private List<Token> buildTokens(BaseNet baseNet) {
        return safeStream(baseNet.getTokens().values())
                .map(internalToken -> {
                    Token.Builder builder = Token.newBuilder()
                            .setId(internalToken.getId())
                            .setName(safeString(internalToken.getName()))
                            .setAgentNet(safeString(internalToken.getAgentNetId()));
                    if (internalToken.getColor() != null) {
                        builder.setColor(internalToken.getColor());
                    }
                    return builder.build();
                })
                .collect(Collectors.toList());
    }

    private List<InitialMarking> buildInitialMarkings(BaseNet baseNet) {
        List<InitialMarking> initialMarkings = new ArrayList<>();
        baseNet.getInitialMarking().forEach((tokenId, placeId) ->
                initialMarkings.add(InitialMarking.newBuilder()
                        .setTokenId(tokenId)
                        .setPlaceId(placeId)
                        .build()));
        return initialMarkings;
    }

    private List<AgentNet> buildAgentNets() {
        return safeStream(systemNet.getAgentNets())
                .map(internalAgentNet -> AgentNet.newBuilder()
                        .setId(internalAgentNet.getId())
                        .setName(safeString(internalAgentNet.getName()))
                        .addAllPlaces(buildPlaces(internalAgentNet))
                        .addAllTransitions(buildTransitions(internalAgentNet))
                        .addAllArcs(buildArcs(internalAgentNet))
                        .addAllTokens(buildTokens(internalAgentNet))
                        .addAllInitialMarking(buildInitialMarkings(internalAgentNet))
                        .addAllActiveIntervals(buildActiveIntervals(internalAgentNet.getId()))
                        .setPositionX(internalAgentNet.getPositionX())
                        .setPositionY(internalAgentNet.getPositionY())
                        .build())
                .collect(Collectors.toList());
    }

    private List<ActiveInterval> buildActiveIntervals(String agentNetId) {
        return safeStream(activeNetTimeMap.get(agentNetId).getActiveIntervals())
                .map(internalActiveInterval -> ActiveInterval.newBuilder()
                        .setStartTime(internalActiveInterval.getStartTime())
                        .setEndTime(internalActiveInterval.getEndTime())
                        .build())
                .collect(Collectors.toList());
    }

    private BiMap<String, String> getDictionary(BaseNet baseNet) {
        BiMap<String, String> dictionary = HashBiMap.create();
        int count = 100;
        for (String placeId : baseNet.getPlaces().keySet()) {
            dictionary.put(placeId, "p" + count++);
        }
        count = 100;
        for (String transitionId : baseNet.getTransitions().keySet()) {
            dictionary.put(transitionId, "t" + count++);
        }

        count = 100;
        for (String arcId : baseNet.getArcs().keySet()) {
            dictionary.put(arcId, "a" + count++);
        }
        return dictionary;
    }
}
