package entity.statsInfo;

public class HourStat {

    private Integer hour;
    private Long count;

    public Integer getHour() {
        return hour;
    }

    public HourStat setHour(Integer hour) {
        this.hour = hour;
        return this;
    }

    public Long getCount() {
        return count;
    }

    public HourStat setCount(Long count) {
        this.count = count;
        return this;
    }

    @Override
    public String toString() {
        return "HourStat{" +
                "hour=" + hour +
                ", count=" + count +
                '}';
    }
}
