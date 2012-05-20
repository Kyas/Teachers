package teachersV2.main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teachersV2.core.Core;
import teachersV2.io.FileReader;
import teachersV2.io.FileReaderService;

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
 * @author Jeremy LOR <jlor@etudiant.univ-mlv.fr>
 * @author Thomas LEROUX <tleroux@etudiant.univ-mlv.fr>
 */
public class Main {

	public static void main(String[] args) {

		try {
			// Command Line with the name of the file as an argument.
			FileReaderService fr = new FileReader();
			for (int i = 0; i < args.length; i++) {
				System.out.println("Reading: " + args[i]);
				String path = args[i];
				fr.read(path, ";");
			}

			try {
				while (true) { // When we don't want to quit the program now.
					System.out.println(Core.menu());
					int res = -1;

					while (res < 0 || res > 9) {
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
						Core.sortStudentsPromotion(0);
						break;
					case 7:
						Core.sortStudentsPromotion(1);
						break;
					case 8:
						break;
					case 9:
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
		} catch(IndexOutOfBoundsException e) {
			System.err.println("Error Columns Found on the file !\nReason: " + e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			System.err
					.println("/!\\ Please, format well your file .csv !\nReason : "
							+ e.getLocalizedMessage() + "\n");
		} catch (NoSuchElementException e) {
			System.err.println("No response found !");
		}
	}
}
