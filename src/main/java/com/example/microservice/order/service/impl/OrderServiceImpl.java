package com.example.microservice.order.service.impl;

import com.example.microservice.order.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrdersService {

    private final OrderItemServiceImpl orderItemService;
}
