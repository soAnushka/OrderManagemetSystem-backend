//UserRepository - repository


package com.dev.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.order_management.model.User;



public interface UserRepository extends JpaRepository<User, String> {
	
}