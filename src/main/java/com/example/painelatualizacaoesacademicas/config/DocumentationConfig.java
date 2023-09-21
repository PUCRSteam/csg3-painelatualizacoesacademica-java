package com.example.painelatualizacaoesacademicas.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Painel Atualização Academica Api",
        description = "Backend do projeto Painel Atualização Academica",
        version = "V1.0",
        contact = @Contact(
                name = "Alessandro Borges",
                email = "alessandro.souza@edu.pucrs.br",
                url = "https://github.com/PUCRSteam/csg3-painelatualizacoesacademica-java"
        ),
        license = @License(
                name = "Apache 2.0",
                url = ""
        )
)
)
public class DocumentationConfig implements WebMvcConfigurer {


}