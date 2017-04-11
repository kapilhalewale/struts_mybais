package com.kapil.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.kapil.mapper.EmployeeMapper;
import com.kapil.model.Employee;
import com.kapil.util.GenericClass;


public class EmployeeDaoImpl extends GenericClass implements EmployeeDao
{
	private static final long serialVersionUID = 1230991283495211639L;

	@Override
	public void saveUpdateEmployee(Employee employee)
	{
		if(employee != null)
		{
			SqlSession session = getMyBatisSession();
			if(session != null)
			{
				EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
				if(employee.getId() <= 0)
				{
					employeeMapper.saveEmployee(employee);
				}
				else
				{
					employeeMapper.updateEmployee(employee);
				}
				session.commit();
				session.close();
				closeMyBatisSession(session);
			}
		}
		
	}

	@Override
	public List<Employee> getEmployees()
	{
		List<Employee> employees = null;
		SqlSession session = getMyBatisSession();
		if(session != null)
		{
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			employees = employeeMapper.getEmployees();
			session.close();
			closeMyBatisSession(session);
		}
		return employees;
	}

	@Override
	public Employee getEmployee(int id)
	{
		Employee employee = null;
		SqlSession session = getMyBatisSession();
		if(id > 0)
		{
			if(session != null)
			{
				EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
				employee = employeeMapper.getEmployee(id);
				session.close();
				closeMyBatisSession(session);
			}
		}
		return employee;
	}

	@Override
	public void dropEmployee(int id)
	{
		if(id > 0)
		{
			SqlSession session = getMyBatisSession();
			if(session != null)
			{
				EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
				employeeMapper.dropEmployee(id);
				session.close();
				closeMyBatisSession(session);
			}			
		}
	}
}
