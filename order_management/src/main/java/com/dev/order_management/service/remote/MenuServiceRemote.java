//menu service - interface

package com.dev.order_management.service.remote;

import java.util.List;

import com.dev.order_management.dto.menu.MenuRequest;

public interface MenuServiceRemote {
	
	//fetch complete menu to display
	public List<MenuRequest> getMenu();
	
	//delete item from menu
	public boolean deleteItem(MenuRequest menuRequest);
	
	//update item on menu
	public MenuRequest updateItem(MenuRequest menuRequest);
	
	//add new item in menu
	public MenuRequest addNewItem(MenuRequest menuRequest);
}
