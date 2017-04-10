package service;

import java.util.List;
import org.apache.log4j.Logger;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private static final long serialVersionUID = 5551761604955149637L;
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Override
	public void saveUpdateEmployee(Employee employee)
	{
		if(employee != null)
		{
			employeeDao.saveUpdateEmployee(employee);
			logger.debug("employee added");
			logger.info("employee added");
		}
	}

	@Override
	public List<Employee> getEmployees()
	{
		logger.debug("getEmployees service invoked");
		return employeeDao.getEmployees();
	}

	@Override
	public Employee getEmployee(int id)
	{
		logger.debug("getEmployee service invoked");
		return employeeDao.getEmployee(id);
	}

	@Override
	public void dropEmployee(int id)
	{
		if(id > 0)
		{
			employeeDao.dropEmployee(id);
			logger.debug(id+ " employee deleted ");
		}
	}
}
