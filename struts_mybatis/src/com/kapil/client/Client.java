package com.kapil.client;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.kapil.model.Employee;
import com.kapil.model.Entity;
import com.kapil.service.EmployeeService;
import com.kapil.service.EmployeeServiceImpl;


public class Client {

	public static void main(String[] args) 
	{
		EmployeeService employeeService  = new EmployeeServiceImpl();
		
		Entity entity = new Entity();
		entity.setId(1);
		
		Employee employee = new Employee();
		employee.setName("Anil P H");
		employee.setCode("EMP_APH");
		employee.setSalary(new BigDecimal(35000));
		employee.setDateOfJoining(new Date());
		employee.setEntity(entity);
		employeeService.saveUpdateEmployee(employee);
		
		List<Employee> employees = employeeService.getEmployees();
		
		for(Employee employeeObj : employees)
		{
			System.out.println("Name : "+employeeObj.getName()+ " | Salary :" +employeeObj.getSalary()+ "| Date Of Joining : "+employeeObj.getDateOfJoining()
					+" | Entity : "+employeeObj.getEntity().getName());
		}
	}

}
