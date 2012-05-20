package teachersV1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import teachersV1.Professor;
import teachersV1.Promotion;
import teachersV1.Student;

/**
 * This class contains all the implementation for the console mode advanced.<br />
 * <br />
 * 
 * Copyright 2012 - This file is part of the Java Project : Teachers.<br />
 * <br />
 * 
 * Teachers is free software: you can redistribute it and/or modify it under the
 * terms of the zlib license.<br />
 * See the COPYING file.<br />
 * <br />
 * 
 * @author Jeremy LOR (jlor@etudiant.univ-mlv.fr)
 * @author Thomas LEROUX (tleroux@etudiant.univ-mlv.fr)
 */
public class Interact {

	/*
	 * List of Students.
	 */
	static ArrayList<Student> sList = new ArrayList<Student>();

	/*
	 * List of Professors.
	 */
	static ArrayList<Professor> profList = new ArrayList<Professor>();

	/*
	 * List of Promotions.
	 */
	static ArrayList<Promotion> pList = new ArrayList<Promotion>();

	/**
	 * Display the menu.
	 * 
	 * @return the menu into a String.
	 */
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
		sb.append("7- Sort students in a Promotion in Ascending Order\n");
		sb.append("8- Sort students in a Promotion in Descending Order\n");
		sb.append("9- Quit the Program");

