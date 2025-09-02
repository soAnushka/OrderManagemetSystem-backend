//userservice -service implementation

package com.dev.order_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.order_management.dto.user.UserRequest;
import com.dev.order_management.mapper.EntityMapper;
import com.dev.order_management.model.User;
import com.dev.order_management.repository.UserRepository;
import com.dev.order_management.service.remote.UserServiceRemote;

@Service
public class UserService implements UserServiceRemote{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EntityMapper entityMapper;
	
	
	//login function
	public Integer login(UserRequest loginUserData) {
		Optional<User> existingUser = userRepository.findById(loginUserData.getUsername());
        if (existingUser.isPresent()) {
        	User user = existingUser.get();
        	if(user.getPassword().equals((loginUserData).getPassword())) {
        		return 1; //success
        	}
            return 0; //wrong password
        }
		return -1; //user not found
	}
	
	
	//signup function
	public boolean signup(UserRequest signupUserData) {
		
		Optional<User> existingUser = userRepository.findById(signupUserData.getUsername());
        if (existingUser.isPresent()) {
            return false; //already exists
        }
        
        User createUserData = entityMapper.convertToUserEntity(signupUserData);
        userRepository.save(createUserData);
		return true; //created
	}
	
}
