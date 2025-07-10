package com.example.microservice.order.message;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final String TOPIC = "order-events";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void sendOrderEvent(Object data) throws Exception {
        String valueAsString = objectMapper.writeValueAsString(data);
        kafkaTemplate.send(TOPIC, valueAsString);
    }



}
