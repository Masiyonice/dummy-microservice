package com.example.microservice.order.message;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaProducerService {
    void sendOrderEvent(Object data) throws Exception;
}
