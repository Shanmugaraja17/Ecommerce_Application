package com.avhicode.Orderservice.service;

import com.avhicode.Orderservice.model.OrderRequest;
import org.springframework.stereotype.Service;



public interface OrderService {
    long createOrder(OrderRequest orderRequest);
}
