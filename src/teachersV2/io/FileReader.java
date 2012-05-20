package teachersV2.io;

import java.util.ArrayList;

import teachersV2.Professor;
import teachersV2.Promotion;
import teachersV2.Student;
import teachersV2.core.Core;

/**
 * Contains the implementation for reading lines in the File - Version 2<br />
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
public class FileReader extends FileReaderService {

	/*
	 * The temporary attribute for the student.
	 */
	public static Student student = null;

	/*
	 * The temporary attribute for the student.
	 */
	public static Professor professor = null;

	/*
	 * The temporary attribute for the Promotion.
	 */
	public static Promotion promotion = null;
	
	/*
	 * The Real List for all files which contains all professors.
	 */
	public static ArrayList<Professor> profListFiles = new ArrayList<Professor>();

	/*
	 * The temporary attribute for the number of student read. It's a kind of an
	 * incrementation for the student added.
	 */
	public static int numberOfStudent = 0;

	public static int addProfessorEachFile(Professor prof) {
		if(prof == null) return 0;
		for(int i = 0; i < profListFiles.size(); i++) {
			if(profListFiles.get(i).equals(prof)) {
				return 0;
			}
		}
		profListFiles.add(prof);
		return 1;
	}
	
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
			Student s = new Student(tokens[1], tokens[2],
					Integer.valueOf(tokens[3]));
			Core.addStudent(s);
			student = s;
			break;
		case 2:
			Promotion p = new Promotion(tokens[1]);
			// /!\ If the promotion exists, we add the student is the
			// existent Promotion !

			// If the promotion doesn't exist
			if (Core.addPromotion(p) == p) {
				p.add(student);
				// If the promotion exists
				// We use the return of the method addPromotion (to select
				// the good promotion in the list)
				// to call the method p.add(student)
			} else {
				Core.addPromotion(p).add(student);
			}
			promotion = p;
			break;
		case 3:
			int i = 1;
			while (i != tokens.length) {
				Professor prof = new Professor(tokens[i], tokens[i + 1]);

				Core.addProfessors(prof);
				addProfessorEachFile(prof);
				
				i = i + 2;
				professor = prof;
			}
			break;
		case 4:
			Core.initMarks();
			int iMarks;
			for (iMarks = 1; iMarks < tokens.length; iMarks++) {
				if (!tokens[iMarks].equals("")) {
					Core.addMarks(iMarks - 1, tokens[iMarks]);
				}
			}
			break;
		case 5:
			int iProf;
			for (iProf = 1; iProf < tokens.length; iProf++) {
				if (!tokens[iProf].equals("")) {
					// This line can be difficult to see but it's the call
					// of the method
					// Promotion.setNote(Promotion p, int id, float value,
					// int index);

					// Promotion :
					// Read.profList.get(Integer.valueOf(tokens[iProf]))
					// Promotion p :
					// Read.pList.get(Read.getIndexPromotion(promotion))
					// int id : student.getId()
					// float value : Float.valueOf(Read.marks[iProf-1])
					// int index : iProf - 1
					FileReaderService.profList.get(Integer.valueOf(tokens[iProf])).setNote(
							FileReaderService.pList.get(Core.getIndexPromotion(promotion)),
							student.getId(),
							Float.valueOf(Core.marks[iProf - 1]), iProf - 1);
				}
			}
			break;
		default:
			break;
		}

	}
}
