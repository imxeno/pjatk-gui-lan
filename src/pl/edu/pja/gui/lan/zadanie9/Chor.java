package pl.edu.pja.gui.lan.zadanie9;

import java.util.ArrayList;

public class Chor {
    private String repertuar;
    private ArrayList<Spiewak> spiewacy;

    public Chor(String repertuar) {
        this.spiewacy = new ArrayList<>();
        this.repertuar = repertuar;
        for (int i = 0; i < repertuar.length(); i++) {
            spiewacy.add(new Spiewak(repertuar.charAt(i)));
        }
    }

    public ArrayList<Spiewak> getThreads() {
        return spiewacy;
    }
}
