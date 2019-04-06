package pl.edu.pja.gui.lan;

import pl.edu.pja.gui.lan.zadanie1.Zadanie1;
import pl.edu.pja.gui.lan.zadanie10.Zadanie10;
import pl.edu.pja.gui.lan.zadanie11.Zadanie11;
import pl.edu.pja.gui.lan.zadanie2.Zadanie2;
import pl.edu.pja.gui.lan.zadanie3.Zadanie3;
import pl.edu.pja.gui.lan.zadanie4.Zadanie4;
import pl.edu.pja.gui.lan.zadanie5.Zadanie5;
import pl.edu.pja.gui.lan.zadanie6.Zadanie6;
import pl.edu.pja.gui.lan.zadanie7.Zadanie7;
import pl.edu.pja.gui.lan.zadanie8.Zadanie8;
import pl.edu.pja.gui.lan.zadanie9.Zadanie9;

public class Main {

    public static void main(String[] args) {

        headerZadania(1);
        Zadanie1.run();

        headerZadania(2);
        Zadanie2.run();

        headerZadania(3);
        Zadanie3.run();

        headerZadania(4);
        Zadanie4.run();

        headerZadania(5);
        Zadanie5.run();

        headerZadania(6);
        Zadanie6.run();

        headerZadania(7);
        Zadanie7.run();

        headerZadania(8);
        Zadanie8.run();

        headerZadania(9);
        Zadanie9.run();

        headerZadania(10);
        System.out.println("z abort");
        try {
            Zadanie10.main(new String[]{"abort"});
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        headerZadania(10);
        System.out.println("bez abort");
        try {
            Zadanie10.main(new String[]{});
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void headerZadania(int numer) {
        System.out.println("\n\n");
        System.out.println("---------- ZADANIE " + numer);
        System.out.println("\n\n");
    }
}
