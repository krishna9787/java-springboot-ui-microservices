package com.krishna9787.order.mapper;

import com.krishna9787.order.dto.OrderItemsDto;
import com.krishna9787.order.entity.OrderItems;

public class OrderItemsMapper {

    public static OrderItems mapToOrdersItems(OrderItemsDto orderItemsDto, OrderItems orderItems) {

        orderItems.setOrderId(orderItemsDto.getOrderId());
        orderItems.setProductId(orderItemsDto.getProductId());
        orderItems.setProductName(orderItemsDto.getProductName());
        orderItems.setQuantity(orderItemsDto.getQuantity());
        orderItems.setSku(orderItemsDto.getSku());
        orderItems.setTotalPrice(orderItemsDto.getTotalPrice());
        orderItems.setUnitPrice(orderItemsDto.getUnitPrice());

        return orderItems;
    }

    public static OrderItemsDto mapToOrderItemsDto(OrderItems orderItems, OrderItemsDto orderItemsDto) {
        orderItemsDto.setOrderId(orderItems.getOrderId());
        orderItemsDto.setProductId(orderItems.getProductId());
        orderItemsDto.setProductName(orderItems.getProductName());
        orderItemsDto.setQuantity(orderItems.getQuantity());
        orderItemsDto.setSku(orderItems.getSku());
        orderItemsDto.setTotalPrice(orderItems.getTotalPrice());
        orderItemsDto.setUnitPrice(orderItems.getUnitPrice());

        return orderItemsDto;
    }

}
