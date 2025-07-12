package com.example.payment.repository;

import com.example.payment.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentHistoryrepository extends JpaRepository<PaymentHistory, Long> {
    // Additional query methods can be defined here if needed
}
