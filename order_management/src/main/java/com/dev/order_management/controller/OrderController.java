package com.dev.order_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.order_management.dto.order.CreateOrderRequest;
import com.dev.order_management.dto.order.OrderRequest;
import com.dev.order_management.dto.order.OrderResponse;
import com.dev.order_management.dto.order_item.OrderItemRequest;
import com.dev.order_management.service.remote.OrderServiceRemote;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderServiceRemote orderServiceRemote;
	
	//fetch all orders
	@GetMapping
	ResponseEntity<List<OrderRequest>> getOrders(){
		return ResponseEntity.ok(orderServiceRemote.getOrders());
	}
	
	
	//get Order details...
	@GetMapping("/{orderId}")
	ResponseEntity<OrderItemRequest> getOrderDetails(@PathVariable Long orderId){
		return ResponseEntity.ok(orderServiceRemote.getOrderDetails(orderId));
	}
	
	
	//create new order
	@PostMapping
	ResponseEntity<OrderResponse> createNewOrder(@RequestBody CreateOrderRequest payload){
		return ResponseEntity.ok(orderServiceRemote.createNewOrder(payload));
	}
	
	
	
	//update order @PutMapping -from order list screen
	
	
	//delete order @DeleteMapping - from order list screen
	
	
}