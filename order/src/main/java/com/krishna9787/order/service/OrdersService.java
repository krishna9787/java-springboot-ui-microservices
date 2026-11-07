package com.krishna9787.order.service;

import com.krishna9787.order.dto.OrdersDto;

public interface OrdersService {
    public String saveOrder(OrdersDto ordersDto);

    public OrdersDto findOrderById(String orderId);
}
