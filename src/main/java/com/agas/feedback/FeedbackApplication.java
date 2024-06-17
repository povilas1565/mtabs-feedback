package com.agas.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

@EntityScan("com.aga.feedback.model")
@SpringBootApplication(scanBasePackages = {"com.agas.feedback.models", "com.agas.feedback.services", "com.agas.feedback.controllers", "com.agas.feedback.configuration"})
public class FeedbackApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(FeedbackApplication.class, args);
    }

}
