package teachersV2.main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teachersV2.Professor;
import teachersV2.Promotion;
import teachersV2.Student;
import teachersV2.exceptions.UnknownStudent;
import teachersV2.core.Core;
import teachersV2.io.FileRead;
import teachersV2.io.FileReadService;
import teachersV2.io.FileWriteService;

/**
 * This is the main Test for the Version Reading/Writing Mode (V2).<br />
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
public class Main {

	/**
	 * Display the menu.
	 * 
	 * @return the menu into a String.
	 */
	public static String menu() {
		StringBuilder sb = new StringBuilder();

		sb.append("========== Menu ==========\n");
		sb.append("0- Do ALL the tests ! (File .csv empty)\n");
		sb.append("1- Display all the students\n");
		sb.append("2- Display all the professors\n");
		sb.append("3- Display a Promotion\n");
		sb.append("4- Display a student (name, promotion, marks, graders)\n");
		sb.append("5- Display a student with his name and average\n");
		sb.append("6- Sort students in a Promotion\n");
		sb.append("7- Manage Notes\n");
		sb.append("8- Manage Students\n");
		sb.append("9- Manage Professors\n");
		sb.append("10- Manage Promotions\n");
		sb.append("11- Save the File\n");
		sb.append("12- Quit the Program");

		return sb.toString();
	}
	
	/**
	 * Do all the games' tests.
	 */
	public static void allTests() {
		Promotion p1 = new Promotion("Biniou");
		Core.addPromotion(p1);
		Promotion p2 = new Promotion("GodLike");
		Core.addPromotion(p2);

		/**
		 * Creates 4 students and 2 professors.
		 */
		Student student1 = new Student("Lor", "Jeremy", 1);
		Core.addStudent(student1);
		Student student2 = new Student("Le Roux", "Thomas", 2);
		Core.addStudent(student2);
		Student student3 = new Student("Norris", "Chuck", 3);
		Core.addStudent(student3);

		Professor prof1 = new Professor("Paumier", "Sebastien");
		Core.addProfessors(prof1);
		Professor prof2 = new Professor("Zipstein", "Marc");
		Core.addProfessors(prof2);

		/**
		 * Put students in their promotions.
		 * 
		 * Two students are in the 1st Promotion. The third is in the 2nd
		 * Promotion.
		 */
		p1.add(student1);
		p1.add(student2);
		p2.add(student3);

		/**
		 * Put marks to students.
		 * 
		 * For example, we put marks for students in the 1st Promotion.
		 */
		prof1.setNote(p1, 1, 12, 0);
		prof2.setNote(p1, 1, 13, 1);
		prof1.setNote(p1, 1, 15, 7);

		prof1.setNote(p1, 2, 18, 0);
		prof1.setNote(p1, 2, 16, 3);
		prof1.setNote(p1, 2, 15, 5);
		
		prof1.setNote(p2, 3, 20, 6);

		/**
		 * Display all the students in a Promotion depending of his Promotion.
		 * 
		 * For example, we search students by their id in the 1st Promotion.
		 */

		try {
			System.out.println(p1.search(1));
			System.out.println(p1.search(2));
			System.out.println(p2.search(3));
		} catch (UnknownStudent e) {
			System.out.println(e.getMessage());
		}

		/**
		 * Display averages of students.
		 */
		System.out.println();
		System.out.println(student1.displayAverage());
		System.out.println(student2.displayAverage());
		System.out.println(student3.displayAverage());

		/**
		 * Sort the promotion 1 with the 2 modes.
		 */
		System.out.println();
		System.out.println("Ascending Order :");
		p1.sort(0);
		System.out.println(p1);

		System.out.println("Descending Order :");
		p1.sort(1);
		System.out.println(p1);
	}

	/**
	 * This the main test to run the program.
	 * 
	 * @param args
	 *            The list of arguments.
	 */
	public static void main(String[] args) {

		try {
			// Command Line with the name of the file as an argument.
			FileReadService fr = new FileRead();
			for (int i = 0; i < args.length; i++) {
				System.out.println("Reading: " + args[i]);
				String path = args[i];
				fr.read(path, ";");
			}

			try {
				while (true) { // When we don't want to quit the program now.
					System.out.println(menu());
					int res = -1;

					while (res < 0 || res > 12) {
						Scanner sc = new Scanner(System.in);
						res = sc.nextInt();
					}

					switch (res) {
					case 0:
						allTests();
						FileWriteService.runWrite();
						System.out.println("End of the Program.");
						System.exit(0);
						break;
					case 1:
						Core.displayStudentList();
						break;
					case 2:
						Core.displayProfessorList();
						break;
					case 3:
						Core.displayPromotion();
						break;
					case 4:
						Core.displayStudent(0);
						break;
					case 5:
						Core.displayStudent(1);
						break;
					case 6:
						Core.sortStudentsPromotion();
						break;
					case 7:
						Core.manageMarks();
						break;
					case 8:
						Core.manageStudents();
						break;
					case 9:
						Core.manageProfessors();
						break;
					case 10:
						Core.addPromotionStudent();
						break;
					case 11:
						FileWriteService.runWrite();
						System.out.println("End of the Program.");
						System.exit(0);
						break;
					case 12: default:
						System.out.println("End of the Program.");
						System.exit(0);
						break;
					}

				}
			} catch (NoSuchElementException e) {
				System.out.println("Program Interruption.");
			}
		} catch (IOException e) {
			System.err
					.println("File Not Found !\nAre you sure this is the right file/place ?\n");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Error Columns Found on the file !\nReason: "
					+ e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			System.err
					.println("/!\\ Please, format well your file .csv !\nReason : "
							+ e.getLocalizedMessage() + "\n");
		} catch (NoSuchElementException e) {
			System.err.println("No response found !");
		}
	}
}
