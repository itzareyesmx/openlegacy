package com.openlegacy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long item_no;

	private String name;

	private int amount;

	private String inventory_code;

	public long getItem_no() {
		return item_no;
	}

	public void setItem_no(long item_no) {
		this.item_no = item_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getInventory_code() {
		return inventory_code;
	}

	public void setInventory_code(String inventory_code) {
		this.inventory_code = inventory_code;
	}

}
