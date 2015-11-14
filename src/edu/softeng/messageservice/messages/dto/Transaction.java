package edu.softeng.messageservice.messages.dto;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

public class Transaction {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Transaction setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private UUID employeeId;
	public UUID getEmployeeId() {
		return this.employeeId;
	}
	public Transaction setEmployeeId(UUID employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	
	private LinkedList<UUID> productIds;
	public LinkedList<UUID> getProductIds() {
		return this.productIds;
	}
	public Transaction setProductIds(LinkedList<UUID> productIds) {
		this.productIds = productIds;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Transaction setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	public Transaction() {
		this.id = new UUID(0, 0);
		this.employeeId = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
		this.productIds = new LinkedList<UUID>();
	}
}
