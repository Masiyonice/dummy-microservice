package com.example.microservice.order.entity;

import com.example.microservice.order.constant.OrderStatus;
import com.example.microservice.order.constant.TableName;
import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;
    private String customerId;
    private String restaurantId;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private Double money;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;
    private String trackId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
