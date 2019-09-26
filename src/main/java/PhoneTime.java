import java.time.LocalDateTime;

public class PhoneTime extends Watched {
    private LocalDateTime phoneTime;
    public PhoneTime() {
        this.phoneTime = LocalDateTime.now();
    }

    public LocalDateTime getPhoneTime() {

        return phoneTime;
    }

    public void setPhoneTime(LocalDateTime phoneTime) {
        this.phoneTime = phoneTime;
        notifyAllWatchers(this.getPhoneTime());
    }
}
