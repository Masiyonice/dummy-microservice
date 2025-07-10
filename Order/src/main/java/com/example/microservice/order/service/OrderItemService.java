package com.example.microservice.order.service;

import com.example.microservice.order.DTO.OrderItemDTO;
import com.example.microservice.order.entity.Orders;

import java.util.Set;

public interface OrderItemService {
    void createOrderItem(Set<OrderItemDTO> orderItemDTOs, Orders orderId);
}
