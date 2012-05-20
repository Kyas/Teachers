package teachersV2.io;

import teachersV2.io.FileReaderService;

/**
 * DisplayFileReader.java - Version 2
 * 
 * Copyright 2012 
 * 
 * This file is part of the Java Project : Teachers.
 * 
 * Teachers is free software: you can redistribute it and/or modify
 * it under the terms of the zlib license. See the COPYING file.
 * 
 * @author Jeremy LOR <jlor@etudiant.univ-mlv.fr>
 * @author Thomas LEROUX <tleroux@etudiant.univ-mlv.fr>
 */
public class FileReader extends FileReaderService {

	@Override
	public void displayLines(String[] tokens) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < tokens.length; i++) {
			if (i != tokens.length - 1) {
				sb.append(tokens[i] + ", ");
			} else {
				
				sb.append(tokens[i]);
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	@Override
	public void getLine(String[] tokens) {
		int n = Integer.valueOf(tokens[0]);
		switch (n) {
		case 1:
			for (int i = 1; i < tokens.length; i++) {
				System.out.println(tokens[i]);
			}
			break;
		case 2:
			for (int i = 1; i < tokens.length; i++) {
				System.out.println(tokens[i]);
			}
			break;
		case 3:
			for (int i = 1; i < tokens.length; i++) {
				System.out.println(tokens[i]);
			}
			break;
		case 4:
			for (int i = 1; i < tokens.length; i++) {
				System.out.println(tokens[i]);
			}
			break;
		case 5:
			for (int i = 1; i < tokens.length; i++) {
				System.out.println(tokens[i]);
			}
			break;
		case 6:
			for (int i = 1; i < tokens.length; i++) {
				System.out.println(tokens[i]);
			}
			break;
		case 7:
			for (int i = 1; i < tokens.length; i++) {
				System.out.println(tokens[i]);
			}
			break;
		default:

		}
	}

}
