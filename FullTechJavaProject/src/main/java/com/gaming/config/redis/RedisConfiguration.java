package com.gaming.config.redis;

import com.gaming.config.properties.RedisProperties;
import com.gaming.config.properties.SearchServiceProperties;
import com.gaming.config.redis.constants.RedisConstantsPrefix;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.gaming.config.redis.constants.RedisConstantsNames.GAME_SEARCH_BY_ID_CACHE;
import static com.gaming.config.redis.constants.RedisConstantsNames.SEARCH_BY_PARAMS_WITH_KEYS_CACHE;

@EnableCaching
@Configuration
@RequiredArgsConstructor
public class RedisConfiguration {


    private final RedisProperties redisProperties;
    private final SearchServiceProperties searchServiceProperties;

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisProperties.getHost());
        redisStandaloneConfiguration.setPort(redisProperties.getPort());
        redisStandaloneConfiguration.setPassword(RedisPassword.of((redisProperties.getPassword())));
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public CacheManager cacheManager() {
        return RedisCacheManager.builder(redisConnectionFactory())
                .withInitialCacheConfigurations(constructCacheConfigurationMap())
                .transactionAware()
                .build();
    }

    private Map<String, RedisCacheConfiguration> constructCacheConfigurationMap() {
        final Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        final RedisCacheConfiguration gamingSearchCache = RedisCacheConfiguration.defaultCacheConfig()
                .prefixKeysWith(RedisConstantsPrefix.SEARCH_BY_PARAMS_WITH_KEYS_PREFIX)
                .entryTtl(Duration.ofMinutes(searchServiceProperties.getWithKeysTtlInMinutes()))
                .disableCachingNullValues();
        final RedisCacheConfiguration gamingFindCache = RedisCacheConfiguration.defaultCacheConfig()
                .prefixKeysWith(RedisConstantsPrefix.GAME_SEARCH_BY_ID_PREFIX)
                .entryTtl(Duration.ofMinutes(searchServiceProperties.getGameSearchTtlInMinutes()))
                .disableCachingNullValues();
        redisCacheConfigurationMap.put(SEARCH_BY_PARAMS_WITH_KEYS_CACHE, gamingSearchCache);
        redisCacheConfigurationMap.put(GAME_SEARCH_BY_ID_CACHE, gamingFindCache);
        return redisCacheConfigurationMap;
    }

}
