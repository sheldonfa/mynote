package entity.statsInfo;

public class StatsResultInfo {

    private Long repeatCount;
    private Integer peakHour;

    public Long getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Long repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Integer getPeakHour() {
        return peakHour;
    }

    public void setPeakHour(Integer peakHour) {
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
