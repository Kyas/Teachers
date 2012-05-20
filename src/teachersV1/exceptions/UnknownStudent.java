package teachersV1.exceptions;

/**
 * UnknownStudent.java
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

@SuppressWarnings("serial")
public class UnknownStudent extends Exception {

	/**
	 * Display the error message.
	 * 
	 * @param message
	 *            The error message.
	 */
	public UnknownStudent(String message) {
		super(message);
	}
}
