package com.avhicode.paymentService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;



@Entity
@Table(name = "TRANSACTION_DETAILS")
@Data
@Builder
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long Id;

    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "PAYMENT_MODE")
    private String paymentMode;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    @Column(name = "PAYMENT_DATE")
    private Instant paymentDate;

    @Column(name = "AMOUNT")
    private long amount;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "Id=" + Id +
                ", orderId=" + orderId +
                ", paymentMode='" + paymentMode + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                '}';
    }

    public TransactionDetails(long id, long orderId, String paymentMode, String referenceNumber, String paymentStatus, Instant paymentDate, long amount) {
        Id = id;
        this.orderId = orderId;
        this.paymentMode = paymentMode;
        this.referenceNumber = referenceNumber;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public TransactionDetails() {
    }
}
