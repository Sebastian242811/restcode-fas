package com.example.salesservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class openApiConfiguration {
    @Bean(name = "consultationOpenApi")
    public OpenAPI consultationOpenApi() {
        return new OpenAPI().info(
                new Info()
                        .title("Retcode API")
                        .description("Restcode API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI 3.0")
                        .version("1.0")
                        .contact(
                                new Contact()
                                        .name("Marco Antonio Manrique Acha")
                                        .email("manriqueacham@gmail.com")
                                        .url("https://blucode.solutions"))
        );
    }
}