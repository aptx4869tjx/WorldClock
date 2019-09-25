import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        UTCTime utcTime = new UTCTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //设置UTC时间
        utcTime.setStandardTime();
        LocalDateTime standardTime = utcTime.getStandardTime();
        List<Watcher> watchers = new ArrayList<>();
        //创建观察者
        CityTime BeiJingTime = new CityTime("BeiJing",8, standardTime);
        CityTime LondonTime = new CityTime("London",0, standardTime);
        CityTime MoscowTime = new CityTime("Moscow",4, standardTime);
        CityTime SydneyTime = new CityTime("Sydney",10, standardTime);
        CityTime NewYorkTime = new CityTime("New York",-5, standardTime);
        watchers.add(BeiJingTime);
        watchers.add(LondonTime);
        watchers.add(MoscowTime);
        watchers.add(SydneyTime);
        watchers.add(NewYorkTime);

        //创建被观察者
        PhoneTime phoneTime =new PhoneTime();
        //添加观察者
        for(Watcher watcher:watchers){
            phoneTime.addWatcher(watcher);
        }
        //输出各个城市的时间
        for(Watcher watcher:watchers){
            CityTime localTime = (CityTime) watcher;
            System.out.println(localTime.getCityName()+"的时间为："+dateTimeFormatter.format(localTime.getLocalTime()));
        }

        //调整后的时间
        phoneTime.setPhoneTime(LocalDateTime.now().minusHours(2));
        //输出各个城市的时间
        for(Watcher watcher:watchers){
            CityTime localTime = (CityTime) watcher;
            System.out.println(localTime.getCityName()+"的时间为："+dateTimeFormatter.format(localTime.getLocalTime()));
        }
    }

}
