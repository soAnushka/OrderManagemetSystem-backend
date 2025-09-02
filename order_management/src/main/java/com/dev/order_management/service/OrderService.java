package com.dev.order_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.order_management.dto.customer.CustomerRequest;
import com.dev.order_management.dto.order.CreateOrderRequest;
import com.dev.order_management.dto.order.ItemRequest;
import com.dev.order_management.dto.order.OrderRequest;
import com.dev.order_management.dto.order.OrderResponse;
import com.dev.order_management.dto.order_item.OrderItemRequest;
import com.dev.order_management.mapper.EntityMapper;
import com.dev.order_management.model.Customer;
import com.dev.order_management.model.Menu;
import com.dev.order_management.model.OrderItem;
import com.dev.order_management.model.Orders;
import com.dev.order_management.repository.CustomerRepository;
import com.dev.order_management.repository.MenuRepository;
import com.dev.order_management.repository.OrderItemRepository;
import com.dev.order_management.repository.OrderRepository;
import com.dev.order_management.service.remote.OrderServiceRemote;

@Service
public class OrderService implements OrderServiceRemote {
	
	@Autowired
	EntityMapper entityMapper;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	MenuRepository menuRepo;
	
	@Autowired
	OrderItemRepository orderItemRepo;
	
	//get order details -> all items in it..
	
	
	
	
	//fetch all orders
	@Override
	public List<OrderRequest> getOrders() {
		List<Orders> allOrders = orderRepo.findAll(); 
		List<OrderRequest> orderRequest = entityMapper.convertToListOfOrderDto(allOrders);
		return orderRequest;
	}
	
	//create new Order
	@Override
	public OrderResponse createNewOrder(CreateOrderRequest payload) {
		Orders savedOrder; // order <- hold order id
		Customer customer; // customer associated with the order <- hold current customer id
		
		//check if customer exists..
		//create/update customer
		//get customer id -> in customer 
		CustomerRequest customerRequest = payload.getCustomer();  
		if(customerRequest.getCustomerId()==null) { // new customer 
			Customer newCustomer = entityMapper.convertToCustomerEntity(customerRequest);
			customer = customerRepo.save(newCustomer);
		}
		else {
			Customer updateCustomer= customerRepo.findById(customerRequest.getCustomerId()).orElse(null);
				updateCustomer.setCustomerName(customerRequest.getCustomerName());
				updateCustomer.setCustomerAddress(customerRequest.getCustomerAddress());
				updateCustomer.setCustomerPhone(customerRequest.getCustomerPhone());
				customer = customerRepo.save(updateCustomer);			
		}
		
		//use customer <- for customer id
		//create order
		//get order id -> in order
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.setCustomer(entityMapper.convertToCustomerDto(customer));
		orderRequest.setOrderDate(payload.getOrderDate());
		orderRequest.setTotalQuantity(payload.getTotalQuantity());
		orderRequest.setTotalAmount(payload.getTotalAmount());
		savedOrder = orderRepo.save(entityMapper.convertToOrderEntity(orderRequest));
		
		
		//use order <- for order id
		//create order items
		//with payload's -> items details
		for(ItemRequest orderItem : payload.getItems()) {
			//OrderItem -> {orderId- order, itemId -item, quantity, itemPrice  }
			OrderItem item = new OrderItem(); 
			item.setOrder(savedOrder); // -> order-id
			Menu menu = menuRepo.findById(orderItem.getItemId()).orElse(null);
			item.setItem(menu); //// -> item-id
			item.setItemPrice(orderItem.getItemPrice()); // -> price at purchace
			item.setQuantity(orderItem.getQuantity()); // -> quantity
			orderItemRepo.save(item);
		}
		
		return entityMapper.convertToOrderResponseDto(savedOrder);
	}

	
	//get the order item details for -> given order-id
	//one order detail at a time
	@Override
	public OrderItemRequest getOrderDetails(Long orderId) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}


}
