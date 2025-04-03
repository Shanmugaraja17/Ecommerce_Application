package com.avhicode.paymentService.service;

import com.avhicode.paymentService.entity.TransactionDetails;
import com.avhicode.paymentService.model.PaymentRequest;
import com.avhicode.paymentService.repository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public Long doPayment(PaymentRequest paymentRequest) {

        TransactionDetails transactionDetails = TransactionDetails.builder()
                .orderId(paymentRequest.getOrderId())
                .paymentDate(Instant.now())
                .paymentStatus("SUCCESS")
                .amount(paymentRequest.getAmount())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .build();
        transactionDetailsRepository.save(transactionDetails);


        return transactionDetails.getId();
    }
}
