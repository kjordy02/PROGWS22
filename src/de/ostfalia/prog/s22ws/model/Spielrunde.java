package de.ostfalia.prog.s22ws.model;

import java.util.ArrayList;

import de.ostfalia.prog.s22ws.base.Charakter;

/**
 * @author kjord
 *
 */
public class Spielrunde {

	private static Spielrunde spielrundeInstance;
	private IO io = new Console();
	private ArrayList<Spieler> teilnehmer = new ArrayList<Spieler>();

	private Spielrunde() {
		super();
		spielrundeInstance = this;
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

	public static Spielrunde getInstance() {
		if (spielrundeInstance == null) {
			spielrundeInstance = new Spielrunde();
		}

		return spielrundeInstance;

	}

	public Spieler getSpieler(Charakter charakter) {

		for (int i = 0; i < teilnehmer.size(); i++) {
			if (teilnehmer.get(i).getCharakter().equals(charakter)) {
				return teilnehmer.get(i);
			}
		}
		return null;

	}
}