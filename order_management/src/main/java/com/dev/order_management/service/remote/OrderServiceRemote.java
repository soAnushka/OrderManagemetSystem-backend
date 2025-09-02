//menu service - interface

package com.dev.order_management.service.remote;

import java.util.List;

import com.dev.order_management.dto.order.CreateOrderRequest;
import com.dev.order_management.dto.order.OrderRequest;
import com.dev.order_management.dto.order.OrderResponse;
import com.dev.order_management.dto.order_item.OrderItemRequest;

public interface OrderServiceRemote {
	
	// create new order
	OrderResponse createNewOrder( CreateOrderRequest payload);
	
	
	//get all orders
	List<OrderRequest> getOrders();
	
	//get perticular order details my order id
	OrderItemRequest getOrderDetails(Long orderId);
}
