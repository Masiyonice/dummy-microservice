package com.example.payment.entity;

import com.example.payment.constant.StatusPayment;
import com.example.payment.constant.TableName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = TableName.HISTORY)
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_history_seq")
    @SequenceGenerator(name = "payment_history_seq", sequenceName = "payment_history_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Payment payment;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private StatusPayment status;
}
