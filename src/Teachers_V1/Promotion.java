package Teachers_V1;

import java.util.ArrayList;
import java.util.Collections;

import Teachers_V1.exceptions.UnknownStudent;

/**
 * Promotion.java
 * 
 * Copyright 2012
 * 
 * This file is part of the Java Project : Teachers.
 * 
 * Teachers is free software: you can redistribute it and/or modify it under the
 * terms of the zlib license. See the COPYING file.
 * 
 * @author Jérémy LOR <jlor@etudiant.univ-mlv.fr>
 * @author Thomas LEROUX <tleroux@etudiant.univ-mlv.fr>
 */
public class Promotion {
	/*
	 * The name of the Promotion.
	 */
	private String name;

	/*
	 * The List of Students (ArrayList).
	 */
	public ArrayList<Student> list;

	/**
	 * The constructor with a parameter.
	 * 
	 * @param name
	 *            The name of the Promotion.
	 */
	public Promotion(String name) {
		this.name = name;
		list = new ArrayList<Student>();
	}

	/**
	 * Search an existent student in the List.
	 * 
	 * @param id
	 *            The identifying student.
	 * @return The student.
	 * @throws UnknownStudent
	 *             If the student doesn't exist.
	 */
	public Student search(int id) throws UnknownStudent {
		Student s = null;
		boolean found = false;
		int i = 0;

		while (i < list.size() && !found) {
			s = list.get(i);
			if (s.getId() == id)
				found = true;
			i++;
		}

		if (!found) {
			throw new UnknownStudent("No student with this id " + ++i
					+ " in the list.");
		} else {
			return s;
		}
	}

	/**
	 * Display the Promotion.
	 * 
	 * @return The Promotion into a String.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i;
		sb.append("=======================\n\tPROMOTION\n=======================\n");
		for (i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		return sb.toString();
	}

	/**
	 * Add the student into a Promotion.
	 * 
	 * @param student
	 *            The Student.
	 * @return <code>1</code> if the adding was a success, <code>0</code> otherwise.
	 */
	public int add(Student student) {
		int i;
		boolean error = false;
		for (i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == student.getId()) {
				error = true;
			}
		}
		if (error) {
			System.out.println("Error : Same ID in the Promotion !");
		} else {
			list.add(student);
			student.setP(this);
			return 1;
		}
		return 0;
	}

	/**
	 * Sort the list of Students depending of the sort mode
	 * (ascending/descending order).
	 * 
	 * @param mode
	 *            <code>0</code> (ascending) or <code>1</code>(descending)
	 *            order.
	 * @return The sorted list.
	 */
	public int sort(int mode) {
		if (this.list != null) {
			if (mode == 0) { /* If mode = 0; ascending */

				Collections.sort(list);

			} else if (mode == 1) { /* If mode = 1; descending */

				Collections.sort(list, Collections.reverseOrder());

			} else {
				return 0;
			}
			return 1;
		}
		return 0;
	}

	/**
	 * Get the name of the Promotion.
	 * 
	 * @return The name of the Promotion.
	 */
	public String getName() {
		return name;
	}
}