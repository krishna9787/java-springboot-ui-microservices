package com.krishna9787.order.mapper;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import com.krishna9787.order.dto.OrdersDto;
import com.krishna9787.order.entity.Orders;
import com.krishna9787.order.util.OrderStatus;

public class OrdersMapper {

    public static OrdersDto mapToOrdersDto(Orders orders, OrdersDto ordersDto) {

        ordersDto.setEventId(orders.getEventId());
        ordersDto.setEventType(orders.getEventType());
        ordersDto.setOrderId(orders.getOrderId());
        ordersDto.setCustomerId(orders.getCustomerId());

        return ordersDto;
    }

    public static Orders mapToOrders(OrdersDto ordersDto, Orders orders, OrderStatus status) {

        orders.setEventId(ordersDto.getEventId());
        orders.setEventType(ordersDto.getEventType());
        orders.setOrderId(createOrderId());
        orders.setCustomerId(ordersDto.getCustomerId());
        orders.setOrderStatus(status);

        return orders;
    }

    public static String createOrderId() {
        SecureRandom RANDOM = new SecureRandom();
        return String.format("%03d", RANDOM.nextInt(1_000)) + "-" + String.format("%03d", RANDOM.nextInt(1_000)) + "-"
                + String.format("%03d", RANDOM.nextInt(1_000)) + "-" + String.format("%03d", RANDOM.nextInt(1_000));
    }
}
