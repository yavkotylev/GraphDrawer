package model.internalmodel.interval;

import model.internalmodel.net.AgentNet;
import model.internalmodel.trace.Action;

import java.util.LinkedList;
import java.util.List;

public class ActiveNetTimeCalculator {

    public List<Interval> getNetActiveIntervals(List<Action> netActions, AgentNet agentNet, long endTime) {
        LinkedList<Interval> intervals = new LinkedList<>();
        for (long currentTime = 0; currentTime < endTime;
             currentTime += agentNet.getDistanceBetweenIntervals()) {
            Interval interval = new Interval(currentTime,
                    currentTime + agentNet.getIntervalDuration(), endTime);
            if (interval.isActive(netActions, agentNet.getThreshold())) {
                if (intervals.isEmpty()) {
                    intervals.addLast(interval);
                } else {
                    Interval latestInterval = intervals.getLast();
                    if (latestInterval.isOverlapped(interval)) {
                        latestInterval.combineWithInterval(interval);
                    } else {
                        intervals.addLast(interval);
                    }
                }
            }
        }
        return intervals;
    }
}
