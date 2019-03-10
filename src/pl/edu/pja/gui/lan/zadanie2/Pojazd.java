package pl.edu.pja.gui.lan.zadanie2;

import java.time.LocalDate;

public class Pojazd {
    private final String marka;
    private final String model;
    private final int rokProdukcji;
    private final LocalDate dataRejestracji;

    public Pojazd(String marka, String model, int rokProdukcji, LocalDate dataRejestracji) {
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.dataRejestracji = dataRejestracji;
    }

    @Override
    public String toString() {
        return "Pojazd:\n - marka: " + marka + "\n - model: " + model
                + "\n - rok produkcji: " + rokProdukcji + "\n - data rejestracji: " + dataRejestracji;
    }
}
