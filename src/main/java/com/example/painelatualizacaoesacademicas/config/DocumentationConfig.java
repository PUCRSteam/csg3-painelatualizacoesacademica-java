package com.example.painelatualizacaoesacademicas.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
    Configuração da documentação (Swagger)
 */
@EnableSwagger2
@Configuration
public class DocumentationConfig extends WebMvcConfigurationSupport {

    private final String title = "Painel Atualização Academica Api";
    private final String description = "Backend do projeto Painel Atualização Academica";

    @Bean
    public Docket docketBean() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.painelatualizacaoesacademicas"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(buildApiInfo())
                .useDefaultResponseMessages(false);
    }


    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder().title(title).description(description).build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
    }

}
