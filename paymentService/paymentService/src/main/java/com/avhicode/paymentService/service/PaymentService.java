package com.avhicode.paymentService.service;

import com.avhicode.paymentService.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
