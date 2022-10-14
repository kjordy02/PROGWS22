package de.ostfalia.prog.s22ws.model;

import de.ostfalia.prog.s22ws.base.Farbe;

public class Pyramide {
	 static Pyramide pyramideInstance;
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

	    public int anzahlWuerfel() {
	        return 0;
	    }

	    public String toString() {
	        String ausgabe = "";
	        for (int i = 0; i < wuerfelliste.length; i++) {
	            ausgabe += wuerfelliste[i] + "\n";
	        }
	        return ausgabe;
	    }
	}

