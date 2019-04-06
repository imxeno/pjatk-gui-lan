package pl.edu.pja.gui.lan.zadanie11;

public class Consumer implements Runnable {

    private final Buffer b;

    public Consumer(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (b) {
                    if (b.isEmpty()) {
                        System.out.println("(C) czekam na produkt");
                        b.wait();
                        System.out.println("(C) doczekalem sie!");
                    }
                    System.out.println("(C) zgarniam produkt: " + b.get());
                    b.notifyAll();
                }
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
