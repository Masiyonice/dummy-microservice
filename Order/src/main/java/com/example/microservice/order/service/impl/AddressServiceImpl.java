package com.example.microservice.order.service.impl;

import com.example.microservice.order.repository.AddressRepository;
import com.example.microservice.order.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
}
