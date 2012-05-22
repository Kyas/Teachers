package teachersV2.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import teachersV2.Professor;
import teachersV2.exceptions.EmptyMarks;

/**
 * Contains the implementation for writing lines in the File - Version 2<br />
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
public class FileWrite {

	/*
	 * The name of the file for the save.
	 */
	private final String filename;

	/**
	 * The constructor of the writing.
	 * 
	 * @param filename The name of the file.
	 * @throws IOException
	 */
	public FileWrite(String filename) throws IOException {
		this.filename = filename;
	}

	/**
	 * Contains the implementation of the writing on a new file. The file is
	 * dependant of a list which got all students in memory. We write on the
	 * file while all the students haven't already been deleted in the list.
	 * 
	 * @param filename
	 *            The name of the file to save.
	 * @throws FileNotFoundException
	 *             If the File is not found or contains error in the format.
	 */
	public void write(String filename) throws FileNotFoundException {

		BufferedWriter writer = null;

		try {

			final FileWriter filewriter = new FileWriter(filename);
			writer = new BufferedWriter(filewriter);

			// When there are still students in the sList.
			while (FileReadService.sList.size() > 0) {

				// 1st line : Contains the name, forename and id's student.
				writer.write("1;" + FileReadService.sList.get(0).getName()
						+ ";" + FileReadService.sList.get(0).getForename()
						+ ";" + FileReadService.sList.get(0).getId());
				writer.write("\n");

				// 2nd line : Contains the Promotion's name.
				writer.write("2;"
						+ FileReadService.sList.get(0).getP().getName());
				writer.write("\n");

				// 3rd line : Contains the grader's list of the student.
				Iterator<Professor> it = FileReadService.sList.get(0)
						.getGraders().iterator();
				writer.write("3");
				while (it.hasNext()) {
					Professor prof = it.next();
					writer.write(";" + prof.getName() + ";"
							+ prof.getForename());
				}
				writer.write("\n");

				// 4th line : Contains all the marks of the student.
				// They are indexed depending of the marks' array (Evaluation)
				writer.write("4");
				for (int i = 0; i < FileReadService.sList.get(0).getMarks().length; i++) {
					if (FileReadService.sList.get(0).getMarks()[i] == null) {
						writer.write(";");
					} else {
						writer.write(";"
								+ FileReadService.sList.get(0).getMarks()[i]
										.toString());
					}
				}
				writer.write("\n");

				// 5th line : Contains the index of the graders' list.
				// It's important to know which grader has given the mark.
				// They are dependant on the marks' array for the position.
				writer.write("5");
				for (int i = 0; i < FileReadService.sList.get(0).getMarks().length; i++) {
					if (FileReadService.sList.get(0).getMarks()[i] == null) {
						writer.write(";");
					} else {
						int index = FileRead.getProfessor(FileReadService.sList
								.get(0).getMarks()[i].getGrader());
						writer.write(";" + index);
					}
				}
				writer.write("\n");

				// 6th line : Contains the average's student.
				try {
					writer.write("6;" + FileReadService.sList.get(0).average());
				} catch (EmptyMarks e) {
					e.printStackTrace();
				}

				FileReadService.sList.remove(0);
				writer.write("\n");
			}

			System.out.println("Writing finished\n");

		} catch (IOException e) {
			e.printStackTrace(System.err);
		} finally {

			if (writer != null) {

				try {
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace(System.err);
				}

				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace(System.err);
				}

			}
		}

	}

	/**
	 * Getter for the file.
	 * 
	 * @return The filename.
	 */
	public String getFilename() {
		return filename;
	}

}
