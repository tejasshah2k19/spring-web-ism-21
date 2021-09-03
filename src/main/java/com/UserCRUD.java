package com;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserCRUD {

	public static void main(String[] args) {
//		
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sf = cfg.buildSessionFactory();
//		Session session = sf.openSession();
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		System.out.println(sf);
	
		
		
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		System.out.println(cfg);
	}
}
