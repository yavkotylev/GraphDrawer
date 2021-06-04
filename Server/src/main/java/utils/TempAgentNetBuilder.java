package utils;

import protobuf.usernet.AgentNet;
import protobuf.usernet.InitialMarking;
import protobuf.usernet.Token;

public class TempAgentNetBuilder {
    private final String agentNetId;

    public TempAgentNetBuilder(String agentNetId) {
        this.agentNetId = agentNetId;
    }

    public AgentNet.Builder getAgentNet() {
        AgentNet.Builder builder = AgentNet.newBuilder();
        addInitialMarking(builder);
        return builder
                .setId(agentNetId)
                .setName("my " + agentNetId + " agentNet")
                .addPlaces(Temp.placeBuilder(modify("p1"), modify("firstPlace")))
                .addTransitions(Temp.transitionBuilder(modify("t1"), modify("first Transition")))
                .addArcs(Temp.arcBuilder(modify("a1"), modify("arc1"), modify("p1"), modify("t1")))
                .addPlaces(Temp.placeBuilder(modify("p2"), modify("secondPlace")))
                .addPlaces(Temp.placeBuilder(modify("p3"), modify("thirdPlace")))
                .addArcs(Temp.arcBuilder(modify("a2"), modify("arc2"), modify("t1"), modify("p2")))
                .addArcs(Temp.arcBuilder(modify("a3"), modify("arc3"), modify("t1"), modify("p3")))
                .addTransitions(Temp.transitionBuilder(modify("t2"), modify("second Transition")))
                .addArcs(Temp.arcBuilder(modify("a4"), modify("arc4"), modify("p2"), modify("t2")))
                .addArcs(Temp.arcBuilder(modify("a5"), modify("arc5"), modify("p3"), modify("t2")))
                .addPlaces(Temp.placeBuilder(modify("p4"), modify("fourth place")))
                .addArcs(Temp.arcBuilder(modify("a6"), modify("arc6"), modify("t2"), modify("p4")))
                .addTransitions(Temp.transitionBuilder(modify("t3"), modify("third Transition")))
                .addArcs(Temp.arcBuilder(modify("a7"), modify("arc7"), modify("p4"), modify("t3")))
                .addArcs(Temp.arcBuilder(modify("a8"), modify("arc8"), modify("t3"), modify("p1")))
                .setStartPlaceId(modify("p1"))
                .addTokens(getToken("tn1"));
    }


    private void addInitialMarking(AgentNet.Builder builder) {
        builder.addInitialMarking(getInitialMarking("p1", "tn1"));
    }

    private InitialMarking.Builder getInitialMarking(String placeId, String tokenId) {
        return InitialMarking.newBuilder()
                .setPlaceId(modify(placeId))
                .setTokenId(modify(tokenId));
    }

    private Token.Builder getToken(String tokenId) {
        return Token.newBuilder()
                .setId(modify(tokenId))
                .setName("tokenName " + modify(tokenId));
    }

    private String modify(String baseId) {
        return agentNetId + baseId;
    }
}
