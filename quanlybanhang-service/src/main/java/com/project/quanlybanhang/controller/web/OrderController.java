package com.project.quanlybanhang.controller.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TMDT/order")
public class OrderController {

    @PostMapping("/order-product")
    public String saveOrderProduct(){



        return "";
    }
}
