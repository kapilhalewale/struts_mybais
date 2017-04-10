package controller;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

@Namespace("/employee")
@Action("/login")
@ResultPath(value="/")
@Result(name="success",location="login.jsp")
public class LoginAction extends GeneralController
{
	private static final long serialVersionUID = 3818462988448910574L;
	
	public String execute()
	{
			System.out.println("Called");
		   return SUCCESS;
	}
}
