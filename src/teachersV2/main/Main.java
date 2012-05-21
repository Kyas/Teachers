package teachersV2.main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teachersV2.core.Core;
import teachersV2.io.FileRead;
import teachersV2.io.FileReadService;
import teachersV2.io.FileWriteService;

/**
 * Main.java - Version 2
 * 
 * Copyright 2012
 * 
 * This file is part of the Java Project : Teachers.
 * 
 * Teachers is free software: you can redistribute it and/or modify it under the
 * terms of the zlib license. See the COPYING file.
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

					while (res < 1 || res > 12) {
						Scanner sc = new Scanner(System.in);
						res = sc.nextInt();
					}

					switch (res) {
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
					case 12:
						System.out.println("End of the Program.");
						System.exit(0);
						break;
					default:
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
