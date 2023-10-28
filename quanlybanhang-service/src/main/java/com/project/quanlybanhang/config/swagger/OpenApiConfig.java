package com.project.quanlybanhang.config.swagger;

import com.google.common.collect.Lists;
import com.project.quanlybanhang.utils.SwaggerProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public OpenAPI customeOpenAPI(){
        return new OpenAPI()
                //Thiết lập các server để test API
                .servers(Lists.newArrayList(
                        new Server().url("http://localhost:8082")))
                .info(new Info().title(swaggerProperties.getTitle())
                        .description(swaggerProperties.getDescription())
                        .contact(new Contact()
                                .email("trandat.00712@gmail.com")
                                .name("Sales Manager")
                                .url("https://www.facebook.com/datjavadeveloper/"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                        .version("1.0.0"));
    }
}
