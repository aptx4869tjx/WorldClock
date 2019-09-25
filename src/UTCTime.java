import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class UTCTime {
    private LocalDateTime standardTime;
    public LocalDateTime getStandardTime() {
        return standardTime;
    }

    public void setStandardTime() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
        this.standardTime = localDateTime;
    }
}
