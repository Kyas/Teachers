package Teachers_V1.main;

import java.util.ArrayList;
import java.util.Scanner;

import Teachers_V1.Professor;
import Teachers_V1.Promotion;
import Teachers_V1.Student;

public class Interact {

	static ArrayList<Student> sList = new ArrayList<Student>();
	static ArrayList<Professor> profList = new ArrayList<Professor>();
	static ArrayList<Promotion> pList = new ArrayList<Promotion>();

	public static String menu() {
		StringBuilder sb = new StringBuilder();

		sb.append("========== MENU ==========\n");
		sb.append("0- Create a student\n");
		sb.append("1- Create a professor\n");
		sb.append("2- Put a student in a Promotion\n");
		sb.append("3- Put marks to a student\n");
		sb.append("4- Display all the students in a Promotion\n");
		sb.append("5- Display a student (name, promotion, marks, graders)\n");
		sb.append("6- Display a student with his name and average\n");
		sb.append("7- Sort students in Ascending Order\n");
		sb.append("8- Sort students in Descending Order\n");
		sb.append("9- Quit the Program");

		return sb.toString();
	}

	public static void createStudent() {
		System.out.println("=== Creation of a student ===");
		Scanner scName = new Scanner(System.in);
		Scanner scId = new Scanner(System.in);
		System.out.print("Give a name: ");
		String name = scName.nextLine();
		System.out.print("Give a first name: ");
		String forename = scName.nextLine();
		System.out.print("Give an id: ");
		int id = scId.nextInt();
		Student student = new Student(name, forename, id);
		System.out.println("Student " + student.displayNames() + " created.");
		sList.add(student);
		System.out.println();
	}

	public static void createProfessor() {
		System.out.println("=== Creation of a professor ===");
		Scanner scName = new Scanner(System.in);
		System.out.print("Give a name: ");
		String name = scName.nextLine();
		System.out.print("Give a first name: ");
		String forename = scName.nextLine();
		Professor prof = new Professor(name, forename);
		System.out.println("Professor " + prof + " created.");
		profList.add(prof);
		System.out.println();
	}

	public static void displayStudentList() {
		int i;
		for (i = 0; i < sList.size(); i++) {
			System.out.print(i + ":" + sList.get(i).displayNames() + " ");
		}
		System.out.println();
	}

	public static Student chooseStudentList(int index) {
		Student s = null;
		try {
		s = sList.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choose a existent student in the list !");
			return null;
		}
		return s;
	}

	public static void displayProfessorList() {
		int i;
		for (i = 0; i < profList.size(); i++) {
			System.out.print(i + ":" + profList.get(i) + " ");
		}
		System.out.println();
	}

	public static void displayPromotionList() {
		int i;
		for (i = 0; i < pList.size(); i++) {
			System.out.print(i + ":" + pList.get(i).getName() + " ");
		}
		System.out.println();
	}

	public static Promotion choosePromotionList(int index) {
		Promotion p = null;
		try {
		p = pList.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Choose a existent Promotion in the list !");
			return null;
		}
		return p;
	}
	
	public static void addStudent() {
		if (sList.isEmpty()) {
			System.out.println("There is no Student !");
		} else {
			System.out
					.println("Create a Promotion (0) or choose an existing one (1) ?");
			int res = -1;

			while (res < 0 || res > 1) {
				Scanner sc = new Scanner(System.in);
				res = sc.nextInt();
			}
			// If we create a new Promotion.
			if (res == 0) {
				Scanner scName = new Scanner(System.in);
				System.out.print("Give a name: ");
				String name = scName.nextLine();
				Promotion pNew = new Promotion(name);
				System.out.println("New Promotion " + pNew.getName()
						+ " created.");
				pList.add(pNew);
				System.out.println("Which student do you want to add in ?");
				displayStudentList();
				Scanner scIndex = new Scanner(System.in);

				Student s = null;
				while (s == null) {
					int i = scIndex.nextInt();
					s = chooseStudentList(i);
				}
				pNew.add(s);
				System.out.println("Student " + s.displayNames()
						+ " added to the Promotion " + pNew.getName());

				// If we choose an existing Promotion.
			} else {
				if (pList.isEmpty()) {
					System.out.println("There is no Promotion !");
				} else {
					System.out.println("Which promotion do you want to add in ?");
					displayPromotionList();
					Scanner scIndexP = new Scanner(System.in);

					Promotion p = null;
					while (p == null) {
						int iP = scIndexP.nextInt();
						p = choosePromotionList(iP);
					}
					
					System.out.println("Which student do you want to add in ?");
					displayStudentList();
					Scanner scIndexS = new Scanner(System.in);

					Student s = null;
					while (s == null) {
						int iS = scIndexS.nextInt();
						s = chooseStudentList(iS);
					}
					
					System.out.println("Student " + s.displayNames()
							+ " added to the Promotion " + p.getName());
				}
			}
		}
	}

}
