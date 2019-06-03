package com.openlegacy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.openlegacy.domain.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

}