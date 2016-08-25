package com.test.hibernate.core;

import com.test.spring.ioc.TeacherInterface;

public class FrenchTeacher implements TeacherInterface  {

	public String explainTheCours() {

		return "Le verbe s'accorde toujours avec son sujet. ";
	}

}
