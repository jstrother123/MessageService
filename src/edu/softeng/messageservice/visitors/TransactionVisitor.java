package edu.softeng.messageservice.visitors;

import edu.softeng.messageservice.messages.dto.Transaction;
import edu.softeng.messageservice.messages.transaction.TransactionAddProduct;
import edu.softeng.messageservice.messages.transaction.TransactionSaved;

public class TransactionVisitor extends Visitor {
	public void Visit(TransactionSaved transactionSaved) {
		Transaction transaction = transactionSaved.getTransaction();

		System.out.printf("Saving transaction with ID %s", transaction.getId().toString());
		System.out.println();
	}

	public void Visit(TransactionAddProduct transactionAddProduct) {
		System.out.printf("Adding product %s to transaction %s", transactionAddProduct.getProductId().toString(), transactionAddProduct.getTransactionId().toString());
		System.out.println();
	}
	
	@Override
	public TransactionVisitor createOne() {
		return new TransactionVisitor();
	}
	
	static {
		VisitorFactory.register(VisitorType.TRANSACTION, new TransactionVisitor());
	}
}
