package teachersV3.main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teachersV3.io.FileRead;
import teachersV3.io.FileReadService;
import teachersV3.jFreeChart.PieChart;

/**
 * Contains the main to run the program with jFreeChart.<br />
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
public class Main {

	/**
	 * Contains the main for the V3. You have to enter the path of a file to see
	 * charts.
	 * 
	 * @param args
	 *            The list of arguments.
	 */
	public static void main(String[] args) {
		try {
			// Command Line with the name of the file as an argument.
			FileReadService fr = new FileRead();
			for (int i = 0; i < args.length; i++) {
				System.out.println("Reading: " + args[i]);
				String path = args[i];
				fr.read(path, ";");
			}

			/*
			 * We display students' marks.
			 */
			for (int i = 0; i < FileRead.sList.size(); i++) {
				PieChart demo = new PieChart("Student Marks !", FileRead.sList
						.get(i).displayNames(), FileRead.sList.get(i));
				demo.pack();
				demo.setVisible(true);

			}

			/*
			 * We display averages' students in a Promotion.
			 */
			for (int i = 0; i < FileRead.pList.size(); i++) {
				PieChart demo = new PieChart("Average Promotion !",
						FileRead.pList.get(i).getName(), FileRead.pList.get(i));
				demo.pack();
				demo.setVisible(true);
			}

			try {
				System.out.println("Type everything to stop the Program.");
				Scanner sc = new Scanner(System.in);
				int res = sc.nextInt();
				System.out.println(res);
				System.exit(0);
			} catch (NoSuchElementException e) {
				System.out.println("Program Interruption.");
			}

		} catch (IOException e) {
			System.err
					.println("File Not Found !\nAre you sure this is the right file/place ?\n");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Error Columns Found on the file !\nReason: "
					+ e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			System.err
					.println("/!\\ Please, format well your file .csv !\nReason : "
							+ e.getLocalizedMessage() + "\n");
		} catch (NoSuchElementException e) {
			System.err.println("No response found !");
		}
	}

}
