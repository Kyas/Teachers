package Teachers_V1;

import java.util.HashSet;
import java.util.Set;

import Teachers_V1.exceptions.NotesVides;

public class Eleve extends Personne implements Comparable<Eleve> {
	private Promotion p;
	static final int NB_EVALUATIONS = 10;

	private final Evaluation notes[] = new Evaluation[NB_EVALUATIONS];

	private final int identifiant;

	public Eleve(String nom, String prenom, int identifiant) {
		super(nom, prenom);
		this.identifiant = identifiant;
	}

	public float moyenne() throws NotesVides {
		int nombreNotes = 0;

		float somme = 0;

		int i = 0;
		while (i < 10) {
			if (getNotes()[i] != null) {
				somme += getNotes()[i].getValeur();
				nombreNotes++;
			}
			i++;
		}

		if (nombreNotes == 0) {
			throw new NotesVides(super.toString() + " n'a pas de notes!");

		} else {
			return somme / nombreNotes;
		}
	}

	@Override
	public String toString() {
		int i;
		StringBuilder sb = new StringBuilder();

		if(this.getNotes() != null) {
			try {
				if(moyenne() != 0) {
					sb.append(super.toString());
					sb.append("\n\tPromotion: " + p.getName());
					sb.append("\n\tIdentifiant: ").append(identifiant)
					.append("\n\tNotes: ");
					
					for(i = 0; i < NB_EVALUATIONS; i++) {
						if(this.notes[i] != null) {
							sb.append(notes[i]);
						}
					}
					
					sb.append("\n\tCorrecteur(s): ").append(this.getCorrecteurs());
					sb.append("\n\tMoyenne: ").append(this.moyenne()).append("\n");
				}
			} catch (NotesVides e) {
				System.out.println(super.toString() + " n'a pas de notes !");
			}
		}
		return sb.toString();
	}
	
	public String afficherMoyenne() {
		StringBuilder sb = new StringBuilder();
		
		try {
			if(this.moyenne() != 0) {
				sb.append(super.toString() + ", Moyenne: ").append(this.moyenne());
			}
		} catch (NotesVides e) {
			System.out.println(super.toString() + " n'a pas de notes !");
		}
		
		return sb.toString();
	}

	public Set<Prof> getCorrecteurs() {
		Set<Prof> liste = new HashSet<Prof>();

		for (int i = 0; i < getNotes().length; i++) {
			if (getNotes()[i] != null)
				liste.add(getNotes()[i].getCorrecteur());
		}
		return liste;
	}

	@Override
	public int compareTo(Eleve eleve) {
		float moyenne1 = 0;
		float moyenne2 = 0;

		try {
			moyenne1 = this.moyenne();
			moyenne2 = eleve.moyenne();
		} catch (NotesVides e) {
			e.getMessage();
		}

		if (moyenne1 > moyenne2)
			return 1;
		if (moyenne1 == moyenne2)
			return 0;
		return -1;
	}

	public Evaluation[] getNotes() {
		return notes;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public Promotion getP() {
		return p;
	}

	public void setP(Promotion p) {
		this.p = p;
	}
}