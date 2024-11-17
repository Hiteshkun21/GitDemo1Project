package com.scs;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataUpdation {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Object o = s.get(Student.class,Integer.parseInt("1002"));
		Student st = (Student)o;
        st.setSname("stu2new");
        Transaction tx = s.beginTransaction();
        s.save(st);
        tx.commit();
		s.close();
		

	}

}
