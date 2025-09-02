package com.dev.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.order_management.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
//	List<OrderItem> findAllByOrderId(Long orderId);
}
