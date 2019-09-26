import java.time.LocalDateTime;

public class CityTime implements Watcher {
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private int offset;
    private LocalDateTime localTime;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public LocalDateTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalDateTime localTime) {
        this.localTime = localTime;
    }

    public CityTime(String cityName, int offset, LocalDateTime UTCTime) {
        this.cityName = cityName;
        this.offset = offset;
        if (offset == 0) {
            this.localTime = UTCTime;
        } else {
            this.localTime = UTCTime.plusHours(offset);
        }
    }

    @Override
    public void update(LocalDateTime time) {
        int beijingOffset = this.offset - 8;
        this.setLocalTime(time.plusHours(beijingOffset));
    }
}
