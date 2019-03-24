package pl.edu.pja.gui.lan.zadanie7;

public class Zadanie7 {
    public static void run() {
        IterNap napis = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        // iteracja po znakach napisu,
        // domyślnie zaczynając od pierwszego znaku (o indeksie 0)
        // i z krokiem iteracji = 1
        for (char z: napis)
            System.out.print(z + " ");

        System.out.println();

        napis.ustawPoczatek(2);     // ustawienie początku iteracji (tu: 2-gi znak, o indeksie 2)
        napis.ustawKrok(3);         // ustawienie kroku iteracji (tu: co 3-ci znak)

        // iteracja po znakach napisu,
        // od ustalonego znaku, z określonym krokiem
        for (char z: napis)
            System.out.print(z + " ");


        /*<-  co tu trzeba napisać w wywołaniu metody forEach z argumentem będącym lambda-wyrażeniem
              w celu wyświetlenia znaków napisu (w postaci małych liter) zgodnie z iteracją
        */

        System.out.println("\n");

        napis.forEach((Character c) -> {
            System.out.print(c.toString().toLowerCase() + " ");
        });

        System.out.println();

    }
}
