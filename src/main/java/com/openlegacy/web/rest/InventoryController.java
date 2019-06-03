package com.openlegacy.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
@Api(value = "Inventory Management System")
public class InventoryController {
	
	 private final Logger log = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "View a list of available items", response = List.class)
	@GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get a page of Items");
        Page<Item> page = itemService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

	@PostMapping("/items")
	public ResponseEntity<Item> createItem(@RequestBody Item item) throws URISyntaxException {
		if (item.getId() != null) {
			throw new URISyntaxException("A new item cannot already have an ID", "Item");
		}
		Item result = itemService.save(item);
		return ResponseEntity.created(new URI("/api/items/" + result.getId())).body(result);
	}
	
	/**
     * {@code PUT  /items} : Updates an existing item.
     *
     * @param item the item to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated item,
     * or with status {@code 400 (Bad Request)} if the item is not valid,
     * or with status {@code 500 (Internal Server Error)} if the item couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/items")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) throws URISyntaxException {
        log.debug("REST request to update Item : {}", item);
        if (item.getId() == null) {
            throw new URISyntaxException("Invalid id", "Item");
        }
        Item result = itemService.save(item);
        return ResponseEntity.ok()
            .body(result);
    }

}
