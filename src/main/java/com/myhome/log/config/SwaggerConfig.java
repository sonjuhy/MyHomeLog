package com.myhome.log.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("kafka-control")
                .pathsToMatch("/kafka/**")
                .build();
    }

    @Bean
    public OpenAPI kafkaLogOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("MyHome Log API")
                        .description("MyHome Log System API")
                        .version("v0.1"));

    }
}
