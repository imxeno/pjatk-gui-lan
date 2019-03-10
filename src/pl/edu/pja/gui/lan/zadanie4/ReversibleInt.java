package pl.edu.pja.gui.lan.zadanie4;

public class ReversibleInt implements Reversible {
    private int i;
    public ReversibleInt(int i) {
        this.i = i;
    }

    public Reversible reverse() {
        i = -i;
        return this;
    }

    public String toString() {
        return i + "";
    }
}
