package com.example.devops;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("IBMEC - DEVOPS")
                        .description("Projeto devops")
                        .version("1.0")
                        .contact(new Contact()
                                .email("matheusgadelha01@gmail.com")
                                .name("Matheus Herzog")
                        )
                );
    }
}
