package edu.softeng.messageservice.observers;

import edu.softeng.messageservice.messages.Message;

public interface Observer {
	void observe(Message message);
}
