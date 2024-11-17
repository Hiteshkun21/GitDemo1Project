package com.scs;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataSelectionCode {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query o = s.createQuery("from Student s");
		List lst = o.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
			Student st = (Student)it.next();
			System.out.println(st.getRno() + " "+st.getSname());
		}

	}

}