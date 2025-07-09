package com.example.microservice.order.controller;

import com.example.microservice.order.DTO.RequestOrderDTO;
import com.example.microservice.order.constant.APIUrl;
import com.example.microservice.order.constant.ResponseMessage;
import com.example.microservice.order.service.OrdersService;
import com.example.microservice.order.utils.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.ORDERS)
public class OrdersController {

    private final OrdersService orderService;

    @PostMapping
    public ResponseEntity<CommonResponse<?>> createOrder(@RequestBody RequestOrderDTO requestOrderDTO) {
        orderService.createOrder(requestOrderDTO);
        CommonResponse<?> response = CommonResponse.builder()
                .statusCode(201)
                .message(ResponseMessage.SUCCESS_SAVE_DATA)
                .build();
        return ResponseEntity.status(201).body(response);
    }
}
