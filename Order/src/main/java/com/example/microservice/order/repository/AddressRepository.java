package com.example.microservice.order.repository;

import com.example.microservice.order.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    // Additional query methods can be defined here if needed
}
