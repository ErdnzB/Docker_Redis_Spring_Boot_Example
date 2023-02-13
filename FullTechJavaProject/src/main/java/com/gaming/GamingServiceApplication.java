package com.gaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@EnableAsync
@EnableSwagger2
public class GamingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServiceApplication.class, args);
    }
}



