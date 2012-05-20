package teachersV2.io;

import teachersV2.Professor;
import teachersV2.Promotion;
import teachersV2.Student;
import teachersV2.service.Read;

/**
 * DisplayFileReader.java - Version 2
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
			Student s = new Student(tokens[1], tokens[2], Integer.valueOf(tokens[3]));
			Read.addStudent(s);
			break;
		case 2:
			Promotion p = new Promotion(tokens[1]);
			Read.addPromotion(p);
			break;
		case 3:
			int i = 1;
			while(i != tokens.length) {
					Professor prof = new Professor(tokens[i], tokens[i+1]);
					Read.addProfessors(prof);
					i = i+2;
			}
			break;
		case 4:
			break;
		case 5:
			break;
		default:

		}
	}
}
