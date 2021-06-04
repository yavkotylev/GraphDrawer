package frontend.model;

import model.internalmodel.interval.ActiveNetTime;
import model.internalmodel.interval.ActiveNetTimeCalculator;
import model.internalmodel.interval.Interval;
import model.internalmodel.net.AgentNet;
import model.internalmodel.net.InternalModelNetBuilder;
import model.internalmodel.net.SystemNet;
import model.internalmodel.trace.Action;
import model.internalmodel.trace.EventType;
import model.internalmodel.trace.InternalModelTraceBuilder;
import model.internalmodel.trace.Trace;
import protobuf.usertrace.UserTrace;
import protobuf.usernet.UserNet;
import utils.InternalUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ModelKeeper {
    private final InternalModelNetBuilder internalModelNetBuilder = new InternalModelNetBuilder();
    private final InternalModelTraceBuilder internalModelTraceBuilder = new InternalModelTraceBuilder();
    private final ActiveNetTimeCalculator activeNetTimeCalculator = new ActiveNetTimeCalculator();
    private UserNet loadedUserNet;
    private UserTrace loadedTrace;
    private SystemNet systemNet;
    private Trace trace;
    private Map<String, ActiveNetTime> activeNetTimeMap;

    public UserNet getLoadedUserNet() {
        return loadedUserNet;
    }

    public void setLoadedUserNet(UserNet loadedUserNet) {
        this.loadedUserNet = loadedUserNet;
    }

    public UserTrace getLoadedTrace() {
        return loadedTrace;
    }

    public SystemNet getSystemNet() {
        return systemNet;
    }

    public void setSystemNet() {
        this.systemNet = internalModelNetBuilder.buildSystemNetFromProtobuf(loadedUserNet);
        this.setDefaultTimeValues(systemNet);
    }

    public Map<String, ActiveNetTime> getActiveNetTimeMap() {
        return activeNetTimeMap;
    }

    public void setActiveNetTimeMap() {
        this.activeNetTimeMap = new HashMap<>();
        this.systemNet.getAgentNets().forEach(agentNet -> {
            String netId = agentNet.getId();
            List<Action> netAction = this.trace.getNetAction(netId);
            if (netAction != null) {
                List<Interval> activeIntervals = activeNetTimeCalculator
                        .getNetActiveIntervals(netAction, agentNet, trace.getEndTime());
                this.activeNetTimeMap.put(netId, new ActiveNetTime(agentNet, activeIntervals));
            }
        });
    }

    public Trace getTrace() {
        return trace;
    }

    public void setTrace() {
        this.trace = internalModelTraceBuilder.buildTrace(loadedTrace);
    }

    public void setLoadedTrace(UserTrace loadedTrace) {
        this.loadedTrace = loadedTrace;
    }

    public void clearUserNet() {
        this.loadedUserNet = null;
    }

    public void clearUserTrace() {
        this.loadedTrace = null;
    }

    public void clearSystemNet() {
        this.systemNet = null;
    }

    public void clearTrace() {
        this.trace = null;
    }

    public void clearActiveNetTimeMap() {
        this.activeNetTimeMap = null;
    }

    public boolean hasTraceAndNet() {
        return loadedTrace != null && loadedUserNet != null;
    }

    public boolean hasTrace() {
        return loadedTrace != null;
    }

    public boolean hasNet() {
        return loadedUserNet != null;
    }

    public Collection<AgentNet> getAgentNets() {
        return systemNet.getAgentNets();
    }

    public Collection<EventType> getAgentEventTypes(AgentNet agentNet) {
        return InternalUtils.safeStream(trace.getNetAction(agentNet.getId()))
                .map(Action::getEventType)
                .collect(Collectors.toSet());
    }

    public void updateActiveTime(AgentNet agentNet) {
        String netId = agentNet.getId();
        List<Action> netActions = trace.getNetAction(agentNet.getId());
        if (netActions != null) {
            List<Interval> updatedActiveIntervals = activeNetTimeCalculator
                    .getNetActiveIntervals(netActions, agentNet, trace.getEndTime());
            activeNetTimeMap.put(netId, new ActiveNetTime(agentNet, updatedActiveIntervals));
        }
    }

    public List<Action> getAgentNetActions(AgentNet agentNet) {
        List<Action> netActions = trace.getNetAction(agentNet.getId());
        return netActions == null ? new ArrayList<>() : netActions;
    }

    public ActiveNetTime getAgentNetTime(AgentNet agentNet) {
        return activeNetTimeMap.get(agentNet.getId());
    }

    private void setDefaultTimeValues(SystemNet systemNet) {
        long defaultTimeInterval = trace.getEndTime() / 10;
        systemNet.getAgentNets().forEach(agentNet -> {
            if (agentNet.getIntervalDuration() == null) {
                agentNet.setIntervalDuration(defaultTimeInterval);
            }
            if (agentNet.getDistanceBetweenIntervals() == null) {
                agentNet.setDistanceBetweenIntervals(defaultTimeInterval);
            }
        });
    }

}
