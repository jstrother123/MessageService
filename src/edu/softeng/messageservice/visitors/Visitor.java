package edu.softeng.messageservice.visitors;

import edu.softeng.messageservice.messages.Message;
import edu.softeng.messageservice.visitors.interfaces.VisitorFactoryInterface;

public abstract class Visitor implements VisitorFactoryInterface {
	public void beforeVisit(Message message) {
		System.out.printf("Visiting message with ID %s", message.getMessageId().toString());
		System.out.println();
	}

	public void failedVisit(Message message) { }

	public void successfulVisit(Message message) { }

	@Override
	public abstract Visitor createOne(); 
}
