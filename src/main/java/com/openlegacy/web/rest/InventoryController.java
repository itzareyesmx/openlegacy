package com.openlegacy.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.openlegacy.domain.Item;
import com.openlegacy.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:9000")
@Api(value = "Inventory Management System")
public class InventoryController {
	
	 private final Logger log = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "List of inventory items list")
	@GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get a page of Items");
        Page<Item> page = itemService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

	@ApiOperation(value = "Add item to stock")
	@PostMapping("/items")
	public ResponseEntity<Item> createItem(@RequestBody Item item) throws URISyntaxException {
		if (item.getId() != null) {
			throw new URISyntaxException("A new item cannot already have an ID", "Item");
		}
		Item result = itemService.save(item);
		return ResponseEntity.created(new URI("/api/items/" + result.getId())).body(result);
	}
	
	@ApiOperation(value = "Update item")
    @PutMapping("/items")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) throws URISyntaxException {
        log.debug("REST request to update Item : {}", item);
        if (item.getId() == null) {
            throw new URISyntaxException("Invalid id", "Item");
        }
        Item result = itemService.save(item);
        return ResponseEntity.ok().body(result);
    }
    
	@ApiOperation(value = "Read item details")
    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        log.debug("REST request to get Item : {}", id);
        Optional<Item> item = itemService.findOne(id);
        return ResponseEntity.ok().body(item.get());
    }
	
	@ApiOperation(value = "Delete an item from stock")
	@DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        log.debug("REST request to delete Item : {}", id);
        itemService.delete(id);
        return ResponseEntity.ok().build();
    }

}
