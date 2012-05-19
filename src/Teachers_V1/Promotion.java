package Teachers_V1;

import java.util.ArrayList;
import java.util.Collections;

import Teachers_V1.exceptions.EleveInexistant;

public class Promotion {
	private String name;

	public ArrayList<Eleve> liste;

	public Promotion(String name) {
		this.name = name;
		liste = new ArrayList<Eleve>();
	}

	public Eleve rechercher(int identifiant) throws EleveInexistant {
		Eleve e = null;
		boolean found = false;
		int i = 0;

		while (i < liste.size() && !found) {
			e = liste.get(i);
			if (e.getIdentifiant() == identifiant)
				found = true;
			i++;
		}

		if (!found) {
			throw new EleveInexistant("Pas d'élève avec l'identifiant " + ++i
					+ " dans la collection");
		} else {
			return e;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i;
		sb.append("=======================\n\tPROMOTION\n=======================\n");
		for (i = 0; i < liste.size(); i++) {
			sb.append(liste.get(i));
		}
		return sb.toString();
	}

	public void add(Eleve eleve) {
		liste.add(eleve);
		eleve.setP(this);
	}

	public int sort(int mode) {

		if (this.liste != null) {
			if (mode == 0) { /* If mode = 0; ascending */

				Collections.sort(liste);

			} else if (mode == 1) { /* If mode = 1; descending */

				Collections.sort(liste, Collections.reverseOrder());

			} else {

				return 0;

			}

			return 1;
		}
		return 0;
	}

	public String getName() {
		return name;
	}

}