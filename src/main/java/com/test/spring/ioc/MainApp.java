package com.test.spring.ioc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp {

	public static void main(String[] args) {
		
		//Teacher teacher1 = new Teacher();
		//
		//System.out.println(teacher1.teach());
		
		String text = "Avec moi tu ne craint\\ rien a.Naple ville de la terreur";
		Pattern p = Pattern.compile(".*\\\\.*");
		Matcher m = p.matcher(text);
		boolean b = m.matches();
		System.out.println(b);
		String [] tabText= text.split("\\\\");
		for (String s : tabText){
			System.out.println(s);
		}
		System.out.println(Pattern.matches(p.pattern(), text));
	}

}
