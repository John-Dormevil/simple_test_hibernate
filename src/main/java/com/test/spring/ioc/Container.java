package com.test.spring.ioc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/** 
 * @author j-jse
 * Cette class est notre conteneur et sera charger dans un premier temps de nous fournir 
 * et donc de referencer tout les types de class c'est aussi un singleton*/
public class Container {
	
	private static Container instance = null;
	private Map<String, String> container = new HashMap<String, String>();
	private Map<String, ArrayList<String>> dependance = new HashMap<String, ArrayList<String>>();
	private Properties propertiesFile = new Properties();
	
	private Container() {
		loadConfigProperties();
	}
	
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
		
		return correlationServiceDependance(service);
		//return container.get(service);
	}
	
	/**
	 * Cette methode ajoute dans une colection la pair clé valeur utile pour référencer un service
	 * @param k correspond a la clé qui identifie la class stocker dans le container hashmap
	 * @param v correspond a la class donc l'objet stoqué au sein de la collection hashmap*/
	public void configAddContainerServicies(String k, String v){
		container.put(k, v);
	}
	
	/**
	 * Cette methode nous permet de préciser la relation entre les service et donc leur dépendance vis-a-vis
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
	
	
	/**
	 * Ce charge de lire le fichier properties
	 */
	private void loadConfigProperties(){
		FileInputStream fis;
		try {
			/*
			 * ici on ouvre un flux puis
			 * on charge tout les élements dans le properties file
			 * on close la conection le fux est interompue et fermé.
			 */
			fis = new FileInputStream("config_service.properties");
			propertiesFile.load(fis);
			fis.close();
			updateServices();
			updateDependance();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateServices(){
		for ( Map.Entry<Object, Object> m : propertiesFile.entrySet()){
			String key = (String) m.getKey();
			String value = (String) m.getValue();
			if(isService(key)){
				
				configAddContainerServicies(takeTheRightValue(key), value);
			}
			
		}
	}
	
	private void updateDependance(){
		ArrayList<String> arr = new ArrayList<String>();
		for (Map.Entry<Object, Object> m : propertiesFile.entrySet()){
			String key =(String) m.getKey();
			String value =(String) m.getValue();
			arr.add(value);
			if(isDependance(key)){
				configAddContainerDependance(takeTheRightValue(key), arr);
			}
		}
	}
	
	/*
	 * Analyse une clé et determine si elle fait partie de la section service
	 */
	private boolean isService(String s){
		String tablString[] = s.split("\\.");
		if (tablString[0].equals("service")){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * Analyse une clé et determine si elle fait partie de la section dependance
	 */
	private boolean isDependance(String s){
		String tablString[] = s.split("\\.");
		if (tablString[0].equals("dependance")){
			return true;
		}else{
			return false;
		}
	}
	
	private String takeTheRightValue(String s){
		String tableKey[] = s.split("\\.");
		return tableKey[1];
	}
	
	/*@SuppressWarnings("finally")
	private Object takeTheObject(String s){
		String theObject= "";
		String [] tableValue= s.split("(?=[A-Z])");
		Object o = null;
		for (int i = 1; i<tableValue.length; i++){
			theObject += tableValue[i];
		}
		try {
			
			o = Class.forName(theObject).newInstance();
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			return o;
		}
	}*/
	
	private Object correlationServiceDependance(String service){
		//Creation d'une instance de Constructor au cas ou l'on devra faire appelle a une dépendance
		Constructor constructeur;
		Class classe;
		
		/*
		 * Cherchons le service dans le container on obtient le namespace de la class que l'on devra instancié
		 * grace a Class.forname("namespace").newInstance();
		 */
		String thisService = container.get(service);
		
		/*
		 * Vérifions que le service demander n'a pas une dépendance nécessaire pour sa construction
		 */
		if(dependance.containsKey(service)){
			//Recuperons les dépendances necessaire au bon fonctionement de notre service dans un arraylist typé string
			ArrayList<String> arrValue = dependance.get(service);
			Class [] allDependance= new Class[arrValue.size()];
			for (int i = 0; i<arrValue.size(); i++){
				if (isService(arrValue.get(i))){
					String serv = takeTheRightValue(arrValue.get(i));
					String namespaceService = container.get(serv);
					try {
						allDependance[i] = Class.forName(namespaceService);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				
			}
			
			try {
				//Creation de l'image représentant notre service sous le type Class de java
				classe = Class.forName(thisService);
				
				constructeur = classe.getConstructor(allDependance);
				try {
					
					return constructeur.newInstance(new Object []{});
					
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				return Class.forName(thisService).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return service;
	}
}
