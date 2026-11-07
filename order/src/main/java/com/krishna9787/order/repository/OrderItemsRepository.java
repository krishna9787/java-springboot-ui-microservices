package com.krishna9787.order.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.krishna9787.order.entity.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

    @Query(value = "SELECT oi.* FROM order_items oi JOIN orders o ON oi.order_id = o.id WHERE o.order_id = :orderId", nativeQuery = true)
    public Set<OrderItems> findByOrderId_OrderId(@Param("orderId") String orderId);
}
