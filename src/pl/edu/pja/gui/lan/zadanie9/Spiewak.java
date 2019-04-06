package pl.edu.pja.gui.lan.zadanie9;

import java.util.Random;

public class Spiewak extends Thread {

    private static int nextNumerStartowy = 1;
    private final int numerStartowy;
    private char tekst;

    public Spiewak(char tekst) {
        super("Śpiewak " + tekst);
        this.numerStartowy = nextNumerStartowy++;
        this.tekst = tekst;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            Random random = new Random();
            for (int i = 0; i < numerStartowy; i++) {
                System.out.print(random.nextBoolean() ? ("" + tekst).toLowerCase() : ("" + tekst).toUpperCase());
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
