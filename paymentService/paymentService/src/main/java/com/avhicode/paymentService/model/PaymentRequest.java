package com.avhicode.paymentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class PaymentRequest {
    private long orderId;
    private long amount;
    private String ReferenceNumber;
    private PaymentMode paymentMode;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getReferenceNumber() {
        return ReferenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        ReferenceNumber = referenceNumber;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentRequest(long orderId, long amount, String referenceNumber, PaymentMode paymentMode) {
        this.orderId = orderId;
        this.amount = amount;
        ReferenceNumber = referenceNumber;
        this.paymentMode = paymentMode;
    }

    public PaymentRequest() {
    }
}
