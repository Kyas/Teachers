package teachersV1.main;

import teachersV1.Professor;
import teachersV1.Promotion;
import teachersV1.Student;
import teachersV1.exceptions.UnknownStudent;

/**
 * This is the main Test for the Version Console Mode 1 (V1).<br />
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
	public static void main(String[] args) {

		Promotion p1 = new Promotion("Biniou");
		Promotion p2 = new Promotion("GodLike");

		/**
		 * Creates 4 students and 2 professors.
		 */
		Student student1 = new Student("Lor", "Jeremy", 1);
		Student student2 = new Student("Le Roux", "Thomas", 2);
		Student student3 = new Student("Norris", "Chuck", 3);

		Professor prof1 = new Professor("Paumier", "Sébastien");
		Professor prof2 = new Professor("Zipstein", "Marc");

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

		/**
		 * Display all the students in a Promotion depending of his Promotion.
		 * 
		 * For example, we search students by their id in the 1st Promotion.
		 */

		try {
			System.out.println(p1.search(1));
			System.out.println(p1.search(2));
			// Show the student3 but doesn't have marks !
			System.out.println(p2.search(3));
			// Search a student with an id5 but doesn't exist in the 1st
			// Promotion !
			System.out.println(p1.search(5));
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
}
