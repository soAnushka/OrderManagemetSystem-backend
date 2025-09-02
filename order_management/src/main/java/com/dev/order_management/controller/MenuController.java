package com.dev.order_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.order_management.dto.menu.MenuRequest;
import com.dev.order_management.service.remote.MenuServiceRemote;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
	
	@Autowired
	MenuServiceRemote menuServiceRemote;
	
	//fetch all 
	@GetMapping
	public ResponseEntity<List<MenuRequest>> getMenu(){
		
		return ResponseEntity.ok(menuServiceRemote.getMenu());
	}
	
	//add new item
	@PostMapping
	public ResponseEntity<MenuRequest> addNewItem(@RequestBody MenuRequest menuRequest){
		return ResponseEntity.ok(menuServiceRemote.addNewItem(menuRequest));
	}
	
	//update item
	@PutMapping("/{id}")
	public ResponseEntity<MenuRequest> updateItem(@PathVariable Long id, @RequestBody MenuRequest menuRequest){
		menuRequest.setItemId(id);
		return ResponseEntity.ok(menuServiceRemote.updateItem(menuRequest));
	}
	
	//delete item
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id){
		boolean response = menuServiceRemote.deleteItem(MenuRequest.builder().itemId(id).build());
		if(response) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
