package model.internalmodel.trace;

import java.util.*;

public class Trace {
    private final long endTime;
    private final Map<String, List<Action>> netActions = new HashMap<>();
    private final Map<String, EventType> eventTypes = new HashMap<>();

    public Trace(long endTime) {
        this.endTime = endTime;
    }

    public void setEventTypeImportance(String eventTypeId, long importance) {
        eventTypes.get(eventTypeId).setImportance(importance);
    }

    public void addNetActions(String netId, List<Action> actions) {
        netActions.put(netId, actions);
    }

    public void putEventType(EventType eventType) {
        eventTypes.put(eventType.getId(), eventType);
    }

    public Collection<EventType> getEventTypes() {
        return eventTypes.values();
    }

    public Map<String, EventType> getEventTypeMap() {
        return eventTypes;
    }

    public long getEndTime() {
        return endTime;
    }

    public Map<String, List<Action>> getNetActions() {
        return netActions;
    }

    public List<Action> getNetAction(String netId) {
        return netActions.get(netId);
    }
}
