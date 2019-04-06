package pl.edu.pja.gui.lan.zadanie11;

public class Buffer {
    private int[] array;
    private int nextPointer;

    public Buffer(int size) {
        array = new int[size];
    }

    public int get() {
        int ret = array[0];
        for (int i = 1; i < nextPointer; i++) {
            array[i - 1] = array[i];
        }
        nextPointer--;
        return ret;
    }

    public void put(int i) {
        array[nextPointer++] = i;
    }

    public boolean isEmpty() {
        return nextPointer == 0;
    }

    public boolean isFull() {
        return nextPointer == array.length;
    }
}
