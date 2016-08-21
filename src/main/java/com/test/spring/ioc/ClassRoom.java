package com.test.spring.ioc;

public class ClassRoom {
	
	private TeacherInterface teacherOfThisClassRoom;
	
	public ClassRoom(TeacherInterface teacherOfThisClass) {
		
		this.teacherOfThisClassRoom = teacherOfThisClass;
		
	}
	
	public String explain(){
		
		return teacherOfThisClassRoom.explainTheCours();
	}
}
