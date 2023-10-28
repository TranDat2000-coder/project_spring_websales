package com.project.quanlybanhang.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SwaggerProperties {

    private String title = "Sales Manager Application API";
    private String description = "Sample OpenAPI 3.0";
    private String email = "trandat.00712@gmail.com";
}
