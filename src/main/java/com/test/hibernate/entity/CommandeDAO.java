package com.test.hibernate.entity;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CommandeDAO {
	
	private Session session;
	
	public CommandeDAO(Session session) {
		this.session = session;
		this.session.beginTransaction();
	}
	
	public Commande getCommandId(Long id){
		Query query = session.createQuery("from Commande where id=:id");
		query.setParameter("id", id);
		Commande result = (Commande) query.getSingleResult();
		return result;
		
		
	}
	
	public Client getClientFromCommandId(Long id){
		Commande com = getCommandId(id);
		Client result = com.getClient();
		return result;
	}
	
	public Client getClientById(Long id){
		Query query = session.createQuery("from Client where id = :id");
		query.setParameter("id", id);
		Client result  = (Client) query.getSingleResult();
		return result;
	}
	
	public Set<Commande> getAllCommandeFromClientId(Long id){
		Client cli = getClientById(id);
		
		return cli.getCommmandes();
	}
	
	
	public void closeSession(){
		this.session.close();
	}
}
