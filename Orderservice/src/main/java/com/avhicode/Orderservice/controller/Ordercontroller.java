package com.avhicode.Orderservice.controller;

import com.avhicode.Orderservice.model.OrderRequest;
import com.avhicode.Orderservice.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Log4j2
public class Ordercontroller {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> createOrder(@RequestBody OrderRequest orderRequest){

        long orderID = orderService.createOrder(orderRequest);

        log.info("Order id is created : " + orderID);

        return new ResponseEntity<>(orderID, HttpStatus.OK);
    }
}
