package com.wesley.config;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApiFootballConfig {

    @Value("${api.football.base-url}")
    private String baseUrl;

    @Value("${api.football.api-key}")
    private String apiKey;
}