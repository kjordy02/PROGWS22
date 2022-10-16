package de.ostfalia.prog.s22ws.model;

import java.util.ArrayList;
import java.util.Scanner;

import de.ostfalia.prog.s22ws.base.Charakter;
import de.ostfalia.prog.s22ws.base.Farbe;

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
			System.out.println("Wie hei�t Spieler " + i + "?");
			String name = sc.next();
			System.out.println(offeneCharaktere.toString());
			System.out.println("Welchen Charakter m�chte Spieler " + i + " nemhmen ?");
			int f = sc.nextInt();
			Charakter cha = offeneCharaktere.get(f-1);
			offeneCharaktere.remove(cha);
			Spieler person = new Spieler(name, cha);
			spieler[i - 1] = person;
		}

		return spieler;
	}

    @Override
    public void anDerReihe(Spieler spieler) {
        System.out.println(spieler.getName() + " ist an der Reihe.");
        
    }

    @Override
    public int giveOptionsAtTurn() {
        System.out.println("Was möchtest du tun?");
        System.out.println("1. Kamel bewegen, 2. Wüstenplättchen legen, 3. Etappensieg wetten, 4. Tolles Kamel wetten 5. Olles Kamel wetten");
        int i = sc.nextInt();
        return i;
    }

    @Override
    public void bewegeKamel(Farbe farbe, int i) {
        System.out.println("Das Kamel mit der Farbe " + farbe.toString() + "ist um " + i + " Felder nach vorne gezogen.");
        
    }

    @Override
    public void falscheEingabe() {
        System.out.println("Du hast eine Falsche Eingabe getätigt.");
        
	}

	@Override
	public int giveOptionsAfterTurn() {
		System.out.println("Was möchtest du tun?");
        System.out.println("1. Führendes Kamel wissen, 2. Letztes Kamel wissen");
        int i = sc.nextInt();
        return i;
	}

	@Override
	public void fuehrendes(Farbe farbe) {
		System.out.println("Das führende kamel hat die Farbe " + farbe.toString());
	}

	@Override
	public void letztes(Farbe farbe) {
		System.out.println("Das letzte kamel hat die Farbe " + farbe.toString());
	}
}
