package com.example.Papeleria_Jhon.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI swaggerConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Papeleria")
                        .version("1.0")
                        .description("Documentación de la API de ventas de la papeleria de Jhon")
                        .contact(new Contact()
                                .name("Jhon Fredy Gomez Mojica ")
                                .email("jhonfredygomez@ucundinamarca.edu.co")));
    }
}