package com.rifat.racingSimulator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(new Components())
            .info(new Info().title("Racing Simulator API").version("1.1").description("API documentation for the Racing Simulator OOP Lab 2"))
            .externalDocs(new ExternalDocumentation()
                .description("Racing Simulator github")
                .url("https://github.com/rifat-dev/RacingSimulator.git"));
    }
}
