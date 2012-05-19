package Teachers_V1;

import Teachers_V1.exceptions.EleveInexistant;

public class Prof extends Personne {

	public Prof(String nom, String prenom) {
		super(nom, prenom);
	}

	public void setNote(Promotion p, int identifiant, float valeur, int index) {
		Eleve corrige = null;
		try {
			corrige = p.rechercher(identifiant);
		} catch (EleveInexistant e) {
			System.out.println("Cet élève est inexistant");
		}
		if (corrige.getNotes()[index] == null)
			corrige.getNotes()[index] = new Evaluation(this, corrige, valeur);
		else {
			corrige.getNotes()[index].setValeur(valeur);
			corrige.getNotes()[index].setCorrecteur(this);
		}
	}

}