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
    Random rnd = new Random();

    @Override
    public void startPosition() {

        ArrayList<Farbe> color = new ArrayList<Farbe>();
        int zufallszahl = (int) (Math.random() * 3 + 1);
        for (Farbe f : Farbe.values()) {
            color.add(f);
        }

        Collections.shuffle(color);
        for (int i = 0; i < 4; i++) {
            spielfeld.bewegeKamel(color.get(i), zufallszahl);
        }

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

    }

    @Override
    public Farbe fuehrendesKamel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Farbe zweitplatziertesKamel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Farbe letztesKamel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int feldNummer(Farbe farbe) {
        // TODO Auto-generated method stub
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

}
