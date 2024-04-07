package com.example.app.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean public WebClient WebClient() {
        return WebClient.builder().build();
    }
}
