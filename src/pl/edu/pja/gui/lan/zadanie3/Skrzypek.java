package pl.edu.pja.gui.lan.zadanie3;

public class Skrzypek extends Muzyk {
    public Skrzypek(String imie, double czasWystapienia) {
        super(imie, czasWystapienia);
    }

    @Override
    public String instrument() {
        return "skrzypce";
    }

    @Override
    public double stawka() {
        return 200.0;
    }

}
