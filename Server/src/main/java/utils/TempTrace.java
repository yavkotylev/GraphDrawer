package utils;

import protobuf.usertrace.Action;
import protobuf.usertrace.EventType;
import protobuf.usertrace.NetAction;
import protobuf.usertrace.TokenMove;
import protobuf.usertrace.UserTrace;

import java.util.ArrayList;
import java.util.List;

public class TempTrace {

    private final static int length = 200;
    private final static String SYSTEM_NET_ID = "systemNet";

    public static UserTrace testTrace() {
        UserTrace.Builder traceBuilder = UserTrace.newBuilder()
                .setEndTime(length);
        List<EventType.Builder> eventTypes = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            EventType.Builder eventTypeBuilder = EventType.newBuilder()
                    .setId(i + "Type")
                    .setName("event " + i + "-th class")
                    .setImportance(getRandomNumber(0, 5));
            eventTypes.add(eventTypeBuilder);
            traceBuilder.addEventTypes(eventTypeBuilder);
        }

        List<String> netIds = new ArrayList<>();
        netIds.add(SYSTEM_NET_ID);
        netIds.add("student_1");
        //netIds.add("agentNet2");
        //netIds.add("agentNet3");
        //netIds.add("agentNet4");
        //netIds.add("agentNet5");

        traceBuilder.addActions(getSystemNetActionBuilder(eventTypes));
        traceBuilder.addActions(getAgentNetActionBuilder(eventTypes));

        return traceBuilder.build();
    }

    public static NetAction.Builder getSystemNetActionBuilder(List<EventType.Builder> eventTypes) {
        NetAction.Builder netActionBuilder = NetAction.newBuilder()
                .setNetId(SYSTEM_NET_ID);
        long second = 25;
        Action.Builder action = buildAction(second, eventTypes.get(getRandomNumber(0, 10)).getId());
        addRemoveAddTokens(action, SYSTEM_NET_ID, "p1", "p3",
                "t1", "tn1");
        netActionBuilder.addActions(action);
        return netActionBuilder;
    }

    public static NetAction.Builder getAgentNetActionBuilder(List<EventType.Builder> eventTypes) {
        NetAction.Builder netActionBuilder = NetAction.newBuilder()
                .setNetId("student_1");
        long second = 25;
        Action.Builder action = buildAction(second, eventTypes.get(getRandomNumber(0, 10)).getId());
        addRemoveAddTokens(action, "student_1", "st1_p1", "st1_p2",
                "st1_t1", "st1_tn1");
        netActionBuilder.addActions(action);
        return netActionBuilder;
    }

    static Action.Builder buildAction(long seconds, String eventTypeId) {
        return Action.newBuilder()
                .setStartTime(seconds)
                .setEventTypeId(eventTypeId);
    }

    private static void addRemoveAddTokens(Action.Builder action, String netId,
                                           String placeFromId,
                                           String placeToId,
                                           String transitionId,
                                           String tokenId) {
        action.addRemoveTokens(
                TokenMove.newBuilder()
                        .setPlaceId(placeFromId)
                        .setTokenId(tokenId))
                .addAddTokens(TokenMove.newBuilder()
                        .setPlaceId(placeToId)
                        .setTokenId(tokenId))
                .setViaTransitionId(transitionId);
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
