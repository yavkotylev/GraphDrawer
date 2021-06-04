package model.internalmodel.interval;

import model.internalmodel.net.AgentNet;

import java.util.List;

public class ActiveNetTime {
    private final AgentNet agentNet;
    private final List<Interval> activeIntervals;

    public ActiveNetTime(AgentNet agentNet, List<Interval> activeIntervals) {
        this.agentNet = agentNet;
        this.activeIntervals = activeIntervals;
    }

    public List<Interval> getActiveIntervals() {
        return activeIntervals;
    }

    public AgentNet getAgentNet() {
        return agentNet;
    }
}
