package pl.edu.pja.gui.lan.zadanie11;

public class Zadanie11 {
    public static void main(String[] args) {
        Buffer b = new Buffer(1);
        Consumer c = new Consumer(b);
        Producer p = new Producer(b);
        Thread pThread = new Thread(p);
        Thread cThread = new Thread(c);
        System.out.println("Startujemy producera i consumera");
        pThread.start();
        cThread.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pThread.interrupt();
        cThread.interrupt();
        System.out.println("Program zakończony");
    }
}
