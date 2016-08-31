package com.test.hibernate.entity;


import java.util.ArrayList;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.linkazer.mylib.date.ConvertDate;

public class CommandeDAO {
	
	private Session session;
	
	public CommandeDAO(Session session) {
		this.session = session;
		this.session.beginTransaction();
	}
	
	public Commande getCommandId(Long id){
		Query<?> query = session.createQuery("from Commande where id=:id");
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
		Query<?> query = session.createQuery("from Client where id = :id");
		query.setParameter("id", id);
		Client result  = (Client) query.getSingleResult();
		return result;
	}
	
	public Set<Commande> getAllCommandeFromClientId(Long id){
		Client cli = getClientById(id);
		
		return cli.getCommmandes();
	}
	
	public ArrayList<Commande> getAllCommandeFromThisDate(java.util.Date date){
		
		StringBuilder queryString = new StringBuilder("from Commande ");
		queryString.append("where dateDeLaCommande >= '" + ConvertDate.dateToStringSqlFormat(date) + "'");
		queryString.append(" and dateDeLaCommande < '" + ConvertDate.stringDateIncrement(ConvertDate.dateToString(date)) + "'");
		Query<?> query = session.createQuery(queryString.toString());
		ArrayList<Commande> com = (ArrayList<Commande>) query.getResultList();
		
		return com;
	}
	
	public Commande getMethodeCommandeId(Long id){
		return (Commande) session.get(Commande.class, id);
	}
	
	public Client getMethodeClientID(Long id){
		return (Client) session.get(Client.class, id);
	}
	
	public void flush(){
		session.flush();
	}
	
	public void commit(){
		session.getTransaction().commit();
	}
	
	public void closeSession(){
		this.session.close();
	}
}
