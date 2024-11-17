package com.scs;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataInsertionCode {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Student obj = new Student();
		obj.setRno(1009);
		obj.setSname("stud8");
		Transaction tx = s.beginTransaction();
		s.save(obj);
		tx.commit();
		s.close();
		

	}

}