package com.openlegacy.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlegacy.domain.Item;
import com.openlegacy.repository.ItemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Inventory Management System")
public class InventoryController {

	@Autowired
	private ItemRepository itemRepository;

	@ApiOperation(value = "View a list of available items", response = List.class)
	@GetMapping
	public Iterable<Item> findAll() {
		return itemRepository.findAll();
	}

}
