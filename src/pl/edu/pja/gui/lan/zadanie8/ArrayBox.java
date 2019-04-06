package pl.edu.pja.gui.lan.zadanie8;

import java.lang.reflect.Array;

public class ArrayBox<T extends Comparable<? super T>> {
    private int size;
    private T[] array;

    public ArrayBox(int size) {
        this.size = size;
        this.resize(size);
    }

    public boolean add(T elem) {
        boolean added = false;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == elem) return false;
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] == null) {
                array[i] = elem;
                added = true;
                break;
            }
        }
        if(!added) {
            this.resize(size + 1);
            this.array[this.size - 1] = elem;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        int oldSize = this.size;
        this.size = newSize;
        T[] newArray = (T[])Array.newInstance(Comparable.class, this.size);

        if(this.array != null) {

            for (int i = 0; i < oldSize; i++) {
                newArray[i] = this.array[i];
            }

        }

        this.array = newArray;

    }

    public boolean addAll(T[] elems) {
        boolean atLeastOneAdded = false;
        for(T elem : elems) {
            if(this.add(elem)) atLeastOneAdded = true;
        }
        return true;
    }

    public boolean delete(T elem) {
        for(int i = 0; i < this.size; i++) {
            if(this.array[i] == elem) {
                this.array[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean swap(int aIndex, int bIndex) {
        if(aIndex >= this.size || bIndex >= this.size) return false;
        T temp = this.array[aIndex];
        this.array[aIndex] = this.array[bIndex];
        this.array[bIndex] = temp;
        return true;
    }

    public T min() {
        if(this.size == 0) return null;
        T min = this.array[0];
        for(int i = 1; i < this.size; i++) {
            if(this.array[i].compareTo(min) < 0) min = this.array[i];
        }
        return min;
    }

    public T max() {
        if(this.size == 0) return null;
        T max = this.array[0];
        for(int i = 1; i < this.size; i++) {
            if(this.array[i].compareTo(max) > 0) max = this.array[i];
        }
        return max;
    }

    public int search(T elem) {
        for(int i = 0; i < this.size; i++) {
            if(this.array[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        boolean skipComma = true;
        for(T elem : this.array) {
            if(elem == null) continue;
            System.out.print((skipComma ? "" : ", ") + elem);
            skipComma = false;
        }
        System.out.println();
    }
}
