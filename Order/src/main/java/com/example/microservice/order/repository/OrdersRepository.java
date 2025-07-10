package com.example.microservice.order.repository;

import com.example.microservice.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // Additional query methods can be defined here if needed
}
