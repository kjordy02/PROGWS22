package de.ostfalia.prog.s22ws.model;

import java.util.ArrayList;
import java.util.Scanner;

import de.ostfalia.prog.s22ws.base.Charakter;

public class Console implements IO {

	private final Scanner sc = new Scanner(System.in);
	private ArrayList<Charakter> offeneCharaktere = new ArrayList<Charakter>();

	public Console() {
		super();
		for (Charakter cha : Charakter.values()) {
			offeneCharaktere.add(cha);
		}
	}

	@Override
	public Spieler[] spielerEinlesen() {
		System.out.println("Wie viele Spieler spielen mit ?");
		int anzahl = sc.nextInt();
		Spieler[] spieler = new Spieler[anzahl];
		for (int i = 1; i <= anzahl; i++) {
			System.out.println("Wie heißt Spieler " + i + "?");
			String name = sc.next();
			System.out.println(offeneCharaktere.toString());
			System.out.println("Welchen Charakter möchte Spieler " + i + " nemhmen ?");
			int f = sc.nextInt();
			Charakter cha = offeneCharaktere.get(f-1);
			offeneCharaktere.remove(cha);
			Spieler person = new Spieler(name, cha);
			spieler[i - 1] = person;
		}

		return spieler;
	}
}
