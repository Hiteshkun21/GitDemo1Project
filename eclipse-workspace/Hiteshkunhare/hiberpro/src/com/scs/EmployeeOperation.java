package com.scs;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeOperation {
	Configuration cfg;
	Transaction tx;
	SessionFactory sf;
	Session s;
	void setConfiguration()
	{
		 cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 sf = cfg.buildSessionFactory();
		 s= sf.openSession();
	}
	void insertEmployee(int empid,String empname)
	{
		
		Employee obj = new Employee();
		obj.setEmpid(empid);
		obj.setEmpname(empname);
		 tx= s.beginTransaction();
		s.save(obj);
		tx.commit();
		
	}
	void selectEmployee()
	{
		
		Query q = s.createQuery("from Employee e");
		List lst = q.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
			Employee o = (Employee)it.next();
			System.out.println(o.getEmpid() + " "+o.getEmpname());
		}
		
		
	}
	
	void closeSession()
	{
		s.close();
	}
	public static void main(String[] args) {
		EmployeeOperation obj = new EmployeeOperation();
		 obj.setConfiguration();
		 obj.insertEmployee(1006,"Ravi Kumar");
		 obj.selectEmployee();
		 obj.closeSession();

	}

}
