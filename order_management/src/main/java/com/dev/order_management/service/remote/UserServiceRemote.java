//user service - interface

package com.dev.order_management.service.remote;

import com.dev.order_management.dto.user.UserRequest;


public interface UserServiceRemote {
	
	//login
	public Integer login(UserRequest loginUserData);
	//signup
	public boolean signup(UserRequest signupUserData);
}
