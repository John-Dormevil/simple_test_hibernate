package com.test.hibernate.core;

import com.test.spring.ioc.TeacherInterface;

public class ClassRoom {
	
	private TeacherInterface teacherOfThisClassRoom;
	
	
	
	public ClassRoom(TeacherInterface teacherOfThisClass) {
		
		this.teacherOfThisClassRoom = teacherOfThisClass;
		
	}
	
	public String explain(){
		
		return teacherOfThisClassRoom.explainTheCours()+" Au revoirs";
	}
	
	/*public void setTeacherOfThisClassRoom(TeacherInterface teacherOfThisClassRoom) {
		this.teacherOfThisClassRoom = teacherOfThisClassRoom;
	}*/
}
