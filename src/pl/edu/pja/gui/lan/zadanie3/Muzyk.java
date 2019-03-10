package pl.edu.pja.gui.lan.zadanie3;

public abstract class Muzyk {
    protected final String imie;
    protected final double czasWystapienia;

    public Muzyk(String imie, double czasWystapienia) {
        this.imie = imie;
        this.czasWystapienia = czasWystapienia;
    }

    public static Muzyk maxHonorarium(Muzyk[] muzycy) {
        Muzyk max = muzycy[0];
        for(Muzyk m : muzycy) {
            if(m.stawka() * m.czas() > max.stawka() * max.czas()) {
                max = m;
            }
        }
        return max;
    }

    public String toString() {
        return imie() + ", czas = " + czas() + " godz., stawka = " + stawka();
    }

    public String imie() {
        return imie;
    }

    public double czas() {
        return czasWystapienia;
    }

    public abstract String instrument();
    public abstract double stawka();

}
