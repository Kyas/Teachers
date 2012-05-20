package teachersV2.io;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * FileReader.java - Version 2
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
public abstract class FileReaderService {

	public void read(String filename, String separator) throws IOException {
		if (filename != null) {

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
	 * Manipulate each line of the file.
	 * 
	 * @param tokens
	 *            The tokens.
	 */
	public abstract void getLine(String[] tokens);

}
