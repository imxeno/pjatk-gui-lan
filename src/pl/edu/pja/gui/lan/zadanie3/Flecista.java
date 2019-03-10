package pl.edu.pja.gui.lan.zadanie3;

public class Flecista extends Muzyk {
    public Flecista(String imie, double czasWystapienia) {
        super(imie, czasWystapienia);
    }

    @Override
    public String instrument() {
        return "flet";
    }

    @Override
    public double stawka() {
        return 300.0;
    }
}
