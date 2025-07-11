package com.example.microservice.order.service;

import com.example.microservice.order.DTO.RequestOrderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrdersService {
    void createOrder(RequestOrderDTO requestOrderDTO) throws Exception;
}
