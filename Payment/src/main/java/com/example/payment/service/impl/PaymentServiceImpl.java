package com.example.payment.service.impl;

import com.example.payment.constant.StatusPayment;
import com.example.payment.dto.OrderEvent;
import com.example.payment.entity.Payment;
import com.example.payment.entity.PaymentHistory;
import com.example.payment.repository.PaymentRepository;
import com.example.payment.service.PaymentService;
import com.example.payment.utils.ServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public void submitPayment(OrderEvent orderEvent) {
        Optional<Payment> byOrderId = paymentRepository.findByOrderId(orderEvent.getOrderId());
        Payment payment = ServiceMapper.mapToPayment(orderEvent);
        if(byOrderId.isPresent()) {
            payment.setId(byOrderId.get().getId());
        }else{
            payment.setId("payment-" + orderEvent.getOrderId());
        }
        if(orderEvent.getStatus().equals("PENDING")){
            PaymentHistory paymentHistory = ServiceMapper.mapToPaymentHistory(payment, StatusPayment.UNPAID);
            payment.addHistory(paymentHistory);
        }else{
            PaymentHistory paymentHistory = ServiceMapper.mapToPaymentHistory(payment, StatusPayment.PAID);
            payment.addHistory(paymentHistory);
        }
        paymentRepository.save(payment);
    }
}
