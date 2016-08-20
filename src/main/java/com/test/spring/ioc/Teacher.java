package com.test.spring.ioc;

public class Teacher {
	
	/*
	 * il y a une très forte dépendance de la class Teacher a la class FrenchTeacher
	 * comment résoudre ce problème de couplage fort.
	 * Notre application d'enseignement n'est pas configurable
	 * en effet tout est écrit et codé en dur.
	 * 
	 * Première tentative de resolution du problème créer un container qui serra charger d'instancier la création de 
	 * dépendance et classe ainsi qu'un système permettant de charger les dépendance necessaire a chaque classe.
	 * de cette manière nous auront une inversion de controle.
	 * cela sous entends qu'il faudra configurer l'application pour lui indiquer les interdépendance entre 
	 * chaque classe. C'est un patron de conception très spécifique.
	 * */
	
	private TeacherInterface frenchTeach;
	
	public Teacher() {
		
		frenchTeach = new FrenchTeacher();
		
	}
	
	public String teach(){
		
		return frenchTeach.explainTheCours();
	}
	

}
