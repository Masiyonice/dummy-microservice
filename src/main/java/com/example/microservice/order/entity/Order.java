package com.example.microservice.order.entity;

import com.example.microservice.order.constant.OrderStatus;
import com.example.microservice.order.constant.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = TableName.ORDER)
public class Order {
    private String orderId;
    private String customerId;
    private String restaurantId;
    private Address address;
    private Double money;
    private List<OrderItem> orderItem;
    private String trackId;
    private OrderStatus orderStatus;
}
