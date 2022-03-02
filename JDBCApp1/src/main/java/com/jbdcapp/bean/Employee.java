package com.jbdcapp.bean;
/*
 * *Create table Employee(
	empno int primary key, 
	empname varchar(20) not null, 
	job varchar(20), 
	salary int, 
	location varchar(20));
 */

public class Employee {
	private int empno;
	private String empname;
	private String job;
	private int sal;
	private String loc;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
