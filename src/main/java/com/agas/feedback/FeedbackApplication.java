package com.agas.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan("com.agas.feedback.model")
@SpringBootApplication(scanBasePackages = {"com.agas.feedback.models", "com.agas.feedback.services", "com.agas.feedback.controllers", "com.agas.feedback.configuration"})
@EnableScheduling
public class FeedbackApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(FeedbackApplication.class, args);
    }

}
