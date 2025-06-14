package com.example.microservice.order.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;


@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class RequestOrderDTO {
    private String customerId;
    private String restaurantId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private Set<OrderItemDTO> orderItems;
}

