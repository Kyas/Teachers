package teachersV2.core;

import java.util.InputMismatchException;
import java.util.Scanner;

import teachersV2.Professor;
import teachersV2.Promotion;
import teachersV2.Student;
import teachersV2.io.FileRead;
import teachersV2.io.FileReadService;

/**
 * Contains all the manipulation of the program with the menu, reading and
 * writing files.<br /><br />
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
public class Core {

	/**
	 * Constant about the size of the marks' array.
	 */
	static final int NB_EVALUATIONS = 10;

	/**
	 * Marks' array, this array can have 10 marks.
	 */
	public final static String marks[] = new String[NB_EVALUATIONS];

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
		if (FileReadService.sList.isEmpty()) {
			System.out.println("There is no Students !");
		} else {
			int i;
			for (i = 0; i < FileReadService.sList.size(); i++) {
				if (i < FileReadService.sList.size() - 1) {
					System.out.print(i + ":("
							+ FileReadService.sList.get(i).displayNames()
							+ "), ");
				} else {
					System.out
							.print(i
									+ ":("
									+ FileReadService.sList.get(i)
											.displayNames() + ")");
				}
			}
			System.out.println();
		}
	}

	/**
	 * This display of students is for choices.
	 * 
	 * @param mode
	 *            if <code>0</code>, we display all the informations of the
	 *            student, <code>1</code> only his name and his average.
	 */
	public static void displayStudent(int mode) {
		if (FileReadService.sList.isEmpty()) {
			System.out.println("There is no Students !");
		} else {
			System.out.println("Which student do you want to choose ?");
			int i;
			for (i = 0; i < FileReadService.sList.size(); i++) {
				System.out.print(i + ":("
						+ FileReadService.sList.get(i).displayNames() + ") ");
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
			s = FileReadService.sList.get(index);
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
		if (FileRead.profListFiles.isEmpty()) {
			System.out.println("There is no Professor !");
		} else {
			int i;
			for (i = 0; i < FileRead.profListFiles.size(); i++) {
				System.out.print("(" + FileRead.profListFiles.get(i) + ") ");
			}
			System.out.println();
		}
	}

	/**
	 * Display the Promotion List.
	 */
	public static void displayPromotionList() {
		if (FileReadService.pList.isEmpty()) {
			System.out.println("There is no Promotion !");
		} else {
			int i;
			for (i = 0; i < FileReadService.pList.size(); i++) {
				System.out.print(i + ":"
						+ FileReadService.pList.get(i).getName() + " ");
			}
			System.out.println();
		}
	}

	/**
	 * This display of promotions is for choices.
	 */
	public static void displayPromotion() {
		if (FileReadService.pList.isEmpty()) {
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
	 * Add the Student in the Promotion.
	 */
	public static void addPromotionStudent() {
		if (FileRead.sList.isEmpty()) {
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
				for (int i = 0; i < FileRead.pList.size(); i++) {
					if (FileRead.pList.get(i).equals(pNew)) {
						exist = true;
					}
				}

				if (!exist) {
					FileRead.pList.add(pNew);
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
				if (FileRead.pList.isEmpty()) {
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
	 * Choose the promotion in the actual List in the Program.
	 * 
	 * @param index
	 *            The index of the Promotion List.
	 * @return The promotion.
	 */
	public static Promotion choosePromotionList(int index) {
		Promotion p = null;
		try {
			p = FileReadService.pList.get(index);
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
		FileReadService.sList.add(s);
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
		for (int i = 0; i < FileReadService.profList.size(); i++) {
			if (FileReadService.profList.get(i).equals(prof)) {
				exist = true;
				pos = i;
			}
		}
		if (!exist) {
			FileReadService.profList.add(prof);
			return prof;
		}
		return FileReadService.profList.get(pos);
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
		for (int i = 0; i < FileReadService.pList.size(); i++) {
			if (FileReadService.pList.get(i).equals(p)) {
				exist = true;
				pos = i;
			}
		}

		if (!exist) {
			FileReadService.pList.add(p);
			return p;
		}
		return FileReadService.pList.get(pos);
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
		for (i = 0; i < FileReadService.pList.size(); i++) {
			if (FileReadService.pList.get(i).equals(p)) {
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
	public static void sortStudentsPromotion() {
		if (FileReadService.sList.isEmpty()) {
			System.out.println("There is no Student !");

		} else if (FileReadService.pList.isEmpty()) {
			System.out.println("There is no Promotion !");

		} else {

			System.out
					.println("Do you want to sort in an Ascending Order (0) or Descending Order (1) ?");
			int mode = -1;
			while (mode < 0 || mode > 1) {
				Scanner scMode = new Scanner(System.in);
				mode = scMode.nextInt();
			}

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
			prof = FileRead.profListFiles.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choose a existent Professor in the list !");
			return null;
		}
		return prof;
	}

	/**
	 * Add Marks to the student in a promotion.
	 */
	public static void manageMarks() {
		if (FileReadService.sList.isEmpty()) {
			System.out.println("There is no Student !");

		} else if (FileRead.profListFiles.isEmpty()) {
			System.out.println("There is no Professor !");
		} else if (FileReadService.pList.isEmpty()) {
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
			for (int i = 0; i < FileReadService.sList.size(); i++) {
				if (FileReadService.sList.get(i).equals(student)) {
					exist = true;
				}
			}

			if (!exist) {
				FileReadService.sList.add(student);
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
		for (int i = 0; i < FileRead.profListFiles.size(); i++) {
			if (FileRead.profListFiles.get(i).equals(prof)) {
				exist = true;
			}
		}

		if (!exist) {
			FileRead.profListFiles.add(prof);
			System.out.println("Professor " + prof + " created.");
		} else {
			System.out.println("This professor still exist !");
		}
		System.out.println();
	}

	/**
	 * Can add or delete a student.
	 */
	public static void manageStudents() {
		System.out.print("Do you want to add (0) or delete (1) a student ? ");

		int res = -1;

		while (res < 0 || res > 1) {
			Scanner sc = new Scanner(System.in);
			res = sc.nextInt();
		}

		switch (res) {
		case 0:
			createStudent();
			break;
		case 1:
			if (FileReadService.sList.isEmpty()) {
				System.out.println("There is no Student !");
			} else {
				System.out.println("Which student do you want delete ?");
				displayStudentList();
				Scanner scIndexS = new Scanner(System.in);

				Student s = null;
				while (s == null) {
					int iS = scIndexS.nextInt();
					s = chooseStudentList(iS);
					FileReadService.pList.get(iS).remove(s);
				}
				FileReadService.sList.remove(s);
				System.out.println("The student " + s.displayNames()
						+ " has been deleted.");
			}
			break;
		default:
			createStudent();
			break;
		}
	}

	/**
	 * Can add or delete a professor.
	 */
	public static void manageProfessors() {

		System.out.print("Do you want to add (0) or delete (1) a professor ? ");

		int res = -1;

		while (res < 0 || res > 1) {
			Scanner sc = new Scanner(System.in);
			res = sc.nextInt();
		}

		switch (res) {
		case 0:
			createProfessor();
			break;
		case 1:
			if (FileRead.profListFiles.isEmpty()) {
				System.out.println("There is no Professor !");
			} else {
				System.out.println("Which professor do you want delete ?");
				displayProfessorList();
				Scanner scIndexProf = new Scanner(System.in);

				Professor prof = null;
				while (prof == null) {
					int iProf = scIndexProf.nextInt();
					prof = chooseProfessorList(iProf);

				}
				FileRead.profListFiles.remove(prof);
				System.out.println("The professor " + prof
						+ " has been deleted.");
			}
			break;
		default:
			createProfessor();
			break;
		}

	}

}
