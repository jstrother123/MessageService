package edu.softeng.messageservice.visitors;

import edu.softeng.messageservice.observers.Observer;

public interface Observable {
	void attach(Observer observer);
	void detach(Observer observer);
}
