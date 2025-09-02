package com.dev.order_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.order_management.dto.customer.CustomerRequest;
import com.dev.order_management.service.remote.CustomerServiceRemote;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceRemote customerServiceRemote;
	
	@GetMapping
	public ResponseEntity<List<CustomerRequest>> getCustomers(){
		return  ResponseEntity.ok(customerServiceRemote.getAllCustomers());
	}
	
	
	@GetMapping("/{phone}")
	public ResponseEntity<CustomerRequest> getCustomerByPhone(@PathVariable Long phone){		
		return ResponseEntity.ok(customerServiceRemote.getCustomerByPhone(phone));
	}
}
