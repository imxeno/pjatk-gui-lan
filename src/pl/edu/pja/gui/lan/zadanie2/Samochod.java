package pl.edu.pja.gui.lan.zadanie2;

import java.time.LocalDate;

public class Samochod extends Pojazd {
    protected LocalDate dataOstatniegoPrzegladuOkresowego;
    private LocalDate dataWaznosciOstatniegoUbezpieczenia;

    public Samochod(String marka, String model, int rokProdukcji, LocalDate dataRejestracji,
                    LocalDate dataOstatniegoPrzegladuOkresowego, LocalDate dataWaznosciOstatniegoUbezpieczenia) {
        super(marka, model, rokProdukcji, dataRejestracji);
        this.dataOstatniegoPrzegladuOkresowego = dataOstatniegoPrzegladuOkresowego;
        this.dataWaznosciOstatniegoUbezpieczenia = dataWaznosciOstatniegoUbezpieczenia;
    }

    public boolean isWaznyPrzegladOkresowy() {
        return dataOstatniegoPrzegladuOkresowego.plusDays(365).isAfter(LocalDate.now());
    }

    public LocalDate getDataOstatniegoPrzegladuOkresowego() {
        return dataOstatniegoPrzegladuOkresowego;
    }

    public void setDataOstatniegoPrzegladuOkresowego(LocalDate dataOstatniegoPrzegladuOkresowego) {
        this.dataOstatniegoPrzegladuOkresowego = dataOstatniegoPrzegladuOkresowego;
    }

    public boolean isWazneUbezpieczenie() {
        return dataWaznosciOstatniegoUbezpieczenia.isAfter(LocalDate.now());
    }

    public LocalDate getDataWaznosciOstatniegoUbezpieczenia() {
        return dataWaznosciOstatniegoUbezpieczenia;
    }

    public void setDataWaznosciOstatniegoUbezpieczenia(LocalDate dataWaznosciOstatniegoUbezpieczenia) {
        this.dataWaznosciOstatniegoUbezpieczenia = dataWaznosciOstatniegoUbezpieczenia;
    }

    @Override
    public String toString() {
        return super.toString() + "\n - typ: Samochod\n - data ostatniego przegladu okresowego: "
                + dataOstatniegoPrzegladuOkresowego + "\n - posiada wazny przeglad okresowy: "
                + isWaznyPrzegladOkresowy() + "\n - data waznosci ubezpieczenia: "
                + dataWaznosciOstatniegoUbezpieczenia + "\n - posiada wazne ubezpieczenie: "
                + isWazneUbezpieczenie();
    }
}
