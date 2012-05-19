/**
 * MainInteract.java
 * 
 * Copyright 2012 
 * 
 * This file is part of the Java Project : Teachers.
 * 
 * Teachers is free software: you can redistribute it and/or modify
 * it under the terms of the zlib license. See the COPYING file.
 * 
 * @author Jérémy LOR <jlor@etudiant.univ-mlv.fr>
 * @author Thomas LEROUX <tleroux@etudiant.univ-mlv.fr>
 */

package Teachers_V1.main;

import java.util.Scanner;

public class MainInteract {
	
	public String menu() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("========== MENU ==========\n");
		sb.append("0- Create a student\n");
		sb.append("1- Crate a professor\n");
		sb.append("2- Put a student in a Promotion\n");
		sb.append("3- Put marks to a student\n");
		sb.append("4- Display all the students in a Promotion\n");
		sb.append("5- Display a student (name, promotion, marks, graders)\n");
		sb.append("6- Display a student with his name and average\n");
		sb.append("7- Sort students in Ascending Order\n");
		sb.append("8- Sort students in Descending Order\n");
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		
		int res = -1;
		Scanner sc = new Scanner(System.in);
		while(res == -1) {
			sc = new Scanner(System.in);
		}
		
		res = sc.nextInt();
		
//		switch(sc) {
//			
//		}
		
	}
}

