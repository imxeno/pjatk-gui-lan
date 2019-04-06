package pl.edu.pja.gui.lan.zadanie8;

public class Student extends Osoba {
    private static int NASTEPNY_NUMER = 1;
    private final int numerStudenta;
    private final int numerGrupy;

    public Student(String nazwisko, int wiek, int numerGrupy) {
        super(nazwisko, wiek);
        this.numerStudenta = NASTEPNY_NUMER++;
        this.numerGrupy = numerGrupy;
    }

    @Override
    public int compareTo(Osoba o) {
        int superCompare = super.compareTo(o);

        if(superCompare != 0 || !(o instanceof Student)) return superCompare;

        Student s = (Student) o;
        return numerGrupy - s.numerGrupy;
    }

    @Override
    public String toString() {
        return "Student " + numerStudenta + ": " + super.toString() + ", " + numerGrupy;
    }
}
