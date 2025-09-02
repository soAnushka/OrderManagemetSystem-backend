package com.dev.order_management.dto.order_item;

import com.dev.order_management.dto.menu.MenuRequest;
import com.dev.order_management.dto.order.OrderRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {
	OrderRequest order;
	MenuRequest item;
	Integer quantity;
	Double itemPrice;
}
