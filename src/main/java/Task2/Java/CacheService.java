package Task2.Java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@ToString
@Data
public class CacheService {

    @Data
    @AllArgsConstructor
    @ToString
    public
    class CacheEntry {
        private String string;
        private long timeOfBirth = System.currentTimeMillis();

        public CacheEntry(String string) {
            this.string = string;
        }

        ;
    }

    int maxSize = 100000;
    private static Logger log = LoggerFactory.getLogger(CacheService.class);
    private Map<UUID, Long> putTimes = new ConcurrentHashMap<>();
    private Map<Integer, Integer> evictionCounter = new ConcurrentHashMap<>();
    Map<Integer, CacheEntry> cacheMap = new ConcurrentHashMap<>();

    public CacheService() {
        evictionCounter.put(0, 0);
    }

    public CacheService(int maxSize) {
        evictionCounter.put(0, 0);
        this.maxSize = maxSize;
    }

    public CacheEntry get(int key) {
        CacheEntry entry = cacheMap.get(key);
        entry.setTimeOfBirth(System.currentTimeMillis());
        return entry;
    }

    public synchronized void put(int key, String string) {
        long startTime = System.currentTimeMillis();
        while (isFull()) {
            CacheEntry deletedEntry = cacheMap.remove(getLFUKey());
            StringBuilder logText = new StringBuilder();
            log.info(logText.append("Entry ")
                    .append(deletedEntry.toString())
                    .append(" has been evicted").toString());
            evictionCounter.put(0, evictionCounter.get(0) + 1);
        }

        cacheMap.put(key, new CacheEntry(string));
        long endTime = System.currentTimeMillis();
        putTimes.put(UUID.randomUUID(), endTime - startTime);
        StringBuilder logText = new StringBuilder("");
        log.info(logText.append("Average time for putting value: ")
                .append(getAverageTime() / 1000)
                .append("s").toString());
        logText = new StringBuilder("");
        log.info(logText.append("Total evictions: ")
                .append(evictionCounter.get(0)).toString());
    }

    private boolean isFull() {
        if (cacheMap.size() >= maxSize) {
            return true;
        } else {
            return false;
        }
    }

    private int getLFUKey() {
        int key = 0;
        for (Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet()) {
            long lifeTime = System.currentTimeMillis() - entry.getValue().getTimeOfBirth();
            if (lifeTime / 1000.0 > 5) {
                key = entry.getKey();
            }
        }
        return key;
    }

    private double getAverageTime() {
        long sum = 0;
        for (Map.Entry<UUID, Long> entry : putTimes.entrySet()) {
            sum += entry.getValue();
        }
        return sum / putTimes.size();
    }
}
