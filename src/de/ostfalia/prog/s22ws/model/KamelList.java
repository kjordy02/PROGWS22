package de.ostfalia.prog.s22ws.model;

import de.ostfalia.prog.s22ws.base.Farbe;

public class KamelList {

    private KamelElement head;
    private int anzElemente;

    public KamelList() {
        super();
        anzElemente = 0;
    }

    public KamelElement getHead() {
        return head;
    }

    public int getAnzElemente() {
        return anzElemente;
    }

    /**
     * f�gt ein Kamel am Ende der Liste hinzu
     * 
     * @param kamel
     */
    public void add(Kamel kamel) {
        if (head == null) {
            this.head = (new KamelElement(kamel));
            anzElemente++;
            return;
        }
        KamelElement temp = head;
        while (temp.hasNext()) {
            temp = temp.getNext();
        }
        temp.setNext(new KamelElement(kamel));
        anzElemente++;
    }

    public void add(KamelElement kamelElement) {
        if (head == null) {
            this.head = kamelElement;
            int zaehler = 1;
            KamelElement pruefer = kamelElement;
            while (pruefer.hasNext()) {
                zaehler++;
                pruefer = pruefer.getNext();
            }
            anzElemente += zaehler;
            return;
        }
        KamelElement temp = head;
        while (temp.hasNext()) {
            temp = temp.getNext();
        }
        temp.setNext(kamelElement);
        int zaehler = 1;
        KamelElement pruefer = kamelElement;
        while (pruefer.hasNext()) {
            zaehler++;
            pruefer = pruefer.getNext();
        }
        anzElemente += zaehler;

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
        anzElemente++;
    }

    /**
     * Pr�ft ob ein Kamel in der Kamelliste ist
     * 
     * @param kamel
     * @return
     */
    public boolean contains(Kamel kamel) {
        KamelElement temp = head;
        if (!(anzElemente == 0)) {
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
        if (temp != null && !(anzElemente == 0)) {
            if (temp.getKamel().getFarbe().equals(farbe)) {
                return temp.getKamel();
            }
            while (temp.hasNext()) {
                temp = temp.getNext();
                if (temp.getKamel().getFarbe().equals(farbe)) {
                    return temp.getKamel();
                }

            }
            return null;

        } else
            return null;
    }

    public KamelElement getKamelElement(Kamel kamel) {

        KamelElement temp = head;
        if (temp != null && !(anzElemente == 0)) {
            if (temp.getKamel().equals(kamel)) {
                return temp;
            }
            while (temp.hasNext()) {
                temp = temp.getNext();
                if (temp.getKamel().equals(kamel)) {
                    return temp;
                }

            }
            return null;

        } else
            return null;
    }

    public boolean remove(Kamel kamel) {
        KamelElement loescher = null;
        KamelElement pruefer;
        int zaehler = 0;
        if (!(anzElemente == 0)) {
            loescher = head;
        } else {
            return false;
        }

        if (!(anzElemente == 1)) {
            pruefer = loescher.getNext();
        } else {
            pruefer = null;
        }

        if (!(loescher.getKamel().equals(kamel))) {
            while (!(pruefer == null) && pruefer.hasNext()) {
                if (pruefer.getKamel().equals(kamel)) {
                    zaehler++;
                    while (pruefer.hasNext()) {
                        zaehler++;
                        pruefer = pruefer.getNext();
                    }
                    loescher.setNext(null);
                    anzElemente -= zaehler;
                    return true;
                }
                loescher = pruefer;
                pruefer = pruefer.getNext();
            }
            return false;
        } else {
            head = null;
            return true;
        }
    }

    public KamelElement getKamelElementDavor(KamelElement kamelElem) {

        KamelElement davor = null;
        KamelElement pruefer;
        if (!(anzElemente == 0)) {
            davor = head;
        } else {
            return null;
        }

        if (!(anzElemente == 1)) {
            pruefer = davor.getNext();
        } else {
            pruefer = null;
        }

        if (!(davor.equals(kamelElem))) {

            while (!(pruefer == null) && pruefer.hasNext()) {
                if (pruefer.equals(kamelElem)) {
                    return davor;
                }
                davor = pruefer;
                pruefer = pruefer.getNext();
            }
            return null;

        } else {
            return null;
        }
    }

    public void setHead(KamelElement kamelElement) {
        this.head = kamelElement;

    }

    public void decrementAnzahl() {
        anzElemente--;

    }
}