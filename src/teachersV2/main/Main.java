package teachersV2.main;

import java.io.IOException;

import teachersV2.io.FileReader;
import teachersV2.io.FileReaderService;


public class Main {
	public static void main(String[] args) {
		FileReaderService fr = new FileReader();
		try {
			fr.read("C:\\Users\\Jeremy\\Desktop\\INGE2K - IR1\\Java\\workspace\\Teachers\\src\\teachersV2\\io\\notes.csv", ";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
