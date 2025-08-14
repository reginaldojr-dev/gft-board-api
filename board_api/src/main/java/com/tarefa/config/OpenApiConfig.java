package com.tarefa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "GFT Board API",
                version = "1.0",
                description = "API de Board (Kanban) — desafio GFT (CRUD de Cards + mover status)"
        )
)
public class OpenApiConfig {}
