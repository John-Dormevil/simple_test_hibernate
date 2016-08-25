package com.test.hibernate.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config_spring.xml");
		
		ClassRoom classRoom = (ClassRoom) context.getBean("classRoom");
		FrenchTeacher frenchTeacher = (FrenchTeacher) context.getBean("frenchTeacher");
		
		System.out.println(classRoom.explain());
		System.out.println(frenchTeacher.explainTheCours());
	}
}
