//menu entity


package com.dev.order_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Menu {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
	
	@Column(nullable=false, unique=true)
	private String itemName;
	
	@Column(nullable=false)
	private Double itemPrice;
	
	
}
