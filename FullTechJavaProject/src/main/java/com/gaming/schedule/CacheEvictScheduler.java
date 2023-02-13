package com.gaming.schedule;

import com.gaming.service.inteface.IDummyLogCacheService;
import com.gaming.util.GeneratorUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CacheEvictScheduler {

    private final IDummyLogCacheService IdummyLogCacheService;

    @Scheduled(fixedDelay = 10000)
    public void evictOldSearchCache() {
        log.info("Evict Old Search Started");
        IdummyLogCacheService.evictOldGameSearch(GeneratorUtils.randomNumberGenerator());
        log.info("Evict Old Search Ended");
    }
}
