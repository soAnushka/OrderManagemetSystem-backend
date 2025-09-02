package com.dev.order_management.dto.order;

import java.time.LocalDateTime;

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
public class OrderRequest {
	
	private Long orderId;
	private CustomerRequest customer;  // Key field
	
	@JsonFormat
	private LocalDateTime orderDate;
	private Integer totalQuantity;
    private Double totalAmount;

}
