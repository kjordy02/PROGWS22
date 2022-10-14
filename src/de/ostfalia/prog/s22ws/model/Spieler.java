package de.ostfalia.prog.s22ws.model;

import de.ostfalia.prog.s22ws.base.Charakter;

public class Spieler {
	
	private String name;
	private Charakter charakter;
	
	
	public Spieler(String name, Charakter charakter) {
		super();
		this.name = name;
		this.charakter = charakter;
	}


	public String getName() {
		return name;
	}


	public Charakter getCharakter() {
		return charakter;
	}
	
	public void benutzePyramide(Pyramide pyramide) {
		pyramide.wuerfelZug();
	}
}
