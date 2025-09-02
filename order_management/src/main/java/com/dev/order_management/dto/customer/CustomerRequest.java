package com.dev.order_management.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
	private Long customerId;
	private String customerName;
    private Long customerPhone;
    private String customerAddress;
}
