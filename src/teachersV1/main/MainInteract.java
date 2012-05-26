package teachersV1.main;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This is the main Test for the Version Console Mode 1 Advanced (V1).<br />
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
public class MainInteract {

	public static void main(String[] args) {

		try {
			while (true) { // When we don't want to quit the program now.
				System.out.println(Interact.menu());
				int res = -1;

				while (res < 0 || res > 9) {
					Scanner sc = new Scanner(System.in);
					res = sc.nextInt();
				}

				switch (res) {
				case 0:
					Interact.createStudent();
					break;
				case 1:
					Interact.createProfessor();
					break;
				case 2:
					Interact.addStudent();
					break;
				case 3:
					Interact.addMarks();
					break;
				case 4:
					Interact.displayPromotion();
					break;
				case 5:
					Interact.displayStudent(0);
					break;
				case 6:
					Interact.displayStudent(1);
					break;
				case 7:
					Interact.sortStudentsPromotion(0);
					break;
				case 8:
					Interact.sortStudentsPromotion(1);
					break;
				case 9: default:
					System.out.println("End of the Program.");
					System.exit(0);
					break;
				}

			}
		} catch (NoSuchElementException e) {
			System.out.println("Program Interruption.");
		}
	}

}
