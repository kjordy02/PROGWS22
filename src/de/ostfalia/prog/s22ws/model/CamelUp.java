package de.ostfalia.prog.s22ws.model;

import java.util.List;

import de.ostfalia.prog.s22ws.base.Charakter;
import de.ostfalia.prog.s22ws.base.Farbe;
import de.ostfalia.prog.s22ws.base.ICamelUp;

public class CamelUp implements ICamelUp {

	Spielrunde spielrunde = Spielrunde.getInstance();
	Pyramide pyramide = Pyramide.getInstance();
	Spielfeld spielfeld = Spielfeld.getInstance();

	@Override
	public void startPosition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startPosition(String... positionen) {
		for(int i = 0; i < positionen.length; i++) {
			 String[] str = positionen[i].split("\\:");
			 for(Kamel k : KamelList.getList()) {
				 
			 }
			 /* 1) Durch Kamelliste durchgehen & String mit Farbe vergleichen
			  * 2) Vergleichen mit Farbe die reingegeben wurde
			  * 3) Diesem Kamel das Feld zuweisen 
			  * */
			 
		}
		// TODO Auto-generated method stub
		for(Farbe f: Farbe.values()) {
		spielfeld.bewegeKamel(f, 0);
		}
		pyramide.initialisiere(positionen);
		Wuerfel[] arr = pyramide.getwuerfelliste();
		for(int i = 0; i< arr.length; i++) {
			spielfeld.bewegeKamel(arr[i].getFarbe(), arr[i].getAugenzahl());
		}
		
	}

	@Override
	public void bewegeKamel(Charakter charakter) {
		Wuerfel w = spielrunde.getSpieler(charakter).benutzePyramide(pyramide);
		spielfeld.bewegeKamel(w.getFarbe(),w.getAugenzahl());

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
