package Teachers_V1.main;

import Teachers_V1.Eleve;
import Teachers_V1.Prof;
import Teachers_V1.Promotion;
import Teachers_V1.exceptions.EleveInexistant;

public class Main {
	public static void main(String[] args) {
		
		Promotion p1 = new Promotion("Promotion des binious");

		/**
		 * Créer 4 élèves et 2 professeurs.
		 */
		Eleve eleve1 = new Eleve("Jean", "Duval", 1);
		Eleve eleve2 = new Eleve("Pierre", "Pons", 2);
		Eleve eleve3 = new Eleve("Paul", "Durand", 3);
		
		Prof prof1 = new Prof("Tournesol", "Soleil");
		Prof prof2 = new Prof("La Menace", "Max");
		
		/**
		 * Ranger les élèves dans leur promotion.
		 */
		p1.add(eleve1);
		p1.add(eleve2);
		p1.add(eleve3);

		/**
		 * Mettre des notes aux élèves.
		 */
		prof1.setNote(p1, 1, 12, 0);
		prof2.setNote(p1, 1, 6, 1);
		prof1.setNote(p1, 1, 15, 7);
		
		prof1.setNote(p1, 2, 8, 0);
		
		prof2.setNote(p1, 3, 5, 0);

		/**
		 * Afficher tous les élèves d'une Promotion.
		 */
		
		try {
			System.out.println(p1.rechercher(1));
			System.out.println(p1.rechercher(2));
			System.out.println(p1.rechercher(3));
			System.out.println(p1.rechercher(4));
		} catch (EleveInexistant e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(eleve1.afficherMoyenne());
		System.out.println(eleve2.afficherMoyenne());
		System.out.println(eleve3.afficherMoyenne());
		
		System.out.println("Tri Croissant :");
		p1.sort(0);
		System.out.println(p1);
		
		System.out.println("Tri Décroissant :");
		p1.sort(1);
		System.out.println(p1);
	}
}

