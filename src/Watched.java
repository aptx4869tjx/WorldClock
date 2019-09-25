import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Watched {
    public List<Watcher> watchers = new ArrayList<>();

    void addWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    public void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    void notifyAllWatchers(LocalDateTime time) {
        for (Watcher watcher : watchers) {
            watcher.update(time);
        }
    }
}
