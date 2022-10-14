package de.ostfalia.prog.s22ws.model;

import de.ostfalia.prog.s22ws.base.Farbe;

public class Wuerfel {

	private Farbe farbe;
	private int augenzahl;

	public Wuerfel(Farbe farbe, int augenzahl) {
		this.farbe = farbe;
		this.augenzahl = augenzahl;
	}

	@Override
	public String toString() {
		return " farbe=" + farbe + ", augenzahl=" + augenzahl;
	}

	public Farbe getFarbe() {
		return farbe;
	}

	public int getAugenzahl() {
		return augenzahl;
	}

}
