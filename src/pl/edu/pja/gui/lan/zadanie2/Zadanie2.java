package pl.edu.pja.gui.lan.zadanie2;

import java.time.LocalDate;

public class Zadanie2 {
    public static void main(String[] args) {
        Taksowka t = new Taksowka("Mercedes-Benz", "C300", 2017,
                LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now());
        System.out.println(t + "\n\nKupujemy ubezpieczenie i taksometr...\n");
        t.setDataWaznosciTaksometru(LocalDate.now().plusDays(10));
        t.setDataWaznosciOstatniegoUbezpieczenia(LocalDate.now().plusDays(365));
        System.out.println(t);

    }
}
