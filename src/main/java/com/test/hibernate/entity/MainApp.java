package com.test.hibernate.entity;

import com.linkazer.mylib.date.ConvertDate;

public class MainApp {
	
	public static void main(String[] args) {
		/*Session session = SessFactory.getInstance();
		
		Set<Commande> allCommande = new HashSet<Commande>();
		Client tempClient1 = new Client("Jushin", "shinWagton", new Date());
		
		session.beginTransaction();
		session.persist(tempClient1);
		session.flush();
		session.getTransaction().commit();
		session.close();*/
		
		
		CommandeDAO cm = new CommandeDAO(SessFactory.getInstance());
		
		//Commande c = cm.getCommandId(5L);
		
		//System.out.println(c);
		
		//Client cli = cm.getClientFromCommandId(9L);
		//System.out.println(cli.getNom());
		
		//Client  cli2 = cm.getClientById(16L);
		
		//System.out.println(cli2.getNom());
		
		//System.out.println(cli2.getCommmandes());
		
		//System.out.println(cm.getAllCommandeFromThisDate(ConvertDate.stringToDate("18/05/2016")));
		Client cli = cm.getMethodeClientID(19L);
		System.out.println(cli);
		cli.setNom("Bartholome");
		cm.flush();
		Client cli2 = cm.getMethodeClientID(18L);
		System.out.println(cli);
		cm.commit();
				
		//System.out.println(cm.getMethodeCommandeId(2L));
		cm.closeSession();
		System.exit(0);
		
		
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
