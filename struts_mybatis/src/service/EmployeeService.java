package service;

import java.io.Serializable;
import java.util.List;

import model.Employee;

public interface EmployeeService extends Serializable
{
	public void saveUpdateEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
	public void dropEmployee(int id);
}
