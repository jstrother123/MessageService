package edu.softeng.messageservice.messages.product;

import java.util.UUID;

import edu.softeng.messageservice.messages.Message;

public class ProductRemoved extends Message {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public ProductRemoved setId(UUID id) {
		this.id = id;
		return this;
	}
	
	public ProductRemoved() {
		this.id = new UUID(0, 0);
	}
}
