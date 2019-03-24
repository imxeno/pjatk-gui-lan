package pl.edu.pja.gui.lan.zadanie6;

public abstract class Spiewak implements Comparable<Spiewak> {

    private static int nextNumerStartowy = 1;

    private final int numerStartowy;
    private final String nazwisko;

    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        this.numerStartowy = nextNumerStartowy++;
    }

    public abstract String spiewaj();

    public String toString() {
        return "(" + numerStartowy + ") " + nazwisko + ": " + spiewaj();
    }

    public static Spiewak najglosniej(Spiewak[] spiewacy) {

        Spiewak najglosniejszy = null;
        int najglosniej = 0;

        for(Spiewak s : spiewacy) {

            int glosnosc = s.glosnosc();

            if(glosnosc > najglosniej) {
                najglosniej = glosnosc;
                najglosniejszy = s;
            }

        }

        return najglosniejszy;

    }

    @SuppressWarnings("Duplicates")
    public int glosnosc() {
        boolean[] litery = new boolean['z' - 'a'];

        String tekst = this.spiewaj().toLowerCase();

        for(int i = 0; i < tekst.length(); i++) {
            char c = tekst.charAt(i);
            if(c >= 'a' && c <= 'z') {
                litery[c - 'a'] = true;
            }
        }

        int liczba = 0;

        for(boolean b : litery) {
            if(b) liczba++;
        }

        return liczba;
    }

    @Override
    public int compareTo(Spiewak o) {
        int roznicaGlosnosci = o.glosnosc() - this.glosnosc();
        if(roznicaGlosnosci != 0) return roznicaGlosnosci;
        int porzadekAlfabetyczny = this.nazwisko.compareTo(o.nazwisko);
        if(porzadekAlfabetyczny != 0) return porzadekAlfabetyczny;
        return this.numerStartowy - o.numerStartowy;
    }
}
