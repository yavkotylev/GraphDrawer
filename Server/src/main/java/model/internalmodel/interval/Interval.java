package model.internalmodel.interval;

import model.internalmodel.trace.Action;

import java.util.List;

public class Interval implements Comparable<Interval> {
    private final long netEndTime;
    private long startTime;
    private long endTime;
    private long length;

    public Interval(long startTime, long endTime, long netEndTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.length = endTime - startTime;
        this.netEndTime = netEndTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(Interval o) {
        if (startTime == o.startTime && endTime == o.endTime) {
            return 0;
        } else if (startTime > o.startTime) {
            return -1;
        } else if (startTime < o.startTime) {
            return 1;
        } else if (endTime > o.endTime) {
            return -1;
        }
        return 1;
    }

    public boolean isOverlapped(Interval i) {
        return !(endTime < i.startTime || startTime > i.endTime);
    }

    public boolean isActionInInterval(Action action) {
        return action.getTime() <= endTime && action.getTime() >= startTime;
    }

    boolean isActive(List<Action> actions, long threshold) {
        long lii = 0;
        for (Action action : actions) {
            if (isActionInInterval(action)) {
                lii += action.getEventType().getImportance();
            }
        }
        return lii >= threshold;
    }

    void combineWithInterval(Interval interval) {
        long minStart = Math.min(startTime, interval.startTime);
        long maxEnd = Math.max(endTime, interval.endTime);
        this.startTime = minStart;
        this.endTime = Math.min(maxEnd, netEndTime);
    }
}
