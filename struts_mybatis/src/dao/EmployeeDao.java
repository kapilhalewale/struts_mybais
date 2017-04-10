package dao;

import java.io.Serializable;
import java.util.List;

import model.Employee;

public interface EmployeeDao extends Serializable
{
	public void saveUpdateEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
	public void dropEmployee(int id);
}
