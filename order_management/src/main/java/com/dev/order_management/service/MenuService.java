//menu service - implementation

package com.dev.order_management.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.order_management.dto.menu.MenuRequest;
import com.dev.order_management.mapper.EntityMapper;
import com.dev.order_management.model.Menu;
import com.dev.order_management.repository.MenuRepository;
import com.dev.order_management.service.remote.MenuServiceRemote;

@Service
public class MenuService implements MenuServiceRemote{
	
	@Autowired
	MenuRepository menuRepository;
	
	@Autowired
	EntityMapper entityMapper;
	
	@Override
	public List<MenuRequest> getMenu() {
		List<Menu> menuList= menuRepository.findAll();
		List<MenuRequest> menuRequest = entityMapper.convertToListOfMenuDto(menuList);
		return menuRequest;
	}

	@Override
	public MenuRequest addNewItem(MenuRequest menuRequest) {
		Menu menu = entityMapper.convertToMenuEntity(menuRequest);
		menuRepository.save(menu);
		return entityMapper.convertToMenuDto(menu);
	}
	
	@Override
	public MenuRequest updateItem(MenuRequest menuRequest) {
		Menu menuItem = entityMapper.convertToMenuEntity(menuRequest);
		 return menuRepository.findById(menuItem.getItemId())
	        .map(updateMenuItem -> {
	            updateMenuItem.setItemName(menuItem.getItemName());
	            updateMenuItem.setItemPrice(menuItem.getItemPrice());
	            Menu saved = menuRepository.save(updateMenuItem);
	            return entityMapper.convertToMenuDto(saved);
	        })
	        .orElse(null);
	}

	@Override
	public boolean deleteItem(MenuRequest menuRequest) {
		Menu MenuItem = entityMapper.convertToMenuEntity(menuRequest);
		if(menuRepository.findById(MenuItem.getItemId()).isPresent()) {
			menuRepository.delete(MenuItem);
			return true;
		}
		return false;
	}

}
