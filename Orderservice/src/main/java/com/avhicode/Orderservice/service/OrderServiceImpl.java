package com.avhicode.Orderservice.service;

import com.avhicode.Orderservice.entity.Order;
import com.avhicode.Orderservice.external.client.PaymentService;
import com.avhicode.Orderservice.external.client.ProductService;
import com.avhicode.Orderservice.external.client.request.PaymentRequest;
import com.avhicode.Orderservice.model.OrderRequest;
import com.avhicode.Orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;
    @Override
    public long createOrder(OrderRequest orderRequest) {

        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());

        Order order = Order.builder()
                .ProductId(orderRequest.getProductId())
                .quantity(orderRequest.getQuantity())
                .amount(orderRequest.getAmount())
                .orderStatus("CREATED")
                .orderDate(Instant.now())
                .build();

        orderRepository.save(order);

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(order.getId())
                .paymentMode(orderRequest.getPaymentMode())
                .amount(orderRequest.getAmount())
                .build();

        String orderStatus = null;
        try{
            paymentService.doPayment(paymentRequest);
            orderStatus = "PLACED";
        }catch (Exception e){
            orderStatus="PAYMENT_FAILED";
        }

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);

        return order.getId() ;
    }
}
