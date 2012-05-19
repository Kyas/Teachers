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

import Teachers_V1.Professor;
import Teachers_V1.Student;

public class MainInteract {

	public static String menu() {
		StringBuilder sb = new StringBuilder();

		sb.append("========== MENU ==========\n");
		sb.append("0- Create a student\n");
		sb.append("1- Create a professor\n");
		sb.append("2- Put a student in a Promotion\n");
		sb.append("3- Put marks to a student\n");
		sb.append("4- Display all the students in a Promotion\n");
		sb.append("5- Display a student (name, promotion, marks, graders)\n");
		sb.append("6- Display a student with his name and average\n");
		sb.append("7- Sort students in Ascending Order\n");
		sb.append("8- Sort students in Descending Order\n");
		sb.append("9- Quit the Program");

		return sb.toString();
	}

	public static void createStudent() {
		System.out.println("=== Creation of a student ===");
		Scanner scName = new Scanner(System.in);
		Scanner scId = new Scanner(System.in);
		System.out.print("Give a name: ");
		String name = scName.nextLine();
		System.out.print("Give a first name: ");
		String forename = scName.nextLine();
		System.out.print("Give an id: ");
		int id = scId.nextInt();
		Student student = new Student(name, forename, id);
		System.out.println("Student " + student.displayNames() + " created.");
		System.out.println();
	}

	public static void createProfessor() {
		System.out.println("=== Creation of a professor ===");
		Scanner scName = new Scanner(System.in);
		System.out.print("Give a name: ");
		String name = scName.nextLine();
		System.out.print("Give a first name: ");
		String forename = scName.nextLine();
		Professor prof = new Professor(name, forename);
		System.out.println("Professor " + prof + " created.");
		System.out.println();
	}

	public static void main(String[] args) {

		while (true) { // When we don't want to quit the program now.
			System.out.println(menu());
			int res = -1;

			while (res < 0 || res > 9) {
				Scanner sc = new Scanner(System.in);
				res = sc.nextInt();
			}

			switch (res) {
			case 0:
				createStudent();
				break;
			case 1:
				createProfessor();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				System.out.println("End of the Program.");
				System.exit(0);
				break;
			default:
				break;
			}

		}
	}
}
