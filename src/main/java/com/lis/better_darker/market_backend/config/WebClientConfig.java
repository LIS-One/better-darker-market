package com.lis.better_darker.market_backend.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
// <- и этот

@Configuration
public class WebClientConfig {

    @Value("${darkerdb.base-url}")
    private String baseUrl;

    @Value("${darkerdb.api-key}")
    private String apiKey;

    // Обратите внимание: в сигнатуру мы добавили WebClient.Builder
    @Bean
    public WebClient darkerDbClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(baseUrl)
                .defaultHeader("X-API-Key", apiKey)
                .build();
    }

    @Bean
    ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
