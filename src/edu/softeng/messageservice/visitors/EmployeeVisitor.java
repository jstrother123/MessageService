package edu.softeng.messageservice.visitors;

import edu.softeng.messageservice.messages.dto.Employee;
import edu.softeng.messageservice.messages.employee.EmployeeLoggedIn;
import edu.softeng.messageservice.messages.employee.EmployeeLoggedOut;
import edu.softeng.messageservice.messages.employee.EmployeeSaved;

public class EmployeeVisitor extends Visitor {
	public void Visit(EmployeeSaved employeeSaved) {
		Employee employee = employeeSaved.getEmployee();

		System.out.printf("Saving employee with name %s", employee.getName());
		System.out.println();
	}

	public void Visit(EmployeeLoggedIn employeeLoggedIn) {
		System.out.printf("Logging in employee with ID %s", employeeLoggedIn.getId().toString());
		System.out.println();
	}

	public void Visit(EmployeeLoggedOut employeeLoggedOut) {
		System.out.printf("Logging out employee with ID %s", employeeLoggedOut.getId().toString());
		System.out.println();
	}
	
	@Override
	public EmployeeVisitor createOne() {
		return new EmployeeVisitor();
	}
	
	static {
		VisitorFactory.register(VisitorType.EMPLOYEE, new EmployeeVisitor());
	}
}
