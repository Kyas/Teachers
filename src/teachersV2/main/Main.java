package teachersV2.main;

import java.io.File;
import java.io.IOException;

import teachersV2.io.FileReader;
import teachersV2.io.FileReaderService;

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
public class Main {
	public static void main(String[] args) {
		File file = new File("src\\teachersV2\\io\\notes.csv");
		FileReaderService fr = new FileReader();
		String path = file.getAbsolutePath();
		try {
			fr.read(path, ";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
