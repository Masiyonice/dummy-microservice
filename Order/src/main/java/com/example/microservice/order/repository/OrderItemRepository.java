package com.example.microservice.order.repository;

import com.example.microservice.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Additional query methods can be defined here if needed
}
