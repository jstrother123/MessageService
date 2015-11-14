package edu.softeng.messageservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

import edu.softeng.messageservice.messages.Message;
import edu.softeng.messageservice.messages.dto.Employee;
import edu.softeng.messageservice.messages.dto.Product;
import edu.softeng.messageservice.messages.employee.EmployeeSaved;
import edu.softeng.messageservice.messages.product.ProductSaved;
import edu.softeng.messageservice.observers.MessageCleanUpObserver;
import edu.softeng.messageservice.observers.MessageProcessedConfirmationObserver;
import edu.softeng.messageservice.observers.Observer;
import edu.softeng.messageservice.visitors.MessageVisitor;

public class Main {
	public static void main(String[] args) {
		setUp();
		
		Message employeeSaved = (new EmployeeSaved()).
			setEmployee(
				(new Employee()).
					setId(UUID.randomUUID()).
					setName("Jane Doe").
					setBadgeId(RandomStringUtils.randomAlphabetic(15))
			);

		MessageVisitor.getInstance().VisitMessage(employeeSaved);
		
		Message productSaved = (new ProductSaved()).
			setProduct(
				(new Product()).
					setId(UUID.randomUUID()).
					setLookupCode(RandomStringUtils.randomAlphabetic(10)).
					setPrice(15.99)
			);
		
		MessageVisitor.getInstance().VisitMessage(productSaved);
		
		readLine();
		tearDown();
	}
	
	private static void setUp() {
		try {
			Class.forName(PRODUCT_VISITOR_CLASS_NAME);
			Class.forName(EMPLOYEE_VISITOR_CLASS_NAME);
			Class.forName(TRANSACTION_VISITOR_CLASS_NAME);
		} catch (ClassNotFoundException e) { }
		
		observers = new LinkedList<Observer>();
		observers.add(new MessageCleanUpObserver());
		observers.add(new MessageProcessedConfirmationObserver());

		for (Observer observer : observers) {
			MessageVisitor.getInstance().attach(observer);
		}
	}
	
	private static void readLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
		} catch (IOException e) { }
    }

	private static void tearDown() {
		for (Observer observer : observers) {
			MessageVisitor.getInstance().detach(observer);
		}
	}
	
	private static List<Observer> observers;
	
	private static final String PRODUCT_VISITOR_CLASS_NAME = "edu.softeng.messageservice.visitors.ProductVisitor";
	private static final String EMPLOYEE_VISITOR_CLASS_NAME = "edu.softeng.messageservice.visitors.EmployeeVisitor";
	private static final String TRANSACTION_VISITOR_CLASS_NAME = "edu.softeng.messageservice.visitors.TransactionVisitor";
}
