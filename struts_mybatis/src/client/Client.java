package client;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import model.Employee;
import model.Entity;
import service.EmployeeService;
import service.EmployeeServiceImpl;

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
