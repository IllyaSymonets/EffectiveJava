package Task2.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
@Data
@NoArgsConstructor
public class AnotherCacheService {

    @Data
    @AllArgsConstructor
    @ToString
    public
    class CacheEntry {

        private long timeOfBirth = System.currentTimeMillis();
        private String string;

        public CacheEntry(String string) {
            this.string = string;
        }
    }

    int maxSize = 100000;
    private static Logger log = LoggerFactory.getLogger(CacheService.class);
    private List<Long> putTimes = new ArrayList<>();
    private int evictionCounter = 0;
    private Map<Integer, CacheEntry> cacheMap = new HashMap<>();

    public AnotherCacheService(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized CacheEntry get(int key) {
        CacheEntry entry = cacheMap.get(key);
        entry.setTimeOfBirth(System.currentTimeMillis());
        return entry;
    }

    public synchronized CacheEntry put(int key, String string) {
        long startTime = System.currentTimeMillis();
        while (cacheMap.size() >= maxSize) {
            cacheMap = cacheMap.entrySet().stream().
                filter(cacheEntry -> ((System.currentTimeMillis())
                    - cacheEntry.getValue().getTimeOfBirth()) / 1000.0 < 5)
                .collect(
                    Collectors.toMap(Entry::getKey, Entry::getValue));
        }

        CacheEntry entry = new CacheEntry(string);
        cacheMap.put(key, entry);
        long endTime = System.currentTimeMillis();
        putTimes.add(endTime - startTime);
        StringBuilder logText = new StringBuilder("");
        log.info(logText.append("Average time for putting value: ")
            .append(getAverageTime() / 1000)
            .append("s").toString());
        logText = new StringBuilder("");
        log.info(logText.append("Total evictions: ")
            .append(evictionCounter).toString());
        return entry;
    }

    private double getAverageTime() {
        long sum = 0;
        for (long time : putTimes) {
            sum += time;
        }
        return sum / putTimes.size();
    }
}
