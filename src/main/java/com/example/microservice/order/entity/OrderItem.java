package com.example.microservice.order.entity;

import com.example.microservice.order.constant.TableName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = TableName.ORDER_ITEM)
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_sequence")
    @SequenceGenerator(name = "order_item_sequence", sequenceName = "order_item_sequence", allocationSize = 1)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productId;
    private Double price;
    private Integer quantity;
}
