package teachersV2;

import java.util.HashSet;
import java.util.Set;

import teachersV2.exceptions.EmptyMarks;

/**
 * A student is represented with an id, a promotion if he got one and can have
 * marks (10 the maximum).<br />
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
public class Student extends Person implements Comparable<Student> {
	/*
	 * The Promotion.
	 */
	private Promotion p;

	/*
	 * The number of Evaluations.
	 */
	static final int NB_EVALUATIONS = 10;

	/*
	 * The marks' Array of a specified student.
	 */
	public final Evaluation marks[] = new Evaluation[NB_EVALUATIONS];

	/*
	 * The identifying student.
	 */
	private final int id;

	/**
	 * The constructor with parameters.
	 * 
	 * @param name
	 *            The name of the student.
	 * @param forename
	 *            The first name of the student.
	 * @param id
	 *            The identifying student.
	 */
	public Student(String name, String forename, int id) {
		super(name, forename);
		this.id = id;
		p = null;
	}

	/**
	 * Give the average of a student.
	 * 
	 * @return The average of a student.
	 * @throws EmptyMarks
	 *             if the student doesn't have marks.
	 */
	public float average() throws EmptyMarks {
		int numberofMarks = 0;

		float sum = 0;

		int i = 0;
		while (i < 10) {
			if (getMarks()[i] != null) {
				sum += getMarks()[i].getValue();
				numberofMarks++;
			}
			i++;
		}

		if (numberofMarks == 0) {
			throw new EmptyMarks(super.toString() + " doesn't have marks !");

		} else {
			return sum / numberofMarks;
		}
	}

	/**
	 * Display the student.
	 * 
	 * @return The student into a String.
	 */
	@Override
	public String toString() {
		int i;
		StringBuilder sb = new StringBuilder();

		if (this.getMarks() != null) {
			try {
				if (average() != 0) {
					sb.append(super.toString());
					sb.append("\n\tPromotion: " + p.getName());
					sb.append("\n\tId: ").append(id).append("\n\tMarks: ");

					for (i = 0; i < NB_EVALUATIONS; i++) {
						if (this.marks[i] != null) {
							sb.append(marks[i] + " ");
						}
					}

					sb.append("\n\tGrader(s): ").append(this.getGraders());
					sb.append("\n\tAverage: ").append(this.average())
							.append("\n");
				}
			} catch (EmptyMarks e) {
				System.out.println(super.toString() + " doesn't have marks !");
			}
		}
		return sb.toString();
	}

	/**
	 * Display the student with his name/forename.
	 * 
	 * @return The student.
	 */
	public String displayNames() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.name + " " + super.forename);

		return sb.toString();
	}

	/**
	 * Display the student with his name/forename and average.
	 * 
	 * @return The student with his average.
	 */
	public String displayAverage() {
		StringBuilder sb = new StringBuilder();

		try {
			if (this.average() != 0) {
				sb.append(super.toString() + ", Average: ").append(
						this.average());
			}
		} catch (EmptyMarks e) {
			System.out.println(super.toString() + " doesn't have marks !");
		}

		return sb.toString();
	}

	/**
	 * Return the list of graders (professors who corrects students).
	 * 
	 * @return The list of graders.
	 */
	public Set<Professor> getGraders() {
		Set<Professor> list = new HashSet<Professor>();

		for (int i = 0; i < getMarks().length; i++) {
			if (getMarks()[i] != null)
				list.add(getMarks()[i].getGrader());
		}
		return list;
	}

	/**
	 * Compare the average of two students. Average1 : The average of the 1st
	 * student. Average2 : The average of the 2nd student.
	 * 
	 * @return <code>-1</code> if average1 > average2, <code>0</code> if
	 *         average1 = average2, <code>1</code> if average1 < average2
	 */
	@Override
	public int compareTo(Student eleve) {
		float average1 = 0;
		float average2 = 0;

		try {
			average1 = this.average();
			average2 = eleve.average();
		} catch (EmptyMarks e) {
			e.getMessage();
		}

		if (average1 > average2)
			return 1;
		if (average1 == average2)
			return 0;
		return -1;
	}

	/**
	 * Get the marks of a student.
	 * 
	 * @return The marks.
	 */
	public Evaluation[] getMarks() {
		return marks;
	}

	/**
	 * Return if two students are equals.
	 * 
	 * @param o
	 *            An object of type Student.
	 * @return <code>true</code> if these two students are equals,
	 *         <code>false</code> otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Student) {
			Student s = (Student) o;
			return (this.name.equals(s.name) && this.forename
					.equals(s.forename));

		}
		return false;
	}

	/**
	 * Get the name of the Student.
	 * 
	 * @return The name of the Student.
	 */
	public String getName() {
		return super.name;
	}
	
	/**
	 * Get the forename of the Student.
	 * 
	 * @return The forename of the Student.
	 */
	public String getForename() {
		return super.forename;
	}
	
	/**
	 * Get the identifying student.
	 * 
	 * @return The identifying student.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the Promotion of a student.
	 * 
	 * @return The promotion of a student.
	 */
	public Promotion getP() {
		return p;
	}

	/**
	 * Set the Promotion on a student.
	 * 
	 * @param p
	 *            The promotion.
	 */
	public void setP(Promotion p) {
		this.p = p;
	}
}