		return sb.toString();
	}

	/**
	 * Create a student.
	 * 
	 * @return <code>1<code> if the creation was a success, <code>0</code>
	 *         otherwise.
	 */
	public static int createStudent() {
		System.out.println("=== Creation of a student ===");
		Scanner scId = new Scanner(System.in);
		System.out.print("Give a name: ");
		String name = "";
		while (name.equals("")) {
			Scanner scName = new Scanner(System.in);
			name = scName.nextLine();
		}
		System.out.print("Give a first name: ");
		String forename = "";
		while (forename.equals("")) {
			Scanner scForename = new Scanner(System.in);
			forename = scForename.nextLine();
		}
		System.out.print("Give an id: ");
		try {
			int id = scId.nextInt();
			Student student = new Student(name, forename, id);

			// We check if the student doesn't still exist in the Student List.
			boolean exist = false;
			for (int i = 0; i < sList.size(); i++) {
				if (sList.get(i).equals(student)) {
					exist = true;
				}
			}

			if (!exist) {
				sList.add(student);
				System.out.println("Student " + student.displayNames()
						+ " created.");
			} else {
				System.out.println("This student still exist !");
			}

			System.out.println();
		} catch (InputMismatchException e) {
			System.out.println("Enter a valid number !");
			return 0;
		}
		return 1;
	}

	/**
	 * Create a Professor.
	 */
	public static void createProfessor() {
		System.out.println("=== Creation of a professor ===");
		System.out.print("Give a name: ");
		String name = "";
		while (name.equals("")) {
			Scanner scName = new Scanner(System.in);
			name = scName.nextLine();
		}
		System.out.print("Give a first name: ");
		String forename = "";
		while (forename.equals("")) {
			Scanner scForename = new Scanner(System.in);
			forename = scForename.nextLine();
		}
		Professor prof = new Professor(name, forename);

		// We check if the professor doesn't still exist in the Professor List.
		boolean exist = false;
		for (int i = 0; i < profList.size(); i++) {
			if (profList.get(i).equals(prof)) {
				exist = true;
			}
		}

		if (!exist) {
			profList.add(prof);
			System.out.println("Professor " + prof + " created.");
		} else {
			System.out.println("This professor still exist !");
		}
		System.out.println();
	}

	/**
	 * Display the actual Student List in the Program.
	 */
	public static void displayStudentList() {
		int i;
		for (i = 0; i < sList.size(); i++) {
			System.out.print(i + ":" + sList.get(i).displayNames() + " ");
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
			displayStudentList();
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
			System.out.print(i + ":" + profList.get(i) + " ");
		}
		System.out.println();
	}

	/**
	 * Choose the professor in the actual List in the Program.
	 * 
	 * @param index
	 *            The index of the Professor List.
	 * @return The professor.
	 */
	public static Professor chooseProfessorList(int index) {
		Professor prof = null;
		try {
			prof = profList.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choose a existent Professor in the list !");
			return null;
		}
		return prof;
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

	/**
	 * Add the Student in the Promotion.
	 */
	public static void addStudent() {
		if (sList.isEmpty()) {
			System.out.println("There is no Student !");
		} else {
			System.out
					.println("Create a Promotion (0) or choose an existing one (1) ?");
			int res = -1;

			while (res < 0 || res > 1) {
				Scanner sc = new Scanner(System.in);
				res = sc.nextInt();
			}
			// If we create a new Promotion.
			if (res == 0) {
				Scanner scName = new Scanner(System.in);
				System.out.print("Give a name: ");
				String name = scName.nextLine();
				Promotion pNew = new Promotion(name);

				// We check if the professor doesn't still exist in the
				// Professor List.
				boolean exist = false;
				for (int i = 0; i < pList.size(); i++) {
					if (pList.get(i).equals(pNew)) {
						exist = true;
					}
				}

				if (!exist) {
					pList.add(pNew);
					System.out.println("Promotion " + pNew.getName()
							+ " created.");
				} else {
					System.out.println("This promotion still exist !");
				}

				System.out.println("Which student do you want to add in ?");
				displayStudentList();
				Scanner scIndex = new Scanner(System.in);

				Student s = null;
				while (s == null) {
					int i = scIndex.nextInt();
					s = chooseStudentList(i);
				}
				pNew.add(s);
				System.out.println("Student " + s.displayNames()
						+ " added to the Promotion " + pNew.getName());

				// If we choose an existing Promotion.
			} else {
				if (pList.isEmpty()) {
					System.out.println("There is no Promotion !");
				} else {
					System.out
							.println("Which promotion do you want to add in ?");
					displayPromotionList();
					Scanner scIndexP = new Scanner(System.in);

					Promotion p = null;
					while (p == null) {
						int iP = scIndexP.nextInt();
						p = choosePromotionList(iP);
					}

					System.out.println("Which student do you want to add in ?");
					displayStudentList();
					Scanner scIndexS = new Scanner(System.in);

					Student s = null;
					while (s == null) {
						int iS = scIndexS.nextInt();
						s = chooseStudentList(iS);
					}
					if (p.add(s) != 0) {
						System.out.println("Student " + s.displayNames()
								+ " added to the Promotion " + p.getName());
					}
				}
			}
		}
	}

	/**
	 * Add Marks to the student in a promotion.
	 */
	public static void addMarks() {
		if (sList.isEmpty()) {
			System.out.println("There is no Student !");

		} else if (profList.isEmpty()) {
			System.out.println("There is no Professor !");
		} else if (pList.isEmpty()) {
			System.out.println("There is no Promotion !");
		} else {

			System.out.println("Which professor do you want as a grader ?");
			displayProfessorList();
			Scanner scIndexProf = new Scanner(System.in);

			Professor prof = null;
			while (prof == null) {
				int iProf = scIndexProf.nextInt();
				prof = chooseProfessorList(iProf);
			}

			System.out.println("Which student do you want to add marks ?");
			displayStudentList();
			Scanner scIndexS = new Scanner(System.in);

			Student s = null;
			while (s == null) {
				int iS = scIndexS.nextInt();
				s = chooseStudentList(iS);
			}

			if (s.getP().equals(null)) {
				System.out.println("This student has no Promotion !");
			} else {
				System.out.print("Give a mark: ");
				int value = -1;
				while (value < 0 || value > 20) {
					Scanner scValue = new Scanner(System.in);
					value = scValue.nextInt();
				}
				System.out.print("Give where you want to put the mark: ");
				int index = -1;
				while (index < 0 || index > 10) {
					Scanner scIndex = new Scanner(System.in);
					index = scIndex.nextInt();
				}
				prof.setNote(s.getP(), s.getId(), value, index);

				System.out.println("Mark with value " + value
						+ " added in the student " + s.displayNames()
						+ " with the grader " + prof);
			}
		}

	}

	/**
	 * Sort students in a promotion by average.
	 * 
	 * @param mode
	 *            if <code>0</code> the sort is in ascending order,
	 *            <code>1</code>descending order otherwise.
	 */
	public static void sortStudentsPromotion(int mode) {
		if (sList.isEmpty()) {
			System.out.println("There is no Student !");

		} else if (pList.isEmpty()) {
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
