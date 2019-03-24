package pl.edu.pja.gui.lan.zadanie6;

import java.util.ArrayList;
import java.util.Comparator;

public class Zadanie6 {
    public static void run() {
        ArrayList<Spiewak> arrayList = new ArrayList<Spiewak>();

        arrayList.add(new Spiewak("Darrey") {

            @Override
            public String spiewaj() {
                return "eeae";
            }
        });

        arrayList.add(new Spiewak("Darrey") {

            @Override
            public String spiewaj() {
                return "bebe";
            }
        });

        arrayList.add(new Spiewak("Houston") {

            @Override
            public String spiewaj() {
                return "a4iBBiii";
            }
        });

        arrayList.add(new Spiewak("Carrey") {

            @Override
            public String spiewaj() {
                return "oaooooooooooo";
            }
        });

        arrayList.add(new Spiewak("Darrey") {

            @Override
            public String spiewaj() {
                return "aAa";
            }
        });

        arrayList.sort(Comparator.naturalOrder());

        arrayList.forEach((Spiewak s) -> {
            System.out.println(s);
        });

    }
}
