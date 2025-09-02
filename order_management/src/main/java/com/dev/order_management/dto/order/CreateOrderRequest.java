package com.dev.order_management.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import com.dev.order_management.dto.customer.CustomerRequest;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
	
	CustomerRequest customer;
	List<ItemRequest> items;
	
	@JsonFormat
	LocalDateTime orderDate;
	Double totalAmount;
	Integer totalQuantity;
}
