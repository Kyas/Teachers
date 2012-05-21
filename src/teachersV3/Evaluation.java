package teachersV3;

/**
 * Contains all the evaluation for the corrected student, the grader (professor)
 * and the mark.<br />
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
public class Evaluation {
	/*
	 * The grader.
	 */
	private Professor grader;

	/*
	 * The corrected student.
	 */
	private final Student corrected;

	/*
	 * The value of the mark.
	 */
	private float value;

	/**
	 * The constructor of the Evaluation.
	 * 
	 * @param grader
	 *            The grader.
	 * @param corrected
	 *            The corrected student.
	 * @param value
	 *            The value of the mark.
	 */
	public Evaluation(Professor grader, Student corrected, float value) {
		this.grader = grader;
		this.corrected = corrected;
		this.value = value;
	}

	/**
	 * Display the Mark.
	 * 
	 * @return The value of the Mark into a String.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getValue());
		return sb.toString();
	}

	/**
	 * Get the grader (professor).
	 * 
	 * @return The grader.
	 */
	public Professor getGrader() {
		return grader;
	}

	/**
	 * Get the corrected student.
	 * 
	 * @return The corrected student.
	 */
	public Student getCorrected() {
		return corrected;
	}

	/**
	 * Get the value of the Mark.
	 * 
	 * @return The value of the Mark
	 */
	public float getValue() {
		return value;
	}

	/**
	 * Set the value of the Mark.
	 * 
	 * @param value
	 *            The value of the Mark.
	 */
	public void setValue(float value) {
		this.value = value;
	}

	/**
	 * Set the corrected student.
	 * 
	 * @param grader
	 *            The corrected student.
	 */
	public void setCorrected(Professor grader) {
		this.grader = grader;
	}
}