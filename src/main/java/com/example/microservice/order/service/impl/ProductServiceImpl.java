package com.example.microservice.order.service.impl;

import com.example.microservice.order.repository.ProductRepository;
import com.example.microservice.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
}
