package pl.edu.pja.gui.lan;

import pl.edu.pja.gui.lan.zadanie1.Zadanie1;
import pl.edu.pja.gui.lan.zadanie10.Zadanie10;
import pl.edu.pja.gui.lan.zadanie11.Zadanie11;
import pl.edu.pja.gui.lan.zadanie12.Zadanie12;
import pl.edu.pja.gui.lan.zadanie13.Zadanie13;
import pl.edu.pja.gui.lan.zadanie14.Zadanie14;
import pl.edu.pja.gui.lan.zadanie15.Zadanie15;
import pl.edu.pja.gui.lan.zadanie16.Zadanie16;
import pl.edu.pja.gui.lan.zadanie2.Zadanie2;
import pl.edu.pja.gui.lan.zadanie3.Zadanie3;
import pl.edu.pja.gui.lan.zadanie4.Zadanie4;
import pl.edu.pja.gui.lan.zadanie5.Zadanie5;
import pl.edu.pja.gui.lan.zadanie6.Zadanie6;
import pl.edu.pja.gui.lan.zadanie7.Zadanie7;
import pl.edu.pja.gui.lan.zadanie8.Zadanie8;
import pl.edu.pja.gui.lan.zadanie9.Zadanie9;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Class> zadania = new HashMap<>();
        zadania.put(1, Zadanie1.class);
        zadania.put(2, Zadanie2.class);
        zadania.put(3, Zadanie3.class);
        zadania.put(4, Zadanie4.class);
        zadania.put(5, Zadanie5.class);
        zadania.put(6, Zadanie6.class);
        zadania.put(7, Zadanie7.class);
        zadania.put(8, Zadanie8.class);
        zadania.put(9, Zadanie9.class);
        zadania.put(10, Zadanie10.class);
        zadania.put(11, Zadanie11.class);
        zadania.put(12, Zadanie12.class);
        zadania.put(13, Zadanie13.class);
        zadania.put(14, Zadanie14.class);
        zadania.put(15, Zadanie15.class);
        zadania.put(16, Zadanie16.class);

        System.out.println("Lista zadań:\n");

        for(Integer key : zadania.keySet()) {
            System.out.println("Zadanie " + key + " (" + zadania.get(key).getName() + ")");
        }

        System.out.println();

        int zadanie = 0;
        while(true) {
            try {
                Scanner s = new Scanner(System.in);
                System.out.print("Wybierz: ");
                zadanie = s.nextInt();
                if (zadania.containsKey(zadanie)) break;
                System.out.println("Bledny numer zadania!");
            } catch (InputMismatchException e) {
                System.out.println("Bledny numer zadania!");
            }
        }

        System.out.println("\nStartuje zadanie: " + zadania.get(zadanie).getName() + "\n");

        try {
            Method mainMethod = zadania.get(zadanie).getMethod("main", String[].class);
            mainMethod.invoke(null, new Object[] { new String[]{} });
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        /*headerZadania(1);
        Zadanie1.main(new String[]{});

        headerZadania(2);
        Zadanie2.main(new String[]{});

        headerZadania(3);
        Zadanie3.main(new String[]{});

        headerZadania(4);
        Zadanie4.main(new String[]{});

        headerZadania(5);
        Zadanie5.main(new String[]{});

        headerZadania(6);
        Zadanie6.main(new String[]{});

        headerZadania(7);
        Zadanie7.main(new String[]{});

        headerZadania(8);
        Zadanie8.main(new String[]{});

        headerZadania(9);
        Zadanie9.main(new String[]{});

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

        headerZadania(11);
        Zadanie11.main(new String[]{});*/

    }

    public static void headerZadania(int numer) {
        System.out.println("\n\n");
        System.out.println("---------- ZADANIE " + numer);
        System.out.println("\n\n");
    }
}
