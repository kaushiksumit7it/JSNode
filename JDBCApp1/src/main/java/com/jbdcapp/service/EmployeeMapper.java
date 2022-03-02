package com.jbdcapp.service;
import com.jbdcapp.bean.*;
import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class EmployeeMapper implements RowMapper<Employee> {
	
	public Employee mapRow(ResultSet rs, int rowCount) throws SQLException 
	{	
		Employee e = new Employee();
		e.setEmpno(rs.getInt("empno"));
		e.setEmpname(rs.getString("empname"));
		e.setJob(rs.getString("job"));
		e.setSal(rs.getInt("salary"));
		e.setLoc(rs.getString("location"));		
		return e;
	}

}
