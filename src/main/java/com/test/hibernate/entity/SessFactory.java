package com.test.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.test.hibernate.entity.Client;

public class SessFactory {

	private static SessionFactory factory = null;
	
	private SessFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static Session getInstance(){
		if (factory==null){
			factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Client.class)
					.buildSessionFactory();
			
		
		}
		
		return factory.getCurrentSession();
		
	}
	
	
	
	
	
}
