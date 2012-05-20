package teachersV2.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import teachersV2.Professor;
import teachersV2.Promotion;
import teachersV2.Student;

/**
 * The service for the class FileReader - Version 2<br />
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
 * @author Jeremy LOR <jlor@etudiant.univ-mlv.fr>
 * @author Thomas LEROUX <tleroux@etudiant.univ-mlv.fr>
 */
public abstract class FileReaderService {

	/*
	 * List of Students.
	 */
	public static ArrayList<Student> sList = new ArrayList<Student>();

	/*
	 * List of Professors.
	 */
	public static ArrayList<Professor> profList = new ArrayList<Professor>();

	/*
	 * List of Promotions.
	 */
	public static ArrayList<Promotion> pList = new ArrayList<Promotion>();

	/**
	 * Opens a file and split words with a separator, splitted into tokens.
	 * 
	 * @param filename
	 *            The name of the file.
	 * @param separator
	 *            The seperator (a character).
	 * @throws IOException
	 *             If the file doesn't exist or not found.
	 */
	public void read(String filename, String separator) throws IOException {
		if (filename != null) {

			// To reset the list of Professors for marks.
			profList.removeAll(profList);
			BufferedReader reader = new BufferedReader(new java.io.FileReader(
					filename));

			String line;
			while ((line = reader.readLine()) != null) {

				final String[] tokens = line.split(separator);
				getLine(tokens);
			}
			reader.close();
		}
	}

	/**
	 * Display the lines of the file.
	 * 
	 * @param tokens
	 *            The tokens.
	 */
	public abstract void displayLines(String[] tokens);

	/**
	 * Manipulate each line of the file, depending of the number on this line.<br />
	 * 
	 * If <code>1</code>, contains the name, forename and the id of the student.<br />
	 * If <code>2</code>, contains the promotion's name.<br />
	 * If <code>3</code>, contains the professors' name.<br />
	 * If <code>4</code>, contains the mark sorted into a array.<br />
	 * If <code>5</code>, contains the professor (specified by an index) to see
	 * where the mark belongs to.<br />
	 * <br />
	 * 
	 * Be careful ! Codes 4 & 5 must be at the same place in these 2 arrays !<br />
	 * <br />
	 * 
	 * If <code>6</code>, contains the average of the student.
	 * 
	 * @param tokens
	 *            The tokens.
	 */
	public abstract void getLine(String[] tokens);

}
