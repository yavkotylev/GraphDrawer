package model.internalmodel.net;

import protobuf.run.Color;
import protobuf.usernet.UserNet;
import utils.InternalUtils;

import java.util.List;
import java.util.stream.Collectors;

public class InternalModelNetBuilder {
    public SystemNet buildSystemNetFromProtobuf(UserNet userNet) {
        SystemNet systemNet = new SystemNet(userNet.getId());
        if (userNet.hasName()) {
            systemNet.setName(userNet.getName());
        }
        systemNet.addAllPlaces(getAllPlaces(userNet.getPlacesList()));
        systemNet.setStartPlaceId(userNet.getStartPlaceId());
        systemNet.addAllTransitions(getAllTransitions(userNet.getTransitionsList()));
        systemNet.addAllArcs(getAllArcs(userNet.getArcsList()));
        systemNet.addAllTokens(getAllTokens(userNet.getTokensList()));
        systemNet.addAllInitialMarkings(userNet.getInitialMarkingList());
        systemNet.addAllAgentNets(getAllAgentNets(userNet.getAgentNetsList()));
        return systemNet;
    }

    private List<AgentNet> getAllAgentNets(List<protobuf.usernet.AgentNet> protoAgentNets) {
        return InternalUtils.safeStream(protoAgentNets)
                .map(protoAgentNet -> {
                    AgentNet agentNet = new AgentNet(protoAgentNet.getId());
                    if (protoAgentNet.hasName()) {
                        agentNet.setName(protoAgentNet.getName());
                    }
                    agentNet.setStartPlaceId(protoAgentNet.getStartPlaceId());
                    agentNet.addAllPlaces(getAllPlaces(protoAgentNet.getPlacesList()));
                    agentNet.addAllTransitions(getAllTransitions(protoAgentNet.getTransitionsList()));
                    agentNet.addAllArcs(getAllArcs(protoAgentNet.getArcsList()));
                    agentNet.addAllTokens(getAllTokens(protoAgentNet.getTokensList()));
                    agentNet.addAllInitialMarkings(protoAgentNet.getInitialMarkingList());
                    if (protoAgentNet.hasThreshold()) {
                        agentNet.setThreshold(protoAgentNet.getThreshold());
                    }
                    if (protoAgentNet.hasIntervalDuration()) {
                        agentNet.setIntervalDuration(protoAgentNet.getIntervalDuration());
                    }
                    return agentNet;
                }).collect(Collectors.toList());
    }

    private List<Place> getAllPlaces(List<protobuf.usernet.Place> protoPlaces) {
        return InternalUtils.safeStream(protoPlaces)
                .map(protoPlace -> {
                    Place place = new Place(protoPlace.getId());
                    if (protoPlace.hasName()) {
                        place.setName(protoPlace.getName());
                    }
                    if (protoPlace.hasX()) {
                        place.setX(protoPlace.getX());
                    }
                    if (protoPlace.hasY()) {
                        place.setY(protoPlace.getY());
                    }
                    return place;
                }).collect(Collectors.toList());
    }

    private List<Transition> getAllTransitions(List<protobuf.usernet.Transition> protoTransitions) {
        return InternalUtils.safeStream(protoTransitions)
                .map(protoTransition -> {
                    Transition transition = new Transition(protoTransition.getId());
                    if (protoTransition.hasName()) {
                        transition.setName(protoTransition.getName());
                    }
                    if (protoTransition.hasX()) {
                        transition.setX(protoTransition.getX());
                    }
                    if (protoTransition.hasY()) {
                        transition.setY(protoTransition.getY());
                    }
                    return transition;
                }).collect(Collectors.toList());
    }

    private List<Arc> getAllArcs(List<protobuf.usernet.Arc> protoArcs) {
        return InternalUtils.safeStream(protoArcs)
                .map(protoArc -> {
                    Arc arc = new Arc(protoArc.getId());
                    if (protoArc.hasName()) {
                        arc.setName(protoArc.getName());
                    }
                    arc.setSourceId(protoArc.getSourceId());
                    arc.setTargetId(protoArc.getTargetId());
                    return arc;
                }).collect(Collectors.toList());
    }

    private List<Token> getAllTokens(List<protobuf.usernet.Token> protoTokens) {
        return InternalUtils.safeStream(protoTokens)
                .map(protoToken -> {
                    Token token = new Token(protoToken.getId());
                    if (protoToken.hasName()) {
                        token.setName(protoToken.getName());
                    }
                    if (protoToken.hasAgentNet()) {
                        token.setAgentNetId(protoToken.getAgentNet());
                    }
                    if (protoToken.hasColor()) {
                        token.setColor(Color.newBuilder()
                                .setR(protoToken.getColor().getR())
                                .setG(protoToken.getColor().getG())
                                .setB(protoToken.getColor().getB())
                                .build());
                    }
                    return token;
                }).collect(Collectors.toList());
    }
}
