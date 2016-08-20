package com.test.spring.ioc;

public class MathTeacher implements TeacherInterface {

	public String explainTheCours() {
		
		return "Dans un triangle rectangle, le carré de l'hypoténuse \n"
				+ "est égal à la somme des carrés des côtés de l'angle droit.";
	}

}
