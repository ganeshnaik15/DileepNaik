package com.example.springswaggerrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

@Configuration
public class SpringFoxConfiguration {
    @Bean
    public  Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
             //   .apis(Predicate.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))) //to disappear basic error controller which is default
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API for Swagger ")
                .description("This is my First Swagger")
                .version("0.0.1.SNAPSHOT")
                .build();
    }
}
