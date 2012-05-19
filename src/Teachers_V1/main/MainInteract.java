package Teachers_V1.main;

import java.util.Scanner;


public class MainInteract {
	
	public String menu() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("========== MENU ==========\n");
		sb.append("0- Créer un élève\n");
		sb.append("1- Créer un professeur\n");
		sb.append("2- Ranger un élève dans une promotion\n");
		sb.append("3- Mettre des notes à un élève\n");
		sb.append("4- Afficher tous les élèves d'une promotion\n");
		sb.append("5- Afficher un élève (nom, promotion, notes, correcteurs)\n");
		sb.append("6- Afficher un élève avec son nom et sa moyenne\n");
		sb.append("7- Trier les élèves par ordre croissant\n");
		sb.append("8- Trier les élèves par ordre décroissant\n");
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		
		int res = -1;
		Scanner sc = new Scanner(System.in);
		while(res == -1) {
			sc = new Scanner(System.in);
		}
		
		res = sc.nextInt();
		
//		switch(sc) {
//			
//		}
		
	}
}

