package de.ostfalia.prog.s22ws.model;

import java.util.ArrayList;
import java.util.Collections;

import de.ostfalia.prog.s22ws.base.Farbe;

public class Pyramide {
    private static Pyramide pyramideInstance;
    private Wuerfel[] wuerfelliste = new Wuerfel[5];

    private Pyramide() {
        pyramideInstance = this;
    }

    public static Pyramide getInstance() {
        if (pyramideInstance == null) {
            pyramideInstance = new Pyramide();
        }

        return pyramideInstance;

    }

    public void initialisiere(String... wuerfel) {
        int augenzahl;
        for (int i = 0; i < wuerfel.length; i++) {
            String[] str = wuerfel[i].split("\\:");
            augenzahl = Integer.parseInt(str[1]);
            for (Farbe f : Farbe.values()) {
                String s = f.toString();
                if (s.equals(str[0])) {
                    wuerfelliste[i] = new Wuerfel(f, augenzahl);
                }
            }
        }
    }

    public void initialisiere() {
        ArrayList<Farbe> color = new ArrayList<Farbe>();
        for (Farbe f : Farbe.values()) {
            color.add(f);
        }
        Collections.shuffle(color);
        for (int i = 0; i < 5; i++) {

            wuerfelliste[i] = new Wuerfel(color.get(i), (int) (Math.random() * 3 + 1));
        }
    }

    public Wuerfel[] getwuerfelliste() {
        return wuerfelliste;
    }

    public String toString() {
        String ausgabe = "";
        for (int i = 0; i < wuerfelliste.length; i++) {
            ausgabe += wuerfelliste[i] + "\n";
        }
        return ausgabe;
    }

    public Wuerfel wuerfelZug() {
        for (int i = 0; i < wuerfelliste.length; i++) {
            if (!(wuerfelliste[i] == null)) {
                Wuerfel temp = wuerfelliste[i];
                wuerfelliste[i] = null;
                return temp;
            }
        }
        return null;

    }

    public boolean checkWuerfel() {
        for (Wuerfel w : wuerfelliste) {
            if (!(w == null)) {
                return false;
            }
        }
            return true;
    }

}
