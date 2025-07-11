package com.example.payment.utils;

import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class CommonResponse<T> {
    private String message;
    private T data;
    private Integer statusCode;
}
