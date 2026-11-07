package com.krishna9787.order.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import com.krishna9787.order.dto.OrdersDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class OrderCreatedProducer {

    private KafkaTemplate<String, OrdersDto> kafkaTemplate;

    @Value("${spring.kafka.topics.order-created}")
    private String orderEventsTopic;

    public void sendOrderCreateEvent(OrdersDto ordersDto) {
        kafkaTemplate.send(orderEventsTopic, ordersDto.getOrderId(), ordersDto);
    }

}
