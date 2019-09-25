import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WorldClockTest {
    @Test
    public void mainTest() {
        List<Watcher> watchers = new ArrayList<>();
        List<Duration> durations = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        UTCTime utcTime = new UTCTime();
        //设置UTC时间
        utcTime.setStandardTime();
        LocalDateTime standardTime = utcTime.getStandardTime();
        //被观察者，即为手机时间
        PhoneTime phoneTime = new PhoneTime();
        //创建观察者
        CityTime BeiJingTime = new CityTime("BeiJing", 8, standardTime);
        CityTime LondonTime = new CityTime("London", 0, standardTime);
        CityTime MoscowTime = new CityTime("Moscow", 4, standardTime);
        CityTime SydneyTime = new CityTime("Sydney", 10, standardTime);
        CityTime NewYorkTime = new CityTime("New York", -5, standardTime);
        watchers.add(BeiJingTime);
        watchers.add(LondonTime);
        watchers.add(MoscowTime);
        watchers.add(SydneyTime);
        watchers.add(NewYorkTime);
        //添加观察者
        for (Watcher watcher : watchers) {
            phoneTime.addWatcher(watcher);
        }
        System.out.println("pre");
        //输出各个城市的时间
        for (int i = 0; i < watchers.size(); i++) {
            CityTime localTime = (CityTime) watchers.get(i);
            System.out.println(localTime.getCityName() + "的时间为：" + dateTimeFormatter.format(localTime.getLocalTime()));
            durations.add(i, Duration.between(localTime.getLocalTime(), phoneTime.getPhoneTime()));
        }
        //调整后的时间
        phoneTime.setPhoneTime(LocalDateTime.now().minusHours(2));
        //输出各个城市的时间
        for (int j = 0; j < watchers.size(); j++) {
            CityTime localTime = (CityTime) watchers.get(j);
//            System.out.println(durations.get(j).toMinutes());
//            System.out.println(Duration.between(localTime.getLocalTime(), phoneTime.getPhoneTime()).toMinutes());
            Assertions.assertEquals(durations.get(j).toHours(),
                    Duration.between(localTime.getLocalTime(), phoneTime.getPhoneTime()).toHours());
            System.out.println(localTime.getCityName() + "的时间为：" + dateTimeFormatter.format(localTime.getLocalTime()));
        }
    }

}
