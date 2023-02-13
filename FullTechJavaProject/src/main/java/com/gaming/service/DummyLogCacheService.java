package com.gaming.service;


import com.gaming.model.dto.DummyLogCacheDto;
import com.gaming.service.inteface.IDummyLogCacheService;
import com.gaming.util.GeneratorUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;

import static com.gaming.config.redis.constants.RedisConstantsNames.SEARCH_BY_PARAMS_WITH_KEYS_CACHE;
import static com.gaming.config.redis.constants.RedisConstantsPrefix.DUMMY_LOG_PREFIX;

@Slf4j
@RequiredArgsConstructor
@Service
public class DummyLogCacheService implements IDummyLogCacheService {

    private final RedisTemplate<String, DummyLogCacheDto> redisTemplate;

    @Async
    public void saveGuardData(DummyLogCacheDto logReason) {
        redisTemplate.opsForValue().set(getRedisKey(), logReason, Duration.ofMinutes(5));
    }

    @Caching(evict = {
            @CacheEvict(value = SEARCH_BY_PARAMS_WITH_KEYS_CACHE, allEntries = true)
    })
    public void evictOldGameSearch(Integer logNumber) {
        redisTemplate.delete(DUMMY_LOG_PREFIX + logNumber);
    }

    private String getRedisKey() {
        int randomNumber = GeneratorUtils.randomNumberGenerator();
        log.info("Random Number : {}", randomNumber);
        return DUMMY_LOG_PREFIX + randomNumber;

    }

}
