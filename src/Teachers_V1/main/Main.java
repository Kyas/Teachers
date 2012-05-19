/**
 * Main.java
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

import Teachers_V1.Student;
import Teachers_V1.Professor;
import Teachers_V1.Promotion;
import Teachers_V1.exceptions.UnknownStudent;

public class Main {
	public static void main(String[] args) {
		
		Promotion p1 = new Promotion("Biniou's Promotion");
		Promotion p2 = new Promotion("GodLike's Promotion");

		/**
		 * Creates 4 students and 2 professors.
		 */
		Student student1 = new Student("Lor", "Jérémy", 1);
		Student student2 = new Student("Le Roux", "Thomas", 2);
		Student student3 = new Student("Norris", "Chuck", 3);
		
		Professor prof1 = new Professor("Paumier", "Sébastien");
		Professor prof2 = new Professor("Zipstein", "Marc");
		
		/**
		 * Put students in their promotions.
		 */
		p1.add(student1);
		p1.add(student2);
		p2.add(student3);

		/**
		 * Put marks to students.
		 */
		prof1.setNote(p1, 1, 12, 0);
		prof2.setNote(p1, 1, 13, 1);
		prof1.setNote(p1, 1, 15, 7);
		
		prof1.setNote(p1, 2, 18, 0);
		prof1.setNote(p1, 2, 16, 3);
		prof1.setNote(p1, 2, 15, 5);
		
		/**
		 * Display all the students in a Promotion depending of his Promotion.
		 */
		
		try {
			System.out.println(p1.search(1));
			System.out.println(p1.search(2));
			System.out.println(p1.search(3));
			System.out.println(p1.search(4));
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

