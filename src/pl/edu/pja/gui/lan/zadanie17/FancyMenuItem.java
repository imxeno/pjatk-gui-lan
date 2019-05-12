package pl.edu.pja.gui.lan.zadanie17;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FancyMenuItem extends JMenuItem {
    public FancyMenuItem(String title, int key, int modifier, ActionListener onPress)
    {
        super(title, key);
        this.setAccelerator(KeyStroke.getKeyStroke(key, modifier, false));
        this.addActionListener(onPress);
    }
}
