package teachersV2;

/**
 * The class Person permits to define a human (name, forename).<br />
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
abstract class Person {
	/**
	 * The name of the Person.
	 */
	protected final String name;

	/**
	 * The first name of the Person.
	 */
	protected final String forename;

	/**
	 * The constructor without parameters.
	 */
	protected Person() {
		name = forename = null;
	}

	/**
	 * The constructor with parameters.
	 * 
	 * @param name
	 *            The name of the Person.
	 * @param prenom
	 *            The first name of the Person.
	 */
	protected Person(String name, String prenom) {
		this.name = name;
		this.forename = prenom;
	}

	/**
	 * Display the name and first name of the Person.
	 * 
	 * @return The name and first name of the Person into a String.
	 */
	@Override
	public String toString() {
		return "(" + name + ", " + forename + ")";
	}
}