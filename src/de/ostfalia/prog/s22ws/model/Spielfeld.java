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
            if (felder[i].getKamele().getKamel(farbe) != null
                    && farbe.equals(felder[i].getKamele().getKamel(farbe).getFarbe())) {
                startFeld = i;
            }
        }
        Kamel kamel = felder[startFeld].getKamele().getKamel(farbe);
        KamelElement kamelElem = felder[startFeld].getKamele().getKamelElement(kamel);
        felder[startFeld + anzFelder].addKamelElement(kamelElem);
        boolean successRemove = felder[startFeld].removeKamel(kamel);
        return successRemove;
    }

    public void setzeKamel(Farbe farbe, int zufallszahl) {

        Kamel kamel = felder[0].getKamele().getKamel(farbe);
        KamelElement kamelElem = felder[0].getKamele().getKamelElement(kamel);
        KamelElement temp = kamelElem.getNext();
        KamelElement davor = felder[0].getKamele().getKamelElementDavor(kamelElem);
        if (davor == null) {
            felder[0].getKamele().setHead(temp);
        } else {
            davor.setNext(temp);
        }
        felder[zufallszahl].addKamel(kamel);
        felder[0].getKamele().decrementAnzahl();

    }

}
