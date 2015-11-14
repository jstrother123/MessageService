package edu.softeng.messageservice.messages.employee;

import java.util.UUID;

import edu.softeng.messageservice.messages.Message;

public class EmployeeLoggedIn extends Message {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public EmployeeLoggedIn setId(UUID id) {
		this.id = id;
		return this;
	}
	
	public EmployeeLoggedIn() {
		this.id = new UUID(0, 0);
	}
}
