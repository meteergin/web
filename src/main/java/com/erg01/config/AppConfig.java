package com.erg01.config;

import com.erg01.domain.JWTToken;
import com.erg01.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public JWTToken jwtToken() {
        return new JWTToken();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public User user(){
        return new User();
    }
}