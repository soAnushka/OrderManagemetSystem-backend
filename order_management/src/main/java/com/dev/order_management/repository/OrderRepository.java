//OrderRepository - repository


package com.dev.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.order_management.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
