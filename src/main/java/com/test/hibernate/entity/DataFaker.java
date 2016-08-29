package com.test.hibernate.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.javafaker.Faker;
import com.linkazer.mylib.date.ConvertDate;

public class DataFaker {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config_spring.xml");
		Faker faker = (Faker) context.getBean("faker");
		
		for 
		
		faker.date().between(ConvertDate.stringToDate("01/01/16"), ConvertDate.stringToDate("01/08/16"));
	}
}
