package edu.softeng.messageservice.observers;

import edu.softeng.messageservice.messages.Message;

public class MessageCleanUpObserver implements Observer {
	public void observe(Message message) {
		System.out.printf("Observable::  Cleaning up message with ID %s", message.getMessageId().toString());
		System.out.println();
	}
}
