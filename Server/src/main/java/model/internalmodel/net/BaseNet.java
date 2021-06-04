package model.internalmodel.net;

import protobuf.usernet.InitialMarking;
import utils.InternalUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseNet extends BaseElement {
    private String startPlaceId;
    private final Map<String, Place> places = new HashMap<>();
    private final Map<String, Transition> transitions = new HashMap<>();
    private final Map<String, Arc> arcs = new HashMap<>();
    private final Map<String, Token> tokens = new HashMap<>();
    private final Map<String, String> initialMarking = new HashMap<>();
    private double positionX;
    private double positionY;

    public BaseNet(String id) {
        super(id);
    }

    public String getStartPlaceId() {
        return startPlaceId;
    }

    public void setStartPlaceId(String startPlaceId) {
        this.startPlaceId = startPlaceId;
    }

    public void addPlace(Place place) {
        places.put(place.getId(), place);
    }

    public void addTransition(Transition transition) {
        transitions.put(transition.getId(), transition);
    }

    public Place getPlaceById(String placeId) {
        return places.get(placeId);
    }

    public Transition getTransitionById(String transitionId) {
        return transitions.get(transitionId);
    }

    public void addArc(Arc arc) {
        arcs.put(arc.getId(), arc);
    }

    public void addToken(Token token) {
        tokens.put(token.getId(), token);
    }

    public void addAllPlaces(List<Place> placeList) {
        placeList.forEach(place -> places.put(place.getId(), place));
    }

    public void addAllTransitions(List<Transition> transitionList) {
        transitionList.forEach(transition -> transitions.put(transition.getId(), transition));
    }

    public void addAllInitialMarkings(List<InitialMarking> protoInitialMarkings) {
        InternalUtils.safeStream(protoInitialMarkings)
                .forEach(protoInitMarking -> {
                    this.initialMarking.put(protoInitMarking.getTokenId(), protoInitMarking.getPlaceId());
                });
    }

    public Map<String, String> getInitialMarking() {
        return initialMarking;
    }

    public void addAllArcs(List<Arc> arcList) {
        arcList.forEach(arc -> arcs.put(arc.getId(), arc));
    }

    public void addAllTokens(List<Token> tokenList) {
        tokenList.forEach(token -> tokens.put(token.getId(), token));
    }

    public Map<String, Place> getPlaces() {
        return places;
    }

    public Map<String, Transition> getTransitions() {
        return transitions;
    }

    public Map<String, Arc> getArcs() {
        return arcs;
    }

    public Map<String, Token> getTokens() {
        return tokens;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }
}
