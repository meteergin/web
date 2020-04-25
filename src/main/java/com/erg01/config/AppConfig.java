package com.erg01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public JWTToken jwtToken() {
        return new JWTToken();
    }
}