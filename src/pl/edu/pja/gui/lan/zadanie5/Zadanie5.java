package pl.edu.pja.gui.lan.zadanie5;

public class Zadanie5 {
    public static void main(String[] args) {
        Spiewak s1 = new Spiewak("Carrey"){
            @Override
            public String spiewaj() {
                return "oooooooooooo";
            }
        };

        Spiewak s2 = new Spiewak("Houston"){
            @Override
            public String spiewaj() {
                return "a4iBBiii";
            }
        };

        Spiewak s3 = new Spiewak("Madonna"){
            @Override
            public String spiewaj() {
                return "aAa";
            }
        };

        Spiewak sp[] = {s1, s2, s3};

        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}
