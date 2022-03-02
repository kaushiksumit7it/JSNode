package com.jbdcapp.service;
import java.util.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jbdcapp.bean.Employee;

public class EmpServiceimpl implements EmpService {
	private DataSource dataSource;
	private JdbcTemplate jt;
	private NamedParameterJdbcTemplate npjt;
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jt = new JdbcTemplate(dataSource);
		npjt = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public String AddNewEmployee(Employee emp) {
		// TODO Auto-generated method stub
		String inscmd = "Insert into Employee values(?,?,?,?,?)";
		int res = jt.update(inscmd, new Object[] {emp.getEmpno(), emp.getEmpname(), emp.getJob(), emp.getSal(), emp.getLoc()});
		String chk = "";
		if(res>=1)
			chk = "Employee Added....";
		else
			chk = "Employee Not Added...";
		return chk;
	}
	
	public String AddNewEmployeeUsingNamedParameter(Employee emp) {
		// TODO Auto-generated method stub
		String inscmd = "Insert into Employee values(:eno,:ename,:jb,:sl,:loc)";
		Map empMap = new HashMap();
		empMap.put("eno", emp.getEmpno());
		empMap.put("ename", emp.getEmpname());
		empMap.put("jb", emp.getJob());
		empMap.put("sl", emp.getSal());
		empMap.put("loc", emp.getLoc());
		
		int res = npjt.update(inscmd, empMap);
		String chk = "";
		if(res>=1)
			chk = "Employee Added....";
		else
			chk = "Employee Not Added...";
		return chk;
	}


	
	public List<Employee> GetAll() {
		// TODO Auto-generated method stub		
 		List<Employee> empList = new ArrayList<Employee>();
		List<Map<String,Object>> eList = jt.queryForList("Select * from Employee");
		for(Map<String,Object> eRow : eList){
				Employee e = new Employee();
				e.setEmpno(Integer.parseInt(String.valueOf(eRow.get("empno"))));
				e.setEmpname(String.valueOf(eRow.get("empname")));
				e.setJob(String.valueOf(eRow.get("job")));
				e.setSal(Integer.parseInt(String.valueOf(eRow.get("salary"))));;
				e.setLoc(String.valueOf(eRow.get("location")));
				empList.add(e);
			}
		return empList;		
	}

	public Employee SearchEmp(int eno) {
		// TODO Auto-generated method stub
		Employee emp = null;
		try
		{
			String selcmd = "Select * from Employee where empno=?";
			emp = jt.queryForObject(selcmd, new Object[] {eno}, new EmployeeMapper());		
			return emp;
		}
		catch(Exception ex)
		{
			return emp;
		}
		
	}

	public String UpdateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		String cmdupt = "Update Employee set empname=? where empno=?";
		int res = jt.update(cmdupt, new Object[] {emp.getEmpname(), emp.getEmpno()});
		String chk = "";
		if(res>=1)
			chk = "Employee Updated...";
		else
			chk = "Employee Not Updated...";
		return chk;
	}

	public String DeleteEmployee(int eno) {
		// TODO Auto-generated method stub
		String delcmd = "Delete from Employee where empno=?";
		int res = jt.update(delcmd, new Object[] {eno});
		String chk = "";
		if(res>=1)
			chk = "Employee Deleted...";
		else
			chk = "Employee Not Deleted...";
		return chk;
	}

}
