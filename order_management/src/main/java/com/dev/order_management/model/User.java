//user entity

package com.dev.order_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	private String username;
	
	@Column(nullable=false)
	private String fullName;
	
	@Email
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	@Size(min = 6)
	private String password;
	
	private String contact;
	
}
