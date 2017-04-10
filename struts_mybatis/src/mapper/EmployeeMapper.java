package mapper;

import java.io.Serializable;
import java.util.List;

import model.Employee;
import model.Entity;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeMapper extends Serializable
{
	String SAVE_EMPLOYEE = "INSERT INTO employee (name, code, salary, date_of_joining, entity_id) VALUES" +
							"(#{name},#{code},#{salary},#{dateOfJoining}, #{entity.id})";
	
	String UPDATE_EMPLOYEE = "UPDATE employee SET name=#{name}, code=#{code}, salary=#{salary}," +
							 "date_of_joining =#{dateOfJoining} WHERE id=#{id}";
	
	String GET_EMPLOYEES = "SELECT e.id AS id, e.name AS name, e.code AS code, e.salary AS salary," +
						   "e.date_of_joining AS date_of_joining FROM employee e";
	
	String GET_EMPLOYEE_BY_ID = "SELECT e.id AS id, e.name AS name, e.code AS code, e.salary AS salary" +
								"e.date_of_joining AS date_of_joining FROM employee e WHERE e.id=#{id}";
	
	String DROP_EMPLOYEE = "DELETE FROM employee WHERE id=#{id}";
	
	String GET_ENTITY_BY_ID = "SELECT entity.id, entity.name FROM entity  WHERE entity.id=#{id}";
	
	@Results(value  = {
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "salary", column = "salary"),
        @Result(property = "code", column = "code"),
        @Result(property = "dateOfJoining", column = "date_of_joining"),
        @Result(property = "entity", column = "entity_id", one= @One(select="getEntity"))
      })
	
	@Select(GET_EMPLOYEES)
	public List<Employee> getEmployees();
	
	@Insert(SAVE_EMPLOYEE)
	@Options(useGeneratedKeys = true, keyProperty = "id", flushCache=true)
	public void saveEmployee(Employee employee);
	
	@Select(GET_EMPLOYEE_BY_ID)
	public Employee getEmployee(int id);
	
	@Update(UPDATE_EMPLOYEE)
	public void updateEmployee(Employee employee);
	
	@Delete(DROP_EMPLOYEE)
	public void dropEmployee(int id);
	
	@Select(GET_ENTITY_BY_ID)
	public Entity getEntity(int id);
}
