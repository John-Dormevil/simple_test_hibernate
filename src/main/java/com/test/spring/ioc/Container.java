package com.test.spring.ioc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** 
 * @author j-jse
 * Cette class est notre conteneur et sera charger dans un premier temps de nous fournir 
 * et donc de referencer tout les types de class c'est aussi un singleton*/
public class Container {
	
	private static Container instance = null;
	private Map<String, Object> container = new HashMap<String, Object>();
	private Map<String, ArrayList<String>> dependance = new HashMap<String, ArrayList<String>>();
	
	private Container() {}
	
	public static Container getInstance(){
		
		if (instance == null){
			instance = new Container();
			return instance;
		}else{
			return instance;
		}
		
	}
	/**
	 * 
	 * @param service est une chaine de caractère qui est la reference et l'id de la class a génerer
	 * 	et renvoyer.
	 * @return renvoie un objet qui devra être Downcaster dans le type enfant du service renvoyé*/
	
	public Object getService(String service){
		
		return container.get(service);
	}
	
	/**
	 * Cette methode ajoute dans une colection la pair clé valeur utile pour référencer un service
	 * @param k correspond a la clé qui identifie la class stocker dans le container hashmap
	 * @param v correspond a la class donc l'objet stoqué au sein de la collection hashmap*/
	public void configAddContainerServicies(String k, Object v){
		container.put(k, v);
	}
	
	/**
	 * Cette ethode nous permet de préciser la relation entre les service et donc leur dépendance vis-a-vis
	 * de chacun
	 * @param service correspond l'identifiant du service qui devra être connecter a sa dépendance
	 * 		-ex : le service "joueur" a besoin et donc dépendt du service "balle" pour fonctionner
	 * 			correctemment
	 * @param dependance correspond aux dépendance d'un service. Ces dépendance seront passer en 
	 * paramétre au constructeur du service lors de l'instanciation. c'est une arralist de string.
	 */
	public void configAddContainerDependance(String service, ArrayList<String> dependance){
		this.dependance.put(service, dependance);
	}
}
