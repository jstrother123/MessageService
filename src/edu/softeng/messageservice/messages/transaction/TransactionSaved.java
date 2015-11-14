package edu.softeng.messageservice.messages.transaction;

import edu.softeng.messageservice.messages.Message;
import edu.softeng.messageservice.messages.dto.Transaction;

public class TransactionSaved extends Message {
	private Transaction transaction;
	public Transaction getTransaction() {
		return this.transaction;
	}
	public TransactionSaved setTransaction(Transaction transaction) {
		this.transaction = transaction;
		return this;
	}
	
	public TransactionSaved() {
		this.transaction = new Transaction();
	}
}
