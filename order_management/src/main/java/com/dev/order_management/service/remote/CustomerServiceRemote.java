package com.dev.order_management.service.remote;

import java.util.List;

import com.dev.order_management.dto.customer.CustomerRequest;

public interface CustomerServiceRemote {
	
	// get Customer By Phone
	CustomerRequest getCustomerByPhone(Long phone);

	List<CustomerRequest> getAllCustomers();
}
