package com.krishna9787.order.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.krishna9787.order.dto.OrderItemsDto;
import com.krishna9787.order.dto.OrdersDto;
import com.krishna9787.order.entity.OrderItems;
import com.krishna9787.order.entity.Orders;
import com.krishna9787.order.exception.OrderNotFoundException;
import com.krishna9787.order.mapper.OrderItemsMapper;
import com.krishna9787.order.mapper.OrdersMapper;
import com.krishna9787.order.repository.OrderItemsRepository;
import com.krishna9787.order.repository.OrdersRepository;
import com.krishna9787.order.service.OrdersService;
import com.krishna9787.order.util.OrderStatus;

@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersRepository ordersRepository;
    private OrderItemsRepository orderItemsRepository;

    protected OrdersServiceImpl(OrdersRepository ordersRepository, OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public String saveOrder(OrdersDto ordersDto) {

        Orders order = OrdersMapper.mapToOrders(ordersDto, new Orders(), OrderStatus.PENDING);
        order = ordersRepository.save(order);

        for (OrderItemsDto items : ordersDto.getOrderItemsDtos()) {
            items.setOrderId(order);
            OrderItems orderItems = OrderItemsMapper.mapToOrdersItems(items, new OrderItems());
            orderItemsRepository.save(orderItems);
        }

        return order.getOrderId();
    }

    @Override
    public OrdersDto findOrderById(String orderId) {
        Orders order = ordersRepository.findByOrderId(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not Found"));
        Set<OrderItems> orderItems = orderItemsRepository.findByOrderId_OrderId(order.getOrderId());
        Set<OrderItemsDto> orderItemsDtos = new HashSet<>();
        for (OrderItems orderItem : orderItems) {
            orderItemsDtos.add(OrderItemsMapper.mapToOrderItemsDto(orderItem, new OrderItemsDto()));
        }
        OrdersDto ordersDto = OrdersMapper.mapToOrdersDto(order, new OrdersDto());
        ordersDto.setOrderItemsDtos(orderItemsDtos);

        return ordersDto;
    }

}
