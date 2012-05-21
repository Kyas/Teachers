package teachersV1;

import teachersV1.exceptions.UnknownStudent;

/**
 * The professor can put marks to students depending of the promotion, the id of
 * the student and if he wants to add/modify a mark.<br />
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
public class Professor extends Person {

	/**
	 * The constructor with parameters.
	 * 
	 * @param name
	 * @param forename
	 */
	public Professor(String name, String forename) {
		super(name, forename);
	}

	/**
	 * Set or Modify a mark depending of the student's array. - Set : If no
	 * marks is in the specified index, we add the new mark in the array. -
	 * Modify : If a mark does exist in a index of the student's array, we
	 * modify it with the new value.
	 * 
	 * @param p
	 *            The Promotion where student is.
	 * @param id
	 *            The identifying student.
	 * @param value
	 *            The value of the mark.
	 * @param index
	 *            The index in the student's array
	 */
	public void setNote(Promotion p, int id, float value, int index) {
		Student corrected = null;
		try {
			corrected = p.search(id);
			if (corrected.getMarks()[index] == null)
				corrected.getMarks()[index] = new Evaluation(this, corrected,
						value);
			else {
				corrected.getMarks()[index].setValue(value);
				corrected.getMarks()[index].setCorrected(this);
			}
		} catch (UnknownStudent e) {
			System.out
					.println("The student doesn't exist or is in the wrong Promotion !");
		}
	}

	/**
	 * Display the name of a Professor.
	 * 
	 * @return The name of the Professor into a String.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " " + forename);
		return sb.toString();
	}

	/**
	 * Return if two professors are equals.
	 * 
	 * @param o
	 *            An object of type Professor.
	 * @return <code>true</code> if these two professors are equals,
	 *         <code>false</code> otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Professor) {
			Professor prof = (Professor) o;
			return (this.name.equals(prof.name) && this.forename
					.equals(prof.forename));

		}
		return false;
	}
	
	/**
	 * Get the name of the Professor.
	 * 
	 * @return The name of the Professor.
	 */
	public String getName() {
		return super.name;
	}
	
	/**
	 * Get the forename of the Professor.
	 * 
	 * @return The forename of the Professor.
	 */
	public String getForename() {
		return super.forename;
	}

}