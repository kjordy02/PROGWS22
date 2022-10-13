package de.ostfalia.prog.s22ws.model;

public class KamelList {

	KamelElement head;

	public KamelList() {
		super();
	}

	public KamelElement getHead() {
		return head;
	}

	/**
	 * fügt ein Kamel am Ende der Liste hinzu
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
	 * fügt ein Kamel am Anfang der Liste hinzu
	 * 
	 * @param kamel
	 */
	public void addFirst(Kamel kamel) {
		KamelElement temp = head;
		head = new KamelElement(kamel);
		head.setNext(temp);
	}

	/**
	 * Gibt eine KamalListe der Kamele die weiterziehen zurück
	 * 
	 * @param kamel
	 * @return KamelList
	 */
	public KamelList weiterZiehen(Kamel kamel) {

		return null;
	}

	/**
	 * Prüft ob ein Kamel in der Kamelliste ist
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

}