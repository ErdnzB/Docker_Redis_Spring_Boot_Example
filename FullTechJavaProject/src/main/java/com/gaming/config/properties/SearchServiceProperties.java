package com.gaming.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "search.cache")
public class SearchServiceProperties {

    private Long withKeysTtlInMinutes;
    private Long gameSearchTtlInMinutes;

}
