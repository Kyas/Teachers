package teachersV2.core;

import java.util.Scanner;

import teachersV2.Professor;
import teachersV2.Promotion;
import teachersV2.Student;
import teachersV2.io.FileReader;
import teachersV2.io.FileReaderService;

/**
 * Read.java
 * 
 * Copyright 2012 - This file is part of the Java Project : Teachers.
 * 
 * Teachers is free software: you can redistribute it and/or modify it under the
 * terms of the zlib license. See the COPYING file.
 * 
 * @author Jeremy LOR <jlor@etudiant.univ-mlv.fr>
 * @author Thomas LEROUX <tleroux@etudiant.univ-mlv.fr>
 */
public class Core {

	static final int NB_EVALUATIONS = 10;

	public final static String marks[] = new String[NB_EVALUATIONS];

	/**
	 * Display the menu.
	 * 
	 * @return the menu into a String.
	 */
	public static String menu() {
		StringBuilder sb = new StringBuilder();

		sb.append("========== Menu ==========\n");
		sb.append("1- Display all the students\n");
		sb.append("2- Display all the professors\n");
		sb.append("3- Display a Promotion\n");
		sb.append("4- Display a student (name, promotion, marks, graders)\n");
		sb.append("5- Display a student with his name and average\n");
		sb.append("6- Sort students in a Promotion in Ascending Order\n");
		sb.append("7- Sort students in a Promotion in Descending Order\n");
		sb.append("8- Save the File\n");
		sb.append("9- Quit the Program");

		return sb.toString();
	}

	/**
	 * Initialize the Marks' Array.
	 */
	public static void initMarks() {
		for (int i = 0; i < marks.length; i++) {
			marks[i] = null;
		}
	}

	/**
	 * Display the actual Student List in the Program.
	 */
	public static void displayStudentList() {
		int i;
		for (i = 0; i < FileReaderService.sList.size(); i++) {
			if (i < FileReaderService.sList.size() - 1) {
				System.out
						.print("("
								+ FileReaderService.sList.get(i).displayNames()
								+ "), ");
			} else {
				System.out.print("("
						+ FileReaderService.sList.get(i).displayNames() + ")");
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
		if (FileReaderService.sList.isEmpty()) {
			System.out.println("There is no Students !");
		} else {
			System.out.println("Which student do you want to choose ?");
			int i;
			for (i = 0; i < FileReaderService.sList.size(); i++) {
				System.out.print(i + ":("
						+ FileReaderService.sList.get(i).displayNames() + ") ");
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
			s = FileReaderService.sList.get(index);
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
		for (i = 0; i < FileReader.profListFiles.size(); i++) {
			System.out.print("(" + FileReader.profListFiles.get(i) + ") ");
		}
		System.out.println();
	}

	/**
	 * Display the Promotion List.
	 */
	public static void displayPromotionList() {
		int i;
		for (i = 0; i < FileReaderService.pList.size(); i++) {
			System.out.print(i + ":" + FileReaderService.pList.get(i).getName()
					+ " ");
		}
		System.out.println();
	}

	/**
	 * This display of promotions is for choices.
	 */
	public static void displayPromotion() {
		if (FileReaderService.pList.isEmpty()) {
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
			p = FileReaderService.pList.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choose a existent Promotion in the list !");
			return null;
		}
		return p;
	}

	/**
	 * Adds the student in sList.
	 * 
	 * @param s
	 *            The student.
	 * @return <code>1</code> if the student exists, <code>0</code> otherwise.
	 */
	public static int addStudent(Student s) {
		if (s == null)
			return 0;
		FileReaderService.sList.add(s);
		return 1;
	}

	/**
	 * Adds the professors in the profList.
	 * 
	 * @param prof
	 *            The Professor.
	 * @return <code>prof</code> if the professor is added for the first time in
	 *         the profList, <code>FileReaderService.profList.get(pos)</code>
	 *         otherwise to return the existent Professor.
	 */
	public static Professor addProfessors(Professor prof) {
		boolean exist = false;
		int pos = 0;
		if (prof == null)
			return null;
		for (int i = 0; i < FileReaderService.profList.size(); i++) {
			if (FileReaderService.profList.get(i).equals(prof)) {
				exist = true;
				pos = i;
			}
		}
		if (!exist) {
			FileReaderService.profList.add(prof);
			return prof;
		}
		return FileReaderService.profList.get(pos);
	}

	/**
	 * Add the Promotion in pList.
	 * 
	 * @param p
	 *            The Promotion.
	 * @return <code>p</code> if the promotion is added for the first time in
	 *         the pList, <code>FileReaderService.pList.get(pos)</code>
	 *         otherwise to return the existent Promotion.
	 */
	public static Promotion addPromotion(Promotion p) {
		if (p == null)
			return null;

		// We check if the promotion doesn't still exist in the Professor List.
		boolean exist = false;
		int pos = 0;
		for (int i = 0; i < FileReaderService.pList.size(); i++) {
			if (FileReaderService.pList.get(i).equals(p)) {
				exist = true;
				pos = i;
			}
		}

		if (!exist) {
			FileReaderService.pList.add(p);
			return p;
		}
		return FileReaderService.pList.get(pos);
	}

	/**
	 * Add the marks in the array of marks.
	 * 
	 * @param index
	 *            The index of the Marks' array.
	 * @param value
	 *            The value of the mark.
	 * @return <code>1</code> if the adding was a success, <code>0</code>
	 *         otherwise.
	 */
	public static int addMarks(int index, String value) {
		if ((index < 0 && index > 9)
				|| (Float.valueOf(value) < 0 && Float.valueOf(value) > 20))
			return 0;
		marks[index] = value;
		return 1;
	}

	/**
	 * Permits to situate the index of the right Promotion in the pList.
	 * 
	 * @param p
	 *            The Promotion.
	 * @return the index of the Promotion found.
	 */
	public static int getIndexPromotion(Promotion p) {
		int i, pos = 0;
		for (i = 0; i < FileReaderService.pList.size(); i++) {
			if (FileReaderService.pList.get(i).equals(p)) {
				pos = i;
			}
		}
		return pos;
	}

	/**
	 * Sort students in a promotion by average.
	 * 
	 * @param mode
	 *            if <code>0</code> the sort is in ascending order,
	 *            <code>1</code>descending order otherwise.
	 */
	public static void sortStudentsPromotion(int mode) {
		if (FileReaderService.sList.isEmpty()) {
			System.out.println("There is no Student !");

		} else if (FileReaderService.pList.isEmpty()) {
			System.out.println("There is no Promotion !");

		} else {

			System.out.println("Which promotion do you want ?");
			displayPromotionList();
			Scanner scIndexP = new Scanner(System.in);

			Promotion p = null;
			while (p == null) {
				int iP = scIndexP.nextInt();
				p = choosePromotionList(iP);
			}

			if (mode == 0) {
				p.sort(0);
				System.out.println(p);
			} else {
				p.sort(1);
				System.out.println(p);
			}
		}
	}
}
