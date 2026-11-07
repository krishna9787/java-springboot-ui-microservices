package com.krishna9787.order.dto;

import java.util.Set;

import com.krishna9787.order.util.OrderStatus;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {

    private String eventId;

    private String eventType;

    private String customerId;

    @Column(unique = true)
    private String orderId;

    private Set<OrderItemsDto> orderItemsDtos;

    private OrderStatus orderStatus;
}
