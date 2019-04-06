package pl.edu.pja.gui.lan.zadanie8;

public class Zadanie8 {
    public static void run() {
        ArrayBox<Osoba>  bo = new ArrayBox<>(2);

        bo.add(new Osoba("Kowalski", 19));                        // nazwisko = "Kowalki", wiek = 19
        bo.add(new Student("Kowalska", 18, 100));                    // nazwisko, wiek, grupa = 100
        bo.add(new Student("Kowalska", 20, 200));

        Osoba[] to = new Osoba[] {new Osoba("Nowak", 21), new Student("Nowak", 22, 200)};
        bo.addAll(to);

        System.out.println(bo.min());                                           // Student 1: Kowalska, 18, 100

        ArrayBox<Student> bst = new ArrayBox<>(1);
        bst.add(new Student("Nowacka", 24, 100));
        bst.add(new Student("Nowacka", 24, 300));
        bst.add(new Student("Nowacka", 24, 200));

        System.out.println(bst.max());                                          // Student 5: Nowacka, 24, 300

        ArrayBox<Integer> bi = new ArrayBox<>(2);
        Integer[] ti = new Integer[] {Integer.valueOf(1), 2, 3};
        bi.addAll(ti);

        bi.print();                                                                          // 1, 2, 3

        ArrayBox<String> bs = new ArrayBox<>(1);
        String[] ts = new String[] {"cpp", new String("java")};
        bs.addAll(ts);
        bs.swap(0,1);
        bs.print();                                                                         // java, cpp
    }
}
