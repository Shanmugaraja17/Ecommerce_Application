package com.avhicode.Orderservice.entity;

import com.avhicode.Orderservice.model.PaymentMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Order_Details")
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "PRODUCT_ID")
    private long ProductId;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "ORDER_DATE")
    private Instant orderDate;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    @Column(name = "AMOUNT")
    private long amount;

}
