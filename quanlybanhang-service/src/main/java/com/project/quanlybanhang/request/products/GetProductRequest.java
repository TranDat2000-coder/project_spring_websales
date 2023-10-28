package com.project.quanlybanhang.request.products;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class GetProductRequest {

    @NotNull(message = "pageNo is mandatory")
    @Pattern(regexp = "^[1-9]\\d*$", message = " pageNo is invalid")
    private String pageNo;

    @NotNull(message = "pageSize is mandatory")
    @Pattern(regexp = "^[1-9]\\d*$", message = "pageSize is invalid")
    private String pageSize;

}
