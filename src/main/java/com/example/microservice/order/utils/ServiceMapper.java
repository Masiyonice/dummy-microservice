package com.example.microservice.order.utils;


import com.example.microservice.order.DTO.OrderItemDTO;
import com.example.microservice.order.DTO.RequestOrderDTO;
import com.example.microservice.order.constant.OrderStatus;
import com.example.microservice.order.entity.Address;
import com.example.microservice.order.entity.OrderItem;
import com.example.microservice.order.entity.Orders;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServiceMapper {

    public static Orders mapToOrderEntity(RequestOrderDTO requestOrderDTO) {
        Orders order = new Orders().builder()
                .customerId(requestOrderDTO.getCustomerId())
                .restaurantId(requestOrderDTO.getRestaurantId())
                .orderStatus(requestOrderDTO.getOrderStatus() != null ? requestOrderDTO.getOrderStatus() : OrderStatus.PENDING)
                .build();
        Address address = new Address().builder()
                .street(requestOrderDTO.getStreet())
                .city(requestOrderDTO.getCity())
                .state(requestOrderDTO.getState())
                .zipCode(requestOrderDTO.getZipCode())
                .build();
        order.setAddress(address);
        return order;
    }

    public static List<OrderItem> mapToOrderItems(Set<OrderItemDTO> orderItems, Orders order) {
        return orderItems.stream()
                .map(item -> new OrderItem().builder()
                        .orderId(order)
                        .name(item.getName())
                        .quantity(item.getQuantity())
                        .price(item.getPrice())
                        .build())
                .toList();
    }

    public static Map<String, Object> mapToMessage(Orders entity, double sum) {
        return Map.of(
                "orderId", entity.getOrderId(),
                "nominalAmount", sum,
                "status", entity.getOrderStatus().name()
        );
    }
}
