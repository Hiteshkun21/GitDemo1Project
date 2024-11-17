package com.scs.hibernate;


	

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class EmployeeMain {
	int empid;
	String empname;
	String job;
	int salary;
	Configuration cfg;
	SessionFactory sf;
	Session s;
    static  Scanner sc = new Scanner(System.in);
    void accept()
   {
	 
		System.out.println("Enter Empid");
		empid=sc.nextInt();
		System.out.println("Enter empname");
		empname=sc.next();
		System.out.println("Enter job");
		job=sc.next();
		System.out.println("Enter salary");
		salary=sc.nextInt();
   }
   void configure()
   {
	    cfg = new Configuration();
		cfg.configure("hibernate1.cfg.xml");
		sf = cfg.buildSessionFactory();
		s = sf.openSession();
   }
   void insertData()
   {
	    Transaction tx = s.beginTransaction();
		Employee obj = new Employee();
		obj.setEmpid(empid);
		obj.setEmpname(empname);
		obj.setJob(job);
		obj.setSalary(salary);
		s.save(obj);
		tx.commit();
		
   }
   void selectData()
   {
	     Query q = s.createQuery("from Employee obj"); //select * from Student
		 List lst = q.list();
		 Iterator<Employee> st = lst.iterator();
		 while(st.hasNext())
		 {
			 Employee o = (Employee)st.next();
			 System.out.println(o.getEmpid() + " "+o.getEmpname() + " "+o.getJob()+" "+o.getSalary()+ " \n");
		 }
		
   }
   void closeConn()
   {
	   s.close();
   }
    public static void main(String[] args) 
    
  {
    	while(true)
		{
		System.out.println("Press 1 for Data Insertion \n Press 2 for Data Selection \n Press other for exit");
		char ch = sc.next().charAt(0);
		EmployeeMain obj = new EmployeeMain();
		obj.configure();
		switch(ch)
		{
		case '1':
		obj.accept();
		obj.insertData();
		break;
		case '2':
		obj.selectData();
		break;
		default:
			System.exit(0);
		}
		obj.closeConn();
		}
  	}
	
	}
