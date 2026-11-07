package com.krishna9787.order.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna9787.order.dto.OrdersDto;
import com.krishna9787.order.dto.SuccessDto;
import com.krishna9787.order.service.OrdersService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/order/", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@AllArgsConstructor
public class OrderController {

    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity<SuccessDto> createOrder(@RequestBody OrdersDto ordersDto) {

        String orderId = ordersService.saveOrder(ordersDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new SuccessDto(HttpStatus.CREATED,
                        "Order Accepted. Order Id %s created. We are working on it.".formatted(orderId),
                        LocalDateTime.now()));
    }

    @GetMapping(path = "{orderId}")
    public ResponseEntity<OrdersDto> findOrderById(@PathVariable String orderId) {
        OrdersDto ordersDto = ordersService.findOrderById(orderId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ordersDto);

    }
}
