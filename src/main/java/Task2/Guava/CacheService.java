package Task2.Guava;

import com.google.common.cache.*;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Data
@NoArgsConstructor
public class CacheService {

    @Data
    @AllArgsConstructor
    @ToString
    @Getter
    static class CacheEntry {
        private String string;
    }

    private static Logger log = LoggerFactory.getLogger(CacheService.class);
    StringBuilder logText = new StringBuilder();

    int maxSize = 100000;

    private LoadingCache<Integer, CacheEntry> cache = CacheBuilder.newBuilder()
            .maximumSize(maxSize).expireAfterAccess(5, TimeUnit.SECONDS)
            .removalListener((RemovalListener<Integer, CacheEntry>) removal -> {
                StringBuilder logText = new StringBuilder();
                CacheEntry entry = removal.getValue();
                log.info(logText.append("Entry ").append(entry).append(" has been deleted").toString());
            }).recordStats().build(
                    new CacheLoader<Integer, CacheEntry>() {
                        @Override
                        public CacheEntry load(Integer key) throws Exception {
                            return cache.get(key);
                        }
                    });

    public CacheService(int maxSize) {
        this.maxSize = maxSize;
    }

    public CacheEntry get(int key) throws ExecutionException {
        return cache.get(key);
    }

    public void put(int key, String string) {
        StringBuilder logText = new StringBuilder();
        cache.put(key, new CacheEntry(string));
        log.info(logText.append("Average Load Penalty: ").append(cache.stats().averageLoadPenalty()).toString());
        logText = new StringBuilder();
        log.info(logText.append("Total evictions: ").append(cache.stats().evictionCount()).toString());
    }


}

