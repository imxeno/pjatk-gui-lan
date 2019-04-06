package pl.edu.pja.gui.lan.zadanie8;

public class Osoba implements Comparable<Osoba> {
    private final String nazwisko;
    private final int wiek;

    public Osoba(String nazwisko, int wiek) {
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    @Override
    public int compareTo(Osoba o) {
        int comparedNazwiska = this.nazwisko.compareTo(o.nazwisko);
        if(comparedNazwiska == 0) return comparedNazwiska;

        return wiek - o.wiek;
    }

    @Override
    public String toString() {
        return this.nazwisko + ", " + this.wiek;
    }
}
