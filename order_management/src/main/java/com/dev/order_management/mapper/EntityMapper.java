package com.dev.order_management.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.order_management.dto.customer.CustomerRequest;
import com.dev.order_management.dto.menu.MenuRequest;
import com.dev.order_management.dto.order.OrderRequest;
import com.dev.order_management.dto.order.OrderResponse;
import com.dev.order_management.dto.user.UserRequest;
import com.dev.order_management.model.Customer;
import com.dev.order_management.model.Menu;
import com.dev.order_management.model.Orders;
import com.dev.order_management.model.User;

@Component
public class EntityMapper {
	
	@Autowired
	private ModelMapper modelMapper;

    public EntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    
    //-------------------------------------------------------USER--------------------------------------------------
    
    public UserRequest convertToUserDto(User user) {
        return modelMapper.map(user, UserRequest.class);
    }

    public User convertToUserEntity(UserRequest userRequest) {
        return modelMapper.map(userRequest, User.class);
    }
    
    
    
    
    //-------------------------------------------------------MENU--------------------------------------------------
    public MenuRequest convertToMenuDto(Menu menu) {
        return modelMapper.map(menu, MenuRequest.class);
    }

    public Menu convertToMenuEntity(MenuRequest menuRequest) {
        return modelMapper.map(menuRequest, Menu.class);
    }
    
    public List<MenuRequest> convertToListOfMenuDto(List<Menu> menuList) {
        return menuList.stream()
        		.map(menuItem -> modelMapper.map(menuItem, MenuRequest.class))
        		.toList();

    }
    
    
    
    
    //-------------------------------------------------------CUSTOMER--------------------------------------------------
    public CustomerRequest convertToCustomerDto(Customer customer) {
        return modelMapper.map(customer, CustomerRequest.class);
    }

    public Customer convertToCustomerEntity(CustomerRequest customerRequest) {
        return modelMapper.map(customerRequest, Customer.class);
    }

    
    public List<CustomerRequest> convertToListOfCustomerDto(List<Customer> allCustomers) {
		return allCustomers.stream()
		.map(customer -> modelMapper.map(customer, CustomerRequest.class))
		.toList();
	}
    
    //-------------------------------------------------------ORDER--------------------------------------------------
    public OrderRequest convertToOrderDto(Orders order) {
    	CustomerRequest cus = modelMapper.map(order.getCustomer(), CustomerRequest.class);
        OrderRequest or = modelMapper.map(order, OrderRequest.class);
    	or.setCustomer(cus);
    	return or;
    }

    public Orders convertToOrderEntity(OrderRequest orderRequest) {
        return modelMapper.map(orderRequest, Orders.class);
    }
    
    public OrderResponse convertToOrderResponseDto(Orders order) {
        return modelMapper.map(order, OrderResponse.class);
    }


	public List<OrderRequest> convertToListOfOrderDto(List<Orders> allOrders) {
		return allOrders.stream()
		.map(orderItem -> modelMapper.map(orderItem, OrderRequest.class))
		.toList();
	}
}
