package com.example.payment.message;

public interface KafkaConsumerService {

    void handleOrderEvent(String message);
}
