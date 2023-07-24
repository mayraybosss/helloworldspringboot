package com.example.helloworld;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final Counter userCreationCounter;

    public CustomMetrics(MeterRegistry meterRegistry) {
        userCreationCounter = Counter.builder("app.user.creation")
                .description("Number of user creation requests")
                .register(meterRegistry);
    }

    public void incrementUserCreationCounter() {
        userCreationCounter.increment();
    }
}

