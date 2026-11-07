package com.krishna9787.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.krishna9787.order.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query(value = "SELECT * FROM orders o WHERE o.order_id=:orderId", nativeQuery = true)
    public Optional<Orders> findByOrderId(@Param("orderId") String orderId);

    // @Query(value = "SELECT OrdersDto FROM orders o JOIN order_items p ON
    // o.id=p.order_id and o.order_id=:orderId")
    // public OrdersDto findOrderAndOrderItems(@Param("orderId") String orderId);

}
