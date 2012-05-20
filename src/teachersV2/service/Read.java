package teachersV2.service;

import java.util.ArrayList;
import java.util.Scanner;

import teachersV2.Professor;
import teachersV2.Promotion;
import teachersV2.Student;

/**
 * Interact.java
 * 
 * Copyright 2012
 * 
 * This file is part of the Java Project : Teachers.
 * 
 * Teachers is free software: you can redistribute it and/or modify it under the
 * terms of the zlib license. See the COPYING file.
 * 
 * @author Jeremy LOR <jlor@etudiant.univ-mlv.fr>
 * @author Thomas LEROUX <tleroux@etudiant.univ-mlv.fr>
 */
public class Read {

	/*
	 * List of Students.
	 */
	public static ArrayList<Student> sList = new ArrayList<Student>();

	/*
	 * List of Professors.
	 */
	public static ArrayList<Professor> profList = new ArrayList<Professor>();

	/*
	 * List of Promotions.
	 */
	public static ArrayList<Promotion> pList = new ArrayList<Promotion>();
	
	static final int NB_EVALUATIONS = 10;
	
	public final static String marks[] = new String[NB_EVALUATIONS];

	/**
	 * Display the menu.
	 * 
	 * @return the menu into a String.
	 */
	public static String menu() {
		StringBuilder sb = new StringBuilder();

		sb.append("========== MENU ==========\n");
		sb.append("1- Display all the students\n");
		sb.append("2- Display all the professors\n");
		sb.append("3- Display a Promotion\n");
		sb.append("4- Display a student (name, promotion, marks, graders)\n");
		sb.append("5- Display a student with his name and average\n");
		sb.append("6- Sort students in a Promotion in Ascending Order\n");
		sb.append("7- Sort students in a Promotion in Descending Order\n");
		sb.append("8- Quit the Program");

		return sb.toString();
	}

	public static void initMarks() {
		int i;
		for(i = 0; i < marks.length; i++) {
			marks[i] = null;
		}
	}
	
	/**
	 * Display the actual Student List in the Program.
	 */
	public static void displayStudentList() {
		int i;
		for (i = 0; i < sList.size(); i++) {
			if (i < sList.size() - 1) {
				System.out.print("(" + sList.get(i).displayNames() + "), ");
			} else {
				System.out.print("(" + sList.get(i).displayNames() + ")");
			}
		}
		System.out.println();
	}

	/**
	 * This display of students is for choices.
	 * 
	 * @param mode
	 *            if <code>0</code>, we display all the informations of the
	 *            student, <code>1</code> only his name and his average.
	 */
	public static void displayStudent(int mode) {
		if (sList.isEmpty()) {
			System.out.println("There is no Students !");
		} else {
			System.out.println("Which student do you want to choose ?");
			int i;
			for (i = 0; i < sList.size(); i++) {
				System.out.print(i + ":(" + sList.get(i).displayNames() + ") ");
			}
			System.out.println();
			Scanner scIndexS = new Scanner(System.in);

			Student s = null;
			while (s == null) {
				int iS = scIndexS.nextInt();
				s = chooseStudentList(iS);
			}
			if (mode == 0) {
				System.out.println(s);
			} else {
				System.out.println(s.displayAverage());
			}
		}
	}

	/**
	 * Choose the student in the actual List in the Program.
	 * 
	 * @param index
	 *            The index of the Student List.
	 * @return The student.
	 */
	public static Student chooseStudentList(int index) {
		Student s = null;
		try {
			s = sList.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choose a existent student in the list !");
			return null;
		}
		return s;
	}

	/**
	 * Display the actual Professors List in the Program.
	 */
	public static void displayProfessorList() {
		int i;
		for (i = 0; i < profList.size(); i++) {
			System.out.print("(" + profList.get(i) + ") ");
		}
		System.out.println();
	}

	/**
	 * Display the Promotion List.
	 */
	public static void displayPromotionList() {
		int i;
		for (i = 0; i < pList.size(); i++) {
			System.out.print(i + ":" + pList.get(i).getName() + " ");
		}
		System.out.println();
	}

	/**
	 * This display of promotions is for choices.
	 */
	public static void displayPromotion() {
		if (pList.isEmpty()) {
			System.out.println("There is no Promotion !");
		} else {
			System.out.println("Which promotion do you want to choose ?");
			displayPromotionList();
			Scanner scIndexP = new Scanner(System.in);

			Promotion p = null;
			while (p == null) {
				int iP = scIndexP.nextInt();
				p = choosePromotionList(iP);
			}
			System.out.println(p);
		}
	}

	/**
	 * Choose the promotion in the actual List in the Program.
	 * 
	 * @param index
	 *            The index of the Promotion List.
	 * @return The promotion.
	 */
	public static Promotion choosePromotionList(int index) {
		Promotion p = null;
		try {
			p = pList.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choose a existent Promotion in the list !");
			return null;
		}
		return p;
	}

	public static int addStudent(Student s) {
		if (s == null)
			return 0;
		sList.add(s);
		return 1;
	}

	public static int addProfessors(Professor prof) {
		boolean exist = false;
		if (prof == null)
			return 0;
		for(int i = 0; i < profList.size(); i++) {
			if(profList.get(i).equals(prof)) {
				exist = true;
			}
		}
		if(exist == false) {
			profList.add(prof);
			return 1;
		}
		return 0;
	}

	/**
	 * 
	 * @param p
	 * @return
	 */
	public static Promotion addPromotion(Promotion p) {
		if (p == null)
			return null;
		
		// We check if the promotion doesn't still exist in the Professor List.
		boolean exist = false;
		int pos = 0;
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).equals(p)) {
				exist = true;
				pos = i;
			}
		}

		if (!exist) {
			pList.add(p);
			return p;
		} 
		return pList.get(pos);
	}
	
	public static int addMarks(int index, String value) {
		marks[index] = value;
		return 1;
	}
	
	public static int getIndexPromotion(Promotion p) {
		int i, pos = 0;
		for(i = 0; i < pList.size(); i++) {
			if(pList.get(i).equals(p)) {
				pos = i;
			}
		}
		return pos;
	}
}
