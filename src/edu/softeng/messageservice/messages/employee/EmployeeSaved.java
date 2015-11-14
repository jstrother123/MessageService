package edu.softeng.messageservice.messages.employee;

import edu.softeng.messageservice.messages.Message;
import edu.softeng.messageservice.messages.dto.Employee;

public class EmployeeSaved extends Message {
	private Employee employee;
	public Employee getEmployee() {
		return this.employee;
	}
	public EmployeeSaved setEmployee(Employee employee) {
		this.employee = employee;
		return this;
	}
	
	public EmployeeSaved() {
		this.employee = new Employee();
	}
}
