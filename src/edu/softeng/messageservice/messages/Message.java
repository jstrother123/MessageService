package edu.softeng.messageservice.messages;

import java.util.UUID;

public abstract class Message {
	private UUID messageId;
	public UUID getMessageId() {
		return this.messageId;
	}
	
	protected Message() {
		this.messageId = UUID.randomUUID();
	}
}
