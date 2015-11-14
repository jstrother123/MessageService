package edu.softeng.messageservice.visitors;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.softeng.messageservice.messages.Message;
import edu.softeng.messageservice.observers.Observer;

public class MessageVisitor implements Observable {
	public void VisitMessage(Message message) {
		boolean foundVisitor = false;
		
		for (Visitor visitor : VisitorFactory.all()) {
			for (Method method : visitor.getClass().getMethods()) {
				if (!StringUtils.equals(method.getName(), VISIT_METHOD_NAME)) {
					continue;
				}
				
				if (StringUtils.equals(message.getClass().getCanonicalName(), method.getParameterTypes()[0].getCanonicalName())) {
					foundVisitor = true;

					this.VisitMessage(visitor, method, message);
				}
			}
			
			if (foundVisitor) {
				break;
			}
		}
	}
	
	public void attach(Observer observer) {
		this.observables.add(observer);
	}
	public void detach(Observer observer) {
		this.observables.remove(observer);
	}
	
	private void VisitMessage(Visitor visitor, Method visitMethod, Message message) {
		try {
			visitor.beforeVisit(message);

			visitMethod.invoke(visitor, message);

			visitor.successfulVisit(message);
		} catch (Exception e) {
			System.out.printf("Error while visiting. %s", e.getMessage()); System.out.println();
			visitor.failedVisit(message);
		}
		
		for (Observer observable : this.observables) {
			observable.observe(message);
		}
	}
	
	private List<Observer> observables;
	
	private final String VISIT_METHOD_NAME = "Visit";
	
	//Singleton
	private static MessageVisitor instance;
	
	private MessageVisitor() {
		this.observables = new LinkedList<Observer>();
	}
	
	public static MessageVisitor getInstance() {
		if (instance == null) {
			synchronized (VisitorFactory.class) {
				if (instance == null) {
					instance = new MessageVisitor();
				}
			}
		}
		
		return instance;
	}
}
