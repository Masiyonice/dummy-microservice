package com.example.microservice.order.service.impl;

import com.example.microservice.order.DTO.RequestOrderDTO;
import com.example.microservice.order.entity.Orders;
import com.example.microservice.order.repository.OrdersRepository;
import com.example.microservice.order.service.OrderItemService;
import com.example.microservice.order.service.OrdersService;
import com.example.microservice.order.utils.ServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrderItemService orderItemService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createOrder(RequestOrderDTO requestOrderDTO) {
        if (requestOrderDTO.getOrderItems() == null || requestOrderDTO.getOrderItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item.");
        }
        Orders orders = ServiceMapper.mapToOrderEntity(requestOrderDTO);
        Orders entity = ordersRepository.saveAndFlush(orders);
        orderItemService.createOrderItem(
                requestOrderDTO.getOrderItems(),
                entity
        );
    }
}
