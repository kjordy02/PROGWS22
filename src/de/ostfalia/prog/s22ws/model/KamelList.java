package de.ostfalia.prog.s22ws.model;

import de.ostfalia.prog.s22ws.base.Farbe;

public class KamelList {

	KamelElement head;

	public KamelList() {
		super();
	}

	public KamelElement getHead() {
		return head;
	}

	/**
	 * f�gt ein Kamel am Ende der Liste hinzu
	 * 
	 * @param kamel
	 */
	public void add(Kamel kamel) {
		if (head.equals(null)) {
			this.head = (new KamelElement(kamel));
		}
		KamelElement temp = head;
		while (temp.hasNext()) {
			temp = temp.getNext();
		}
		temp.setNext(new KamelElement(kamel));
	}

	/**
	 * f�gt ein Kamel am Anfang der Liste hinzu
	 * 
	 * @param kamel
	 */
	public void addFirst(Kamel kamel) {
		KamelElement temp = head;
		head = new KamelElement(kamel);
		head.setNext(temp);
	}

	/**
	 * Pr�ft ob ein Kamel in der Kamelliste ist
	 * 
	 * @param kamel
	 * @return
	 */
	public boolean contains(Kamel kamel) {
		KamelElement temp = head;
		if (!temp.equals(null)) {
			do {
				if (temp.getKamel().equals(kamel)) {
					return true;
				}
				if (temp.hasNext()) {
					temp = temp.getNext();
				}
			} while (temp.hasNext());
			return false;

		} else
			return false;
	}
	
	

	public Kamel getKamel(Farbe farbe) {
		KamelElement temp = head;
		if (!temp.equals(null)) {
			do {
				if (temp.getKamel().getFarbe().equals(farbe)) {
					return temp.getKamel();
				}
				if (temp.hasNext()) {
					temp = temp.getNext();
				}
			} while (temp.hasNext());
			return null;

		} else
			return null;
	}

	public boolean remove(Kamel kamel) {
		KamelElement loescher = head;
		KamelElement pruefer = loescher.hasNext() ? pruefer = loescher.getNext() : null;

		if (!loescher.equals(null)) {
			if (!pruefer.equals(null)) {

				do {
					if (pruefer.getKamel().equals(kamel)) {
						loescher.setNext(null);
						return true;
					}
					if (pruefer.hasNext()) {
						loescher = pruefer;
						pruefer = pruefer.getNext();
					}
				} while (pruefer.hasNext());
				return false;
			} else {
				head = null;
				return true;
			}

		} else
			return false;

	}

}