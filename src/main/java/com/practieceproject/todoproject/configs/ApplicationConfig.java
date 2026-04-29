package com.practieceproject.todoproject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationConfig {
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
