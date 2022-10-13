package de.ostfalia.prog.s22ws.model;

public class KamelElement {
	
	private KamelElement next;
	private Kamel kamel;

	public KamelElement(Kamel kamel) {
		this.kamel = kamel;
	}

	public KamelElement getNext() {
		return next;
	}

	public void setNext(KamelElement next) {
		this.next = next;
	}

	public Kamel getKamel() {
		return kamel;
	}

	public void setKamel(Kamel kamel) {
		this.kamel = kamel;
	}

	public boolean hasNext() {
		if (!next.equals(null)) {
			return true;
		} else {
		return false;
		}
	}
	
	
}
