package teachersV2.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * The service for the class FileWrite - Version 2<br />
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
public class FileWriteService {

	/**
	 * This is the launcher to run the writing.
	 * 
	 * @throws FileNotFoundException
	 *             If the file is not found or has a bad format.
	 */
	public static void runWrite() throws FileNotFoundException {
		if (FileReadService.sList.isEmpty()) {
			System.out.println("There is no Student !");
		} else {
			for (int i = 0; i < FileReadService.sList.size(); i++) {
				try {
					// Error : 2nd line.
					if (FileReadService.sList.get(i).getP().equals(null))
						;
				} catch (NullPointerException e) {
					System.out.println("The student "
							+ FileReadService.sList.get(i).displayNames()
							+ " has no Promotion !");
				}
				// Error : 3rd line.
				if (FileReadService.sList.get(i).getGraders().isEmpty()) {
					System.out.println("The student "
							+ FileReadService.sList.get(i).displayNames()
							+ " has no grader !");
					// Error : 4th line.
				} else if (FileReadService.sList.get(i).getMarks().equals(null)) {
					System.out.println("The student "
							+ FileReadService.sList.get(i).displayNames()
							+ " doesn't have marks !");
				} else {
					System.out.println("Choose the path to save (...\\file.csv) :");

					Scanner sc = new Scanner(System.in);
					String filename = sc.nextLine();

					FileWrite fw = null;
					try {
						fw = new FileWrite(filename);
					} catch (IOException e) {
						e.printStackTrace();
					}
					fw.write(filename);
				}
			}
		}
	}
}
