package de.ostfalia.prog.s22ws.model;

public class Feld {
	
	private int pos;
	private KamelList kamele;
	
	
	public Feld(int pos) {
		super();
		this.pos = pos;
		this.kamele = new KamelList();
	}


	public int getPos() {
		return pos;
	}


	public KamelList getKamele() {
		return kamele;
	}


	public void setKamel(Kamel kamel) {
		kamele.add(kamel);
	}
	
	
	
}
