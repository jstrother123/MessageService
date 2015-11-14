package edu.softeng.messageservice.observers;

import edu.softeng.messageservice.messages.Message;

public class MessageProcessedConfirmationObserver implements Observer {
	public void observe(Message message) {
		System.out.printf("Observable::  Sending processed confirmation for message with ID %s", message.getMessageId().toString());
		System.out.println();
	}
}
