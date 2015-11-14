package edu.softeng.messageservice.messages.transaction;

import java.util.UUID;

import edu.softeng.messageservice.messages.Message;

public class TransactionAddProduct extends Message {
	private UUID transactionId;
	public UUID getTransactionId() {
		return this.transactionId;
	}
	public TransactionAddProduct setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	private UUID productId;
	public UUID getProductId() {
		return this.productId;
	}
	public TransactionAddProduct setProductId(UUID productId) {
		this.productId = productId;
		return this;
	}
	
	public TransactionAddProduct() {
		this.productId = new UUID(0, 0);
		this.transactionId = new UUID(0, 0);
	}
}
