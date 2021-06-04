package model.internalmodel.net;


public class AgentNet extends BaseNet {
    private Long threshold = 0L;
    private Long intervalDuration;
    private Long distanceBetweenIntervals;

    public AgentNet(String id) {
        super(id);
    }

    private String systemTokenId;

    public String getSystemTokenId() {
        return systemTokenId;
    }

    public void setSystemTokenId(String systemTokenId) {
        this.systemTokenId = systemTokenId;
    }

    public Long getThreshold() {
        return threshold;
    }

    public void setThreshold(long threshold) {
        this.threshold = threshold;
    }

    public Long getIntervalDuration() {
        return intervalDuration;
    }

    public void setIntervalDuration(long intervalDuration) {
        this.intervalDuration = intervalDuration;
    }

    public Long getDistanceBetweenIntervals() {
        return distanceBetweenIntervals;
    }

    public void setDistanceBetweenIntervals(long distanceBetweenIntervals) {
        this.distanceBetweenIntervals = distanceBetweenIntervals;
    }

    @Override
    public String toString() {
        return getName();
    }
}
