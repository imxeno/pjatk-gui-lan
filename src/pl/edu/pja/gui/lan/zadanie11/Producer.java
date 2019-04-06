package pl.edu.pja.gui.lan.zadanie11;

public class Producer implements Runnable {
    private final Buffer b;

    public Producer(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (b) {
                    if (b.isFull()) {
                        System.out.println("(P) czekam na miejsce na polce");
                        b.wait();
                        System.out.println("(P) doczekalem sie");
                    }
                    int p = (int) (Math.random() * 1000);
                    b.put(p);
                    System.out.println("(P) dostarczam na polke: " + p);
                    b.notifyAll();
                }
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
