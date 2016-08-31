package com.test.hibernate.entity;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.javafaker.Faker;
import com.linkazer.mylib.date.ConvertDate;

public class DataFaker {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config_spring.xml");
		Faker faker = (Faker) context.getBean("faker");
		Session session = ((SessFactory) context.getBean("sessFactory")).getInstance();
		session.beginTransaction();
		for (int i =0; i<1000; i++){
			Commande com = (Commande) context.getBean("commande");
			Client cli = (Client) context.getBean("client");
			Set<Commande> arrCommande= new HashSet<Commande>();
			
			
			//Faker data generate for client object
			cli.setDateDeNaissance(faker.date()
					.between(ConvertDate.stringToDate("01/06/1986"), 
							ConvertDate.stringToDate("01/01/1999")));
			cli.setNom(faker.name().lastName());
			cli.setPrenom(faker.name().firstName());
			
			
			//faker data generate for commande object
			com.setDateDeLaCommande(faker.date()
					.between(ConvertDate.stringToDate("01/01/2016"),
							ConvertDate.stringToDate("01/08/2016")));
			com.setNumeroDeCommande(faker.number().numberBetween(0L, 99999999999L));
			com.setClient(cli);
			arrCommande.add(com);
			cli.setCommmandes(arrCommande);
			
			
			//persistence
			session.persist(cli);
			
			
		}
		session.flush();
		session.getTransaction().commit();
		
		context.close();
		session.close();
		
		
	}
}
