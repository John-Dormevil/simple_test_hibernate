package com.test.hibernate.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class MainApp {
	
	public static void main(String[] args) {
		/*Session session = SessFactory.getInstance();
		
		Set<Commande> allCommande = new HashSet<Commande>();
		Client tempClient1 = new Client("Jushin", "shinWagton", new Date());
		Commande chaussure = new Commande()
				.setDateDeLaCommande(new Date())
				.setNumeroDeCommande(666645254L);
		Commande sacMains = new Commande ()
				.setDateDeLaCommande(new Date())
				.setNumeroDeCommande(1445414526777L);
		
		allCommande.add(chaussure);
		allCommande.add(sacMains);
		chaussure.setClient(tempClient1);
		sacMains.setClient(tempClient1);
		tempClient1.setCommmandes(allCommande);
		session.beginTransaction();
		session.persist(tempClient1);
		session.flush();
		session.getTransaction().commit();
		session.close();*/
		
		
		CommandeDAO cm = new CommandeDAO(SessFactory.getInstance());
		
		Commande c = cm.getCommandId(5L);
		System.out.println(c);
		
		Client cli = cm.getClientFromCommandId(9L);
		System.out.println(cli.getNom());
		
		Client  cli2 = cm.getClientById(16L);
		System.out.println(cli2.getNom());
		
		System.out.println(cli2.getCommmandes());
		
		cm.closeSession();
		
		
		/*
		Maire antoinette = new Maire();
		antoinette.setNom("Jean-Marie Antoinette");
		
		Commune kourou = new Commune();
		kourou.setMaire(antoinette);
		kourou.setNom("Kourou");
		
		session.beginTransaction();
		session.save(kourou);
		session.save(antoinette);
		session.flush();
		session.getTransaction().commit();
		session.close();
		*/
		
	}
	
	
}
