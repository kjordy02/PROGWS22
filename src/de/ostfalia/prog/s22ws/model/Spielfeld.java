package de.ostfalia.prog.s22ws.model;

import de.ostfalia.prog.s22ws.base.Farbe;

public class Spielfeld {

	private static Spielfeld spielfeldInstance;
	Feld[] felder = new Feld[17];

	private Spielfeld() {
		for (int i = 0; i < felder.length; i++) {
			felder[i] = new Feld(i);
		}
		spielfeldInstance = this;
	}

	public Feld getFeld(int i) {
		return felder[i];
	}

	public static Spielfeld getInstance() {
		if (spielfeldInstance == null) {
			spielfeldInstance = new Spielfeld();
		}

		return spielfeldInstance;

	}

	public boolean bewegeKamel(Farbe farbe, int anzFelder) {
		int startFeld = 0;
		for (int i = 0; i < felder.length; i++) {
			if (farbe.equals(felder[i].getKamele().getKamel(farbe).getFarbe())) {
				startFeld = i;
			}
		}
		Kamel kamel = felder[startFeld].getKamele().getKamel(farbe);
		felder[startFeld + anzFelder].addKamel(kamel);
		boolean successRemove = felder[startFeld].removeKamel(kamel);
		return successRemove;
	}

}
