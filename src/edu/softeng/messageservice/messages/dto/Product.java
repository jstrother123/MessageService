package edu.softeng.messageservice.messages.dto;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class Product {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Product setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public Product setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}
	
	private double price;
	public double getPrice() {
		return this.price;
	}
	public Product setPrice(double price) {
		this.price = price;
		return this;
	}
	
	public Product() {
		this.price = 0D;
		this.id = new UUID(0, 0);
		this.lookupCode = StringUtils.EMPTY;
	}
}
