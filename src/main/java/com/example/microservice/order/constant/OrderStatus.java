package com.example.microservice.order.constant;

public enum OrderStatus {
    PENDING,
    PAID,
    APPROVED,
    CANCELLING,
    CANCELLED;
    public boolean canTransitionTo(OrderStatus nextStatus) {
        return switch (this) {
            case PENDING -> nextStatus == PAID || nextStatus == CANCELLING;
            case PAID -> nextStatus == APPROVED || nextStatus == CANCELLING;
            case CANCELLING -> nextStatus == CANCELLED;
            default -> false;
        };
    }
}
