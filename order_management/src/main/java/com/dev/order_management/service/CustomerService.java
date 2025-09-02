package com.dev.order_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.order_management.dto.customer.CustomerRequest;
import com.dev.order_management.mapper.EntityMapper;
import com.dev.order_management.model.Customer;
import com.dev.order_management.repository.CustomerRepository;
import com.dev.order_management.service.remote.CustomerServiceRemote;

@Service
public class CustomerService implements CustomerServiceRemote {
	@Autowired
	EntityMapper entityMapper;
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public CustomerRequest getCustomerByPhone(Long phone) {
		Customer customer = customerRepository.findByCustomerPhone(phone).orElse(null);
		return entityMapper.convertToCustomerDto(customer);
	}

	@Override
	public List<CustomerRequest> getAllCustomers() {
		List<Customer> customer = customerRepository.findAll();
		return entityMapper.convertToListOfCustomerDto(customer);
	}


	
}
