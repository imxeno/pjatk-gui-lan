package pl.edu.pja.gui.lan.zadanie5;

public abstract class Spiewak {

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

            boolean[] litery = new boolean['z' - 'a'];

            String tekst = s.spiewaj().toLowerCase();

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

            if(liczba > najglosniej) {
                najglosniej = liczba;
                najglosniejszy = s;
            }

        }

        return najglosniejszy;

    }
}
