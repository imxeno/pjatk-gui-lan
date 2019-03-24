package pl.edu.pja.gui.lan.zadanie7;

import java.util.Iterator;

public class IterNap implements Iterable<Character> {
    private final String text;
    private int start = 0;
    private int step = 1;
    public IterNap(String text) {
        this.text = text;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            private int currentStep = start;
            private int nextStep = step;
            @Override
            public boolean hasNext() {
                return currentStep < text.length();
            }

            @Override
            public Character next() {
                Character c = text.charAt(currentStep);
                currentStep += nextStep;
                return c;
            }
        };
    }

    public void ustawPoczatek(int i) {
        this.start = i;
    }

    public void ustawKrok(int i) {
        this.step = i;
    }
}
