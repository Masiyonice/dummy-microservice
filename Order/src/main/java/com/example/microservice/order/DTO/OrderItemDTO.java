package com.example.microservice.order.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemDTO {
    private String name;
    private Double price;
    private Integer quantity;
}
