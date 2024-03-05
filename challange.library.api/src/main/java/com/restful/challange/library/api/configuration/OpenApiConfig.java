package com.restful.challange.library.api.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.stereotype.Repository;

@OpenAPIDefinition(
        info = @Info(
                title = "Desafio  Library API",
                version = "V0.0.1",
                description = "Descrição detalhada da sua API",
                termsOfService = "URL dos Termos de Serviço",
                contact = @Contact(
                        name = "Vinícius dos Santos Andrade",
                        url = "https://www.linkedin.com/in/viniciusdsandrade/",
                        email = "vinicius_andrade2010@hotmail.com"
                ),
                license = @License(
                        name = "GitHub",
                        url = "https://github.com/viniciusdsandrade/"
                )
        )
)
public class OpenApiConfig {
}