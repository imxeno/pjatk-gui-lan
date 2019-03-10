package pl.edu.pja.gui.lan.zadanie3;

public class Wiolonczelista extends Muzyk {
    public Wiolonczelista(String imie, double czasWystapienia) {
        super(imie, czasWystapienia);
    }

    @Override
    public String instrument() {
        return "wiolonczela";
    }

    @Override
    public double stawka() {
        return 250.0;
    }
}
