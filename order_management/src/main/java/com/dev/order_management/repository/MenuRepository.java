//MenuRepository - repository

package com.dev.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.order_management.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
