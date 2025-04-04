package com.avhicode.CloudGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fallBackController {

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallBack(){
        return "ORDER SERVICE IS DOWN !!!";
    }
    @GetMapping("/paymentServiceFallBack")
    public String paymentServiceFallBack(){
        return "PAYMENT SERVICE IS DOWN !!!";
    }
    @GetMapping("/productServiceFallBack")
    public String productServiceFallBack(){
        return "PRODUCT SERVICE IS DOWN !!!";
    }
}
