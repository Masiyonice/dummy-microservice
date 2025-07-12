package com.example.payment.entity;

import com.example.payment.constant.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = TableName.PAYMENT)
public class Payment {
    @Id
    private String id;
    private Double amount;
    @Column(unique = true)
    private Integer orderId;
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaymentHistory> history =new ArrayList<>();

    public void addHistory(PaymentHistory paymentHistory) {
        history.add(paymentHistory);
        paymentHistory.setPayment(this);
    }
}
