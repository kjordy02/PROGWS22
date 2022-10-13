package de.ostfalia.prog.s22ws.model;

public class Spielfeld {
	
	Feld[] felder = new Feld[16];
	
	Spielfeld() {
		for (int i = 0; i < felder.length; i++) {
			felder[i] = new Feld(i+1);
		}
	}

}
