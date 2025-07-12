package com.example.payment.service;

import com.example.payment.dto.OrderEvent;

public interface PaymentService {
    void submitPayment(OrderEvent orderEvent);
}
