package model.internalmodel.trace;

import java.util.LinkedList;
import java.util.List;

public class Action {
    private final long time;
    private final EventType eventType;
    private final String transitionId;
    private final List<TokenMove> removeTokens = new LinkedList<>();
    private final List<TokenMove> addTokens = new LinkedList<>();

    public Action(long time, EventType eventType, String transitionId) {
        this.time = time;
        this.eventType = eventType;
        this.transitionId = transitionId;
    }

    public String getTransitionId() {
        return transitionId;
    }

    public List<TokenMove> getRemoveTokens() {
        return removeTokens;
    }

    public List<TokenMove> getAddTokens() {
        return addTokens;
    }

    public long getTime() {
        return time;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void addRemoveToken(String tokenId, String placeId) {
        removeTokens.add(new TokenMove(tokenId, placeId));
    }

    public void addAddToken(String tokenId, String placeId) {
        addTokens.add(new TokenMove(tokenId, placeId));
    }
}
