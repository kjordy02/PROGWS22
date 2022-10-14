package de.ostfalia.prog.s22ws.model;

public class Spielfeld {
	
	Feld[] felder = new Feld[17];
	
	Spielfeld() {
		for (int i = 0; i < felder.length; i++) {
			felder[i] = new Feld(i);
		}
	}
	
	public Feld getFeld(int i) {
		return felder[i];
	}

}
