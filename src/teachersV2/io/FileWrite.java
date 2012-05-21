package teachersV2.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import teachersV2.Professor;
import teachersV2.exceptions.EmptyMarks;

public class FileWrite {
	private final String filename;
	private String separator;

	public FileWrite(String filename) throws IOException {
		this.filename = filename;
		separator = ";";
	}

	public void write(String filename) throws FileNotFoundException {

		BufferedWriter writer = null;

		try {

			final FileWriter filewriter = new FileWriter(filename);
			writer = new BufferedWriter(filewriter);

			// When there are still students in the sList.
			while (FileReadService.sList.size() > 0) {

				writer.write("1;" + FileReadService.sList.get(0).getName()
						+ ";" + FileReadService.sList.get(0).getForename()
						+ ";" + FileReadService.sList.get(0).getId());
				writer.write("\n");

				writer.write("2;" + FileReadService.pList.get(0).getName());
				writer.write("\n");

				Iterator<Professor> it = FileReadService.sList.get(0)
						.getGraders().iterator();
				writer.write("3");
				while (it.hasNext()) {
					Professor prof = it.next();
					writer.write(";" + prof.getName() + ";" + prof.getForename());
				}
				writer.write("\n");

				writer.write("4");
				for(int i = 0; i < FileReadService.sList.get(0).getMarks().length; i++) {
					if(FileReadService.sList.get(0).getMarks()[i] == null) {
						writer.write(";");
					} else {
						writer.write( ";" + FileReadService.sList.get(0).getMarks()[i].toString());
					}
				}
				writer.write("\n");
				
				writer.write("5");
				for(int i = 0; i < FileReadService.sList.get(0).getMarks().length; i++) {
					if(FileReadService.sList.get(0).getMarks()[i] == null) {
						writer.write(";");
					} else {
						int index = FileRead.getProfessor(FileReadService.sList.get(0).getMarks()[i].getGrader());
						writer.write( ";" + index);
					}
				}
				writer.write("\n");
				
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

	public String getFilename() {
		return filename;
	}

	public String getSeparator() {
		return separator;
	}

}
