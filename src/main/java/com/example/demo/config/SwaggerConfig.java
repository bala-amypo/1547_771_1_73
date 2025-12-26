package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Multi-Level Approval Workflow API")
                        .description("Spring Boot Workflow Engine APIs")
                        .version("1.0"))
                .servers(List.of(
                        
                        new Server().url("http://localhost:9001"),
                        
                        new Server().url("https://9379.408procr.amypo.ai/")
                ));
    }
}
