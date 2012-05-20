package teachersV2.main;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teachersV2.io.FileReader;
import teachersV2.io.FileReaderService;
import teachersV2.service.Read;

/**
 * Main.java - Version 2
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
public class MainRead {
	
	public static void main(String[] args) {
		
		File file = new File("src\\teachersV2\\io\\notes.csv");
		FileReaderService fr = new FileReader();
		String path = file.getAbsolutePath();
		
		try {
			fr.read(path, ";");
		} catch (IOException e) {
			System.out.println("Fichier Introuvable !");
		}
		
		try {
			while (true) { // When we don't want to quit the program now.
				System.out.println(Read.menu());
				int res = -1;
				
				while (res < 0 || res > 8) {
					Scanner sc = new Scanner(System.in);
					res = sc.nextInt();
				}
	
				switch (res) {
				case 1:
					Read.displayStudentList();
					break;
				case 2:
					Read.displayProfessorList();
					break;
				case 3:
					Read.displayPromotion();
					break;
//				case 4:
//					InterfaceRead.sortStudentsPromotion(0);
//					break;
//				case 5:
//					InterfaceRead.sortStudentsPromotion(1);
//					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					System.out.println("End of the Program.");
					System.exit(0);
					break;
				default:
					System.out.println("End of the Program.");
					System.exit(0);
					break;
				}
	
			}
		} catch(NoSuchElementException e) {
			System.out.println("Program Interruption.");
		}
	}
}
