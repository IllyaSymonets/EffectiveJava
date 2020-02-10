package Task2.Java;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
@Data
public class CacheServiceImpl {

    @Data
    @AllArgsConstructor
    @ToString
    public static class CacheEntry {

        private String string;
    }

    int maxSize = 100000;
    private static Logger log = LoggerFactory.getLogger(CacheServiceImpl.class);
    private List<Long> putTimes = new ArrayList<>();
    private int evictionCounter = 0;
    private LinkedHashMap<Integer, CacheEntry> cacheMap;

    public CacheServiceImpl() {
        initializeMap();
    }

    public CacheServiceImpl(int maxSize) {
        this.maxSize = maxSize;
        initializeMap();
    }

    public synchronized CacheEntry get(int key) {
        CacheEntry entry = cacheMap.get(key);
        cacheMap.remove(key);
        cacheMap.put(key, entry);
        return entry;
    }

    public synchronized void put(int key, String string) {
        long startTime = System.currentTimeMillis();
        CacheEntry entry = new CacheEntry(string);
        cacheMap.put(key, entry);
        long endTime = System.currentTimeMillis();
        putTimes.add(endTime - startTime);
        getStats();
    }

    private double getAverageTime() {
        double sum = 0.0;
        for (long time : putTimes) {
            sum += time;
        }
        return sum / putTimes.size();
    }

    private void getStats() {
        StringBuilder logText = new StringBuilder();
        log.info(logText.append("Average time for putting value: ")
            .append(getAverageTime() / 1000)
            .append("s").toString());
        logText = new StringBuilder();
        log.info(logText.append("Total evictions: ")
            .append(evictionCounter).toString());
    }

    private void initializeMap() {
        cacheMap = new LinkedHashMap<Integer, CacheEntry>() {
            protected synchronized boolean removeEldestEntry(Entry eldest) {
                boolean isFull = size() > maxSize;
                if (isFull) {
                    StringBuilder logText = new StringBuilder();
                    log.info(logText.append("Entry ")
                        .append(eldest)
                        .append(" has been evicted").toString());
                    evictionCounter++;
                }
                return isFull;
            }
        };
    }
}
