package org.example.ex8.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ComponentScan(basePackages = {"org.example.ex8.beans"})
@EnableFeignClients(basePackages = "org.example.ex8.services.feignclient")
public class ProjectConfig {

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .build();
    }
}
