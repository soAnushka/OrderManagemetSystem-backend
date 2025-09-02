//UserController controller


package com.dev.order_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.order_management.dto.user.UserRequest;
import com.dev.order_management.service.remote.UserServiceRemote;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/")
public class UserController {

	
	@Autowired
	private UserServiceRemote userServiceRemote;
	
	
	@PostMapping("/signup")
	public boolean sighup(@Valid @RequestBody UserRequest signupUserData ) {
		return userServiceRemote.signup(signupUserData);
	}
	 
	
	@PostMapping("/login")
	public Integer login(@RequestBody UserRequest loginUserData) {
		return userServiceRemote.login(loginUserData);
	}
}
