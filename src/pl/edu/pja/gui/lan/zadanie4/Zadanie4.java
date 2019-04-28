package pl.edu.pja.gui.lan.zadanie4;

public class Zadanie4 {
    public static void main(String[] args) {
        Reversible[] revers = new Reversible[]{
                new ReversibleString("Kot2019"),
                new ReversibleInt(2),
                new ReversibleInt(3),
                new ReversibleString("Pies"),
                new ReversibleString("Ala ma kota i psa"),
                new ReversibleInt(10)
        };

        System.out.println("Normalne:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        for (Reversible r : revers) {
            r.reverse();
        }

        System.out.println("Odwrócone:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        System.out.println("Przywrócone i zmienione:");
        for (Reversible r : revers) {
            r.reverse();
            if(r instanceof ReversibleString) {
                System.out.println("Tekst " + r);
            } else {
                System.out.println(10 + Integer.parseInt(r + ""));
            }
        }
    }
}
