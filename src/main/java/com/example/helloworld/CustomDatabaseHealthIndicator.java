package com.example.helloworld;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomDatabaseHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isDatabaseUp = checkDatabaseStatus();
        if (isDatabaseUp) {
            return Health.up().withDetail("message", "Database is up").build();
        } else {
            return Health.down().withDetail("message", "Database is down").build();
        }
    }

    private boolean checkDatabaseStatus() {
        // custom logic with db connection and health check
        return true;
    }
}

