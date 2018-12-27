package entity;

public class StatsResultInfo {

    private Long repeatCount;
    private Long peakHour;

    public Long getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Long repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Long getPeakHour() {
        return peakHour;
    }

    public void setPeakHour(Long peakHour) {
        this.peakHour = peakHour;
    }

    @Override
    public String toString() {
        return "StatsResultInfo{" +
                "repeatCount=" + repeatCount +
                ", peakHour=" + peakHour +
                '}';
    }
}
