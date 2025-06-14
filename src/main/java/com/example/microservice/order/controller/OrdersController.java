package com.example.microservice.order.controller;

import com.example.microservice.order.DTO.RequestOrderDTO;
import com.example.microservice.order.constant.APIUrl;
import com.example.microservice.order.constant.ResponseMessage;
import com.example.microservice.order.service.OrdersService;
import com.example.microservice.order.utils.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = APIUrl.ORDERS)
public class OrdersController {

    private final OrdersService orderService;

    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;
        System.out.println("OrdersController loaded ");
    }

    @GetMapping
    public String getAllOrders() {
        System.out.println("getAllOrders called");
        return "ping";
    }

    @GetMapping("/testing")
    public ResponseEntity<CommonResponse<String>> testEndpoint() {
        CommonResponse<String> response = CommonResponse.<String>builder()
                .statusCode(200)
                .message(ResponseMessage.SUCCESS_GET_DATA)
                .data("This is a test endpoint")
                .build();
        return ResponseEntity.ok(response);
    }

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
