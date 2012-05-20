package teachersV1.exceptions;

/**
 * EmptyMarks.java
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
@SuppressWarnings("serial")
public class EmptyMarks extends Exception {

	/**
	 * Display the error message.
	 * 
	 * @param message The error message.
	 */
	public EmptyMarks(String message) {
		super(message);
	}
}
