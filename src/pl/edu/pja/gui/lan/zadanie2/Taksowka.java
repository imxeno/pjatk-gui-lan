package pl.edu.pja.gui.lan.zadanie2;

import java.time.LocalDate;

public class Taksowka extends Samochod {
    private LocalDate dataWaznosciTaksometru;

    public Taksowka(String marka, String model, int rokProdukcji, LocalDate dataRejestracji, LocalDate dataOstatniegoPrzegladuOkresowego, LocalDate dataWaznosciOstatniegoUbezpieczenia, LocalDate dataWaznosciTaksometru) {
        super(marka, model, rokProdukcji, dataRejestracji, dataOstatniegoPrzegladuOkresowego, dataWaznosciOstatniegoUbezpieczenia);
        this.dataWaznosciTaksometru = dataWaznosciTaksometru;
    }

    @Override
    public boolean isWaznyPrzegladOkresowy() {
        return dataOstatniegoPrzegladuOkresowego.plusMonths(6).isAfter(LocalDate.now());
    }

    public boolean isWaznyTaksometr() {
        return dataWaznosciTaksometru.isAfter(LocalDate.now());
    }

    public LocalDate getDataWaznosciTaksometru() {
        return dataWaznosciTaksometru;
    }

    public void setDataWaznosciTaksometru(LocalDate dataWaznosciTaksometru) {
        this.dataWaznosciTaksometru = dataWaznosciTaksometru;
    }

    @Override
    public String toString() {
        return super.toString() + "\n - taksówka\n - data waznosci taksometru: " + dataWaznosciTaksometru
                + "\n - ma wazny taksometr: " + isWaznyTaksometr();
    }
}
