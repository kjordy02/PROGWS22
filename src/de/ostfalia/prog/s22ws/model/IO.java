package de.ostfalia.prog.s22ws.model;

import de.ostfalia.prog.s22ws.base.Farbe;

public interface IO {

	public Spieler[] spielerEinlesen();

    public void anDerReihe(Spieler spieler);

    public int giveOptionsAtTurn();

    public void bewegeKamel(Farbe farbe, int i);

    public void falscheEingabe();

    public int giveOptionsAfterTurn();

    public void fuehrendes(Farbe farbe);

    public void letztes(Farbe farbe);
}
