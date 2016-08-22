package com.test.spring.ioc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp {

	public static void main(String[] args) {
		
		//Teacher teacher1 = new Teacher();
		//
		//System.out.println(teacher1.teach());
		/*
		String text = "Avec moi tu ne craint\\ rien a.Naple ville De la terreur";
		String text2 = "com.ioc.ClassRoomFrench";
		Pattern p = Pattern.compile(".*\\\\.*");
		Matcher m = p.matcher(text);
		boolean b = m.matches();
		//System.out.println(b);
		String [] tabText= text2.split("(?=[A-Z])");
		for (String s : tabText){
			System.out.println(s);
		}
		String theObject = "";
		for (int i = 1; i<tabText.length; i++){
			theObject  += tabText[i];
		}
		System.out.println(theObject);
		//System.out.println(Pattern.matches(p.pattern(), text));*/		
		//ClassRoom cr = new ClassRoom(new FrenchTeacher());
		//System.out.println(cr.explain());
		Object classRoom = Container.getInstance().getService("classRoom");
		System.out.println(((ClassRoom) classRoom).explain());
	}

}
