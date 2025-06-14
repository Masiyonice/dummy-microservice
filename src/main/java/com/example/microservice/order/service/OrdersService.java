package com.example.microservice.order.service;

import com.example.microservice.order.DTO.RequestOrderDTO;

public interface OrdersService {
    void createOrder(RequestOrderDTO requestOrderDTO);
}
