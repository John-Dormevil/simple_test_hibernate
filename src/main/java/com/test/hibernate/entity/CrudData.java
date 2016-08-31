package com.test.hibernate.entity;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import junit.framework.TestCase;



public class CrudData {
	
	private CommandeDAO cm = new CommandeDAO(SessFactory.getInstance());
	private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private Session session = factory.getCurrentSession();
	
	
	@Test
	public final void getCommandeById(){
		session.beginTransaction();
		Commande c = cm.getCommandId(1L);
		
		Query<?> query = session.createQuery("from Commande where id=:id");
		query.setParameter("id", 1L);
		
		Commande com = (Commande) query.getSingleResult();
		
		long numerosCommdande = com.getNumeroDeCommande();
		long numerosCommande =  c.getNumeroDeCommande();;
		System.out.println(numerosCommdande);
		assertEquals("Teste sur l'obtention d'une commande par la recherche Id", 
				numerosCommdande, numerosCommande);
		session.close();
	}
	
	/*
	@Test
	public final void readClient(){
		
	}
	
	@Test
	public final void updateClient(){
		
	}*/
}
