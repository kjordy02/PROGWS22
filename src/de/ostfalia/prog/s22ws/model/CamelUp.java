package de.ostfalia.prog.s22ws.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import de.ostfalia.prog.s22ws.base.Charakter;
import de.ostfalia.prog.s22ws.base.Farbe;
import de.ostfalia.prog.s22ws.base.ICamelUp;

public class CamelUp implements ICamelUp {

    Spielrunde spielrunde = Spielrunde.getInstance();
    Pyramide pyramide = Pyramide.getInstance();
    Spielfeld spielfeld = Spielfeld.getInstance();
    IO io = new Console();
    Random rnd = new Random();

    @Override
    public void startPosition() {

        ArrayList<Farbe> color = new ArrayList<Farbe>();
        for (Farbe f : Farbe.values()) {
            color.add(f);
        }

        for (Farbe f : color) {
            spielfeld.getFeld(0).addKamel(new Kamel(f));
        }

        Collections.shuffle(color);
        for (int i = 0; i < 4; i++) {
            spielfeld.setzeKamel(color.get(i), (int) (Math.random() * 3 + 1));
        }

        ArrayList<Farbe> color = new ArrayList<Farbe>();
        int zufallszahl = (int) (Math.random() * 3 + 1);
        for (Farbe f : Farbe.values()) {
            color.add(f);
        }

    @Override
    public void startPosition(String... positionen) {
        // TODO Auto-generated method stub
        for (Farbe f : Farbe.values()) {
            spielfeld.bewegeKamel(f, 0);
        }
        pyramide.initialisiere(positionen);
        Wuerfel[] arr = pyramide.getwuerfelliste();
        for (int i = 0; i < arr.length; i++) {
            spielfeld.bewegeKamel(arr[i].getFarbe(), arr[i].getAugenzahl());
        }

    }

    @Override
    public void bewegeKamel(Charakter charakter) {
        Wuerfel w = spielrunde.getSpieler(charakter).benutzePyramide(pyramide);
        spielfeld.bewegeKamel(w.getFarbe(), w.getAugenzahl());
        io.bewegeKamel(w.getFarbe(), w.getAugenzahl());

    }

    @Override
    public Farbe fuehrendesKamel() {
        Kamel erster = null;
        for (int i = 0; i < spielfeld.felder.length; i++) {
            if (!(spielfeld.getFeld(i).getKamele().getAnzElemente() == 0)) {
                KamelElement temp = spielfeld.getFeld(i).getKamele().getHead();
                while (temp.hasNext()) {
                    temp = temp.getNext();
                }
                erster = temp.getKamel();
            }
        }
        return erster.getFarbe();
    }

    @Override
    public Farbe zweitplatziertesKamel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Farbe letztesKamel() {
        Kamel letzter = null;
        for (int i = 0; i < spielfeld.felder.length; i++) {
            if (!spielfeld.getFeld(i).getKamele().getHead().equals(null)) {
                letzter = spielfeld.getFeld(i).getKamele().getHead().getKamel();
            }
        }
        return letzter.getFarbe();
    }

    @Override
    public int feldNummer(Farbe farbe) {
        for (int i = 0; i < spielfeld.felder.length; i++) {
            if (!(spielfeld.getFeld(i).getKamele().getHead() == null)) {
                KamelElement temp = spielfeld.getFeld(i).getKamele().getHead();
                while (temp.hasNext()) {
                    if (temp.getKamel().getFarbe().equals(farbe)) {
                        return i;
                    }
                    temp = temp.getNext();
                }
            }
        }
        return 0;
    }

    @Override
	public int feldNummer(Charakter charakter) {
		// TODO Auto-generated method stub
		return 0;
	}

    @Override
    public int stapelPosition(Farbe farbe) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int guthaben(Charakter charakter) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void etappenWette(Charakter charakter, Farbe farbe) {
        // TODO Auto-generated method stub

    }

    @Override
    public void wetteTollesKamel(Charakter charakter, Farbe farbe) {
        // TODO Auto-generated method stub

    }

    @Override
    public void wetteOllesKamel(Charakter charakter, Farbe farbe) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Charakter> spielGewinner() {
        // TODO Auto-generated method stub
        return null;
    }

    public void startPlayer() {
        spielrunde.spielrundeErstellen();

    }

    public void startSpiel() {
        this.startPlayer();
        this.startPosition();
        while (this.feldNummer(this.fuehrendesKamel()) < 16) {
            startRunde();
        }
    }

    public void startRunde() {
        for (Spieler spieler : spielrunde.getTeilnehemer()) {
            io.anDerReihe(spieler);
            Charakter cha = spieler.getCharakter();
            int auswahl = io.giveOptionsAtTurn();
            do {
                switch (auswahl) {
                    case 1:
                        this.bewegeKamel(cha);
                        break;
                    /*
                     * case 2:
                     * this.
                     * break;
                     * case 3:
                     * this.etappenWette(cha, null);
                     * break;
                     * case 4:
                     * this.wetteTollesKamel(cha, null);
                     * break;
                     * case 5:
                     * this.wetteOllesKamel(cha, null);
                     * break;
                     */
                    default:
                        io.falscheEingabe();
                        auswahl = 0;
                        break;
                }
            } while (auswahl == 0);
            auswahl = io.giveOptionsAfterTurn();
            Farbe farbe;
            do {
                switch (auswahl) {
                    case 0:

                    case 1:
                        farbe = this.fuehrendesKamel();
                        io.fuehrendes(farbe);
                        break;
                    case 2:
                        farbe = this.letztesKamel();
                        io.letztes(farbe);
                        break;
                    default:
                        io.falscheEingabe();
                        auswahl = -1;
                        break;
                }
            } while (auswahl == -1);
        }
    }

}
