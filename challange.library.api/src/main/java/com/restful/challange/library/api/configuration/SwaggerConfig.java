package com.restful.challange.library.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Import(SpringDataRestConfiguration.class)
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.restful.challange.library.api.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Título da sua API")
                .description("Descrição detalhada da sua API")
                .version("Versão da sua API")
                .termsOfServiceUrl("URL dos Termos de Serviço")
                .contact(new Contact("Nome do Contato", "URL do Contato", "Email do Contato"))
                .license("Licença")
                .licenseUrl("URL da Licença")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}