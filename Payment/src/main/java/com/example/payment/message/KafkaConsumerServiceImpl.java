package com.example.payment.message;

import com.example.payment.constant.ConsumerGroup;
import com.example.payment.constant.Topic;
import com.example.payment.dto.OrderEvent;
import com.example.payment.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final ObjectMapper objectMapper;
    private final PaymentService paymentService;


    @Override
    @KafkaListener(topics = Topic.ORDER_EVENT, groupId = ConsumerGroup.ORDER_EVENT)
    public void handleOrderEvent(String message) {
        try {
            OrderEvent orderEvent = objectMapper.readValue(message, OrderEvent.class);
            paymentService.submitPayment(orderEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
