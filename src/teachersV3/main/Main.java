package teachersV3.main;

import java.io.IOException;
import java.util.NoSuchElementException;

import teachersV2.io.FileRead;
import teachersV2.io.FileReadService;
import teachersV3.jfreechart.Pie;

public class Main {

	public static void main(String[] args) {

		try {
			// Command Line with the name of the file as an argument.
			FileReadService fr = new FileRead();
			for (int i = 0; i < args.length; i++) {
				System.out.println("Reading: " + args[i]);
				String path = args[i];
				fr.read(path, ";");
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

		Pie demo = new Pie("Student Marks", "Jeremy Lor", 0);
		demo.pack();
		demo.setVisible(true);
		System.exit(0);
	}

}
