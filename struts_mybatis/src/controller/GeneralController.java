package controller;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class GeneralController extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = -1867909219805447281L;
	private String projectPath = "http://localhost/struts_mybatis";
	
	@Override
	public void setSession(Map<String, Object> arg0)
	{
		
	}

	public String getProjectPath() {
		return projectPath;
	}
}
