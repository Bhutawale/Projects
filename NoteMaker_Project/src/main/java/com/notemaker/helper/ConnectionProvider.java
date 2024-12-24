package com.notemaker.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionProvider 
{
	public static Session session;
	
	public static Session getSession()
	{
		if(session==null)
		{
			Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		
			SessionFactory factory = cfg.buildSessionFactory();
		
			session = factory.openSession();
		}
		
			return session;
	}
	
}
