package com.jdbcapp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jbdcapp.service.EmpService;
import com.jbdcapp.bean.*;
import java.util.*;
public class EmpTrans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbccon.xml");
		EmpService em = (EmpService)ctx.getBean("EmpServObj");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Add New Emp\n2. Show All Emps\n3. Search Emp\n4. Update Emp\n5. Delete Emp");
		System.out.println("Pick Your Choice");
		int ch = sc.nextInt();
		
		switch(ch)
		{
		case 1:
			Employee emp = new Employee();
			System.out.println("Employee Number ");
			emp.setEmpno(sc.nextInt());
			System.out.println("Employee Name ");
			emp.setEmpname(sc.next());;
			System.out.println("Employee Job ");
			emp.setJob(sc.next());;
			System.out.println("Employee Salary ");
			emp.setSal(sc.nextInt());;
			System.out.println("Employee Location ");
			emp.setLoc(sc.next());
			
			//String res = em.AddNewEmployee(emp);
			String res = em.AddNewEmployeeUsingNamedParameter(emp);
			System.out.println(res);
			break;
		case 2:
			List<Employee> einfo = em.GetAll();
			for(Employee e : einfo)
			{
				System.out.println(e.getEmpno() + "\t" + e.getEmpname() + "\t" + e.getSal() + "\t" + e.getJob() + "\t" + e.getLoc());;
			}
 			break;
		case 3:
			System.out.println("Employee Number ");
			int eno = sc.nextInt();
			Employee e = em.SearchEmp(eno);
			if(e!=null)
			{
				System.out.println(e.getEmpno() + "\t" + e.getEmpname() + "\t" + e.getSal() + "\t" + e.getJob() + "\t" + e.getLoc());;
			}
			else
				System.out.println("Employee Not Found");
			break;
		case 4:
			System.out.println("Employee Number ");
			int en = sc.nextInt();
			Employee e1 = em.SearchEmp(en);
			if(e1!=null)
			{
				System.out.println("New Name for Employee ");
				String ena = sc.next();
				e1.setEmpname(ena);
				System.out.println(em.UpdateEmployee(e1));
			}
			else
				System.out.println("Employee Not Found");
			break;
		case 5:
			
			System.out.println("Employee Number ");
			int en1 = sc.nextInt();
			Employee e2 = em.SearchEmp(en1);
			if(e2!=null)
			{
				System.out.println("Are You Sure[Y/N] ");
				String chs = sc.next();
				if(chs.equalsIgnoreCase("y"))
				{
					System.out.println(em.DeleteEmployee(en1));
				}
				else
					System.out.println("Employee Not Deleted");
			}
			else
				System.out.println("Employee Not Found");
			break;
		}
	}

}
