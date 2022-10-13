package de.ostfalia.prog.s22ws.model;

import java.util.ArrayList;

/**
 * @author kjord
 *
 */
public class Spielrunde {

	private IO io = new Console();
	private ArrayList<Spieler> teilnehmer = new ArrayList<Spieler>();

	public Spielrunde() {
		super();
	}

	public ArrayList<Spieler> getTeilnehemer() {
		return teilnehmer;
	}

	public void addSpieler(Spieler spieler) {
		teilnehmer.add(spieler);
	}

	public Spieler getSpieler(int i) {
		return teilnehmer.get(i);
	}

	public void spielrundeErstellen() {
		Spieler[] spieler = io.spielerEinlesen();
		for (Spieler person : spieler) {
			this.addSpieler(person);
		}

	}
}