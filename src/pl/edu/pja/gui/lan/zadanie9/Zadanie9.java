package pl.edu.pja.gui.lan.zadanie9;

public class Zadanie9 {
    public static void run() {
        Chor chor = new Chor("ABC");
        for (Thread t : chor.getThreads()) System.out.println(t.getName());
        /*<- tu uruchomić
             wszystkie kody w wątkach
         */

        for (Thread t : chor.getThreads()) t.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*<- tu trzeba zapisać
           fragment, który kończy działanie kodów, wypisujących znaki
        */
        for (Thread t : chor.getThreads()) t.interrupt();

        System.out.println("\nProgram skończył działanie");
    }
}
