package com.example.categoryserver.config;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4j {
    RateLimiterConfig config = RateLimiterConfig.custom()
            .limitRefreshPeriod(Duration.ofMillis(1))
            .limitForPeriod(10)
            .timeoutDuration(Duration.ofMillis(25))
            .build();
    RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.of(config);
    RateLimiter rateLimiterWithDefaultConfig = rateLimiterRegistry
            .rateLimiter("ratelimiter2", config);
}
