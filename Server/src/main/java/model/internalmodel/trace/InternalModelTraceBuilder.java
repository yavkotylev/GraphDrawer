package model.internalmodel.trace;

import utils.InternalUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InternalModelTraceBuilder {
    public Trace buildTrace(protobuf.usertrace.UserTrace protoTrace) {
        Trace trace = new Trace(protoTrace.getEndTime());
        protoTrace.getEventTypesList().forEach(protoEventType -> {
            EventType eventType = new EventType(protoEventType.getId(), protoEventType.getName());
            if (protoEventType.hasImportance()) {
                eventType.setImportance(protoEventType.getImportance());
            }
            trace.putEventType(eventType);
        });
        Map<String, EventType> eventTypeMap = trace.getEventTypeMap();
        protoTrace.getActionsList().forEach(protoNetAction -> {
            List<Action> actions = InternalUtils.safeStream(protoNetAction.getActionsList())
                    .map(protoAction -> {
                        Action action = new Action(protoAction.getStartTime(),
                                eventTypeMap.get(protoAction.getEventTypeId()), protoAction.getViaTransitionId());
                        protoAction.getRemoveTokensList().forEach(protoRemoveToken ->
                                action.addRemoveToken(protoRemoveToken.getTokenId(), protoRemoveToken.getPlaceId()));
                        protoAction.getAddTokensList().forEach(protoAddToken ->
                                action.addAddToken(protoAddToken.getTokenId(), protoAddToken.getPlaceId()));
                        return action;
                    })
                    .collect(Collectors.toList());
            trace.addNetActions(protoNetAction.getNetId(), actions);
        });
        return trace;
    }
}
