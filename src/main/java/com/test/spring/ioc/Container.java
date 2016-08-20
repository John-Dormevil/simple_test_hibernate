package com.test.spring.ioc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** 
 * @author j-jse
 * Ce class est notre conteneur et sera charger de  dans un premier temps de nous fournir 
 * de referencer tout les type de class c'est aussi un singleton*/
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
	public void configContainer(String k, Object v){
		container.put(k, v);
	}
}
