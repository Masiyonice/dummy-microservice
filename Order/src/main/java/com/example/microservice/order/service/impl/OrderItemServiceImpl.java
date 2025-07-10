package com.example.microservice.order.service.impl;

import com.example.microservice.order.DTO.OrderItemDTO;
import com.example.microservice.order.entity.OrderItem;
import com.example.microservice.order.entity.Orders;
import com.example.microservice.order.repository.OrderItemRepository;
import com.example.microservice.order.repository.OrdersRepository;
import com.example.microservice.order.service.OrderItemService;

import com.example.microservice.order.utils.ServiceMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void createOrderItem(Set<OrderItemDTO> orderItemDTOs, Orders orderId) {
        List<OrderItem> orderItems = ServiceMapper.mapToOrderItems(orderItemDTOs, orderId);
        orderItemRepository.saveAll(orderItems);
    }
}
