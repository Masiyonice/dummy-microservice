package com.example.microservice.order.entity;

import com.example.microservice.order.constant.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = TableName.ADDRESS)
public class Address {
    private String id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
