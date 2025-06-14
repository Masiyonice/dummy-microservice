package com.example.microservice.order.service.impl;

import com.example.microservice.order.DTO.RequestOrderDTO;
import com.example.microservice.order.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrdersService {

    private final OrderItemServiceImpl orderItemService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createOrder(RequestOrderDTO requestOrderDTO) {

    }
}
