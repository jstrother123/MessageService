package edu.softeng.messageservice.messages.dto;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class Employee {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Employee setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String name;
	public String getName() {
		return this.name;
	}
	public Employee setName(String name) {
		this.name = name;
		return this;
	}
	
	private String badgeId;
	public String getBadgeId() {
		return this.badgeId;
	}
	public Employee setBadgeId(String badgeId) {
		this.badgeId = badgeId;
		return this;
	}
	
	public Employee() {
		this.id = new UUID(0, 0);
		this.name = StringUtils.EMPTY;
		this.badgeId = StringUtils.EMPTY;
	}
}
