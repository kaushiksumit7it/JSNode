package com.jbdcapp.service;
import com.jbdcapp.bean.*;
import java.util.*;
public interface EmpService 
{
	public String AddNewEmployee(Employee emp);
	public String AddNewEmployeeUsingNamedParameter(Employee emp);
	public List<Employee> GetAll();
	public Employee SearchEmp(int eno);
	public String UpdateEmployee(Employee emp);
	public String DeleteEmployee(int eno);
}
