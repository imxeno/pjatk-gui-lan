package pl.edu.pja.gui.lan.zadanie21;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class SuperListModel extends AbstractListModel<String> {

    ArrayList<String> lista = new ArrayList<>();

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public String getElementAt(int index) {
        return lista.get(index);
    }

    boolean add(String s) {
        for(String l : lista) {
            if(l.compareTo(s) == 0) return false;
        }
        lista.add(s);
        lista.sort(Comparator.naturalOrder());
        this.fireIntervalAdded(this, 0, getSize());
        return true;
    }

    public void remove(int selectedIndex) {
        lista.remove(selectedIndex);
        this.fireIntervalRemoved(this, 0, getSize());
    }
}
