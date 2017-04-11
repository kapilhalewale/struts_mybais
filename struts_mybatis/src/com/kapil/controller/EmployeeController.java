package com.kapil.controller;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/employee")
public class EmployeeController extends GeneralController
{
	private static final long serialVersionUID = -2558610312892424107L;

	@Action(value="/employees",results={ @Result(name="success",location="/WEB-INF/views/employees.jsp")})
	public String employee()
	{
		System.out.println("Employee List Called");
		return SUCCESS;
	}
}
