/**
 * MainInteract.java
 * 
 * Copyright 2012 
 * 
 * This file is part of the Java Project : Teachers.
 * 
 * Teachers is free software: you can redistribute it and/or modify
 * it under the terms of the zlib license. See the COPYING file.
 * 
 * @author Jérémy LOR <jlor@etudiant.univ-mlv.fr>
 * @author Thomas LEROUX <tleroux@etudiant.univ-mlv.fr>
 */

package Teachers_V1.main;

import java.util.Scanner;

public class MainInteract {

	public static void main(String[] args) {

		while (true) { // When we don't want to quit the program now.
			System.out.println(Interact.menu());
			int res = -1;
			
			while (res < 0 || res > 9) {
				Scanner sc = new Scanner(System.in);
				res = sc.nextInt();
			}

			switch (res) {
			case 0:
				Interact.createStudent();
				break;
			case 1:
				Interact.createProfessor();
				break;
			case 2:
				Interact.addStudent();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				System.out.println("End of the Program.");
				System.exit(0);
				break;
			default:
				break;
			}

		}
	}

}
