package com.example.payment.utils;

import com.example.payment.constant.StatusPayment;
import com.example.payment.dto.OrderEvent;
import com.example.payment.entity.Payment;
import com.example.payment.entity.PaymentHistory;

import java.util.ArrayList;
import java.util.Date;


public class ServiceMapper {

    public static Payment mapToPayment(OrderEvent orderEvent) {
        return Payment.builder()
                .amount(orderEvent.getNominalAmount())
                .orderId(orderEvent.getOrderId())
                .history(new ArrayList<>())
                .build();
    }

    public static PaymentHistory mapToPaymentHistory(Payment payment, StatusPayment statusPayment) {
        return PaymentHistory.builder()
                .payment(payment)
                .amount(payment.getAmount())
                .status(statusPayment)
                .createdAt(new Date())
                .build();
    }
}
