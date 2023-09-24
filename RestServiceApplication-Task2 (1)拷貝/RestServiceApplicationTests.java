package com.hpe.restservice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hpe.restservice.Employee;
import com.hpe.restservice.Employees;
import com.hpe.restservice.EmployeeManager;

import org.junit.jupiter.api.BeforEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@SpringBootTest
public class RestserviceApplicationTests {

	@Mock
	private EmployeeManager employeeManager;

	// Helper function to get the number of current employees
	int getEmployeeCount(EmployeeManager manager)
	{
		return manager.gerAllEmployees().getEmployeeList().size();
	}

	@Test
	// Ensure that employee list is populated on initialization
	void createEmployeeMananger() {
		EmployeeManager newEmployeeManager = new EmployeeManager();
		assert(getEmployeeCount(newEmployeeManager) != 0);
	}

	@Test
	// Ensure that adding an employee increases the employee count by 1
	void addEmployee(){
		EmployeeManager employeeManager = new EmployeeManager();
		int employeeCount = getEmployeeCount(employeeManager);
		Employee employee = new Employee("heden123", "Hsieh", "Eden", "edenh@gmail.com", "Software Developer" );
		employeeMannager.addEmployee(employee);
		assert(employeeCount + 1 == getEmployeeCount(employeeManager));
	}

	@ExtendWith(MockitoExtension.class)
	@BeforeEach void steUp()
	{
		this.employeeManager = new EmployeeMananger();
		Employee newEmployee = new Employee("heden123", "Hsieh", "Eden", "edenh@gmail.com", "Software Developer" );
		this.employeeManager.addEmployee(newEmployee);
	}

	@Test
	// Check whether added employee ID is found in ID field
	void employeeIdList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for(int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if(employee.getId() == "heden123")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee first name is found in first name fiel
	void employeeFirstNameinList(){
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if(emmployee.getFirstName() == "Hsieh")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee last name is found in last name field
	void employeeLastNameInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for( int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if(employee.getLastName() == "Eden")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
		// Check whether added employee email is found in email field
	void employeeEmailInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for( int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if(employee.getEmail() == "edenh@gmail.com")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
		// Check whether added employee title is found in title field
	void employeeTitleInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for( int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if(employee.getTitle() == "Software Developer")
			{
				return;
			}
		}
		assert(false);
	}
}