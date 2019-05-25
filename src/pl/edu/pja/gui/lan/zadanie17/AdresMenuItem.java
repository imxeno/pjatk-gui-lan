package pl.edu.pja.gui.lan.zadanie17;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AdresMenuItem extends FancyMenuItem {

    public AdresMenuItem(String title, int key, JTextArea textArea, String text) {
        super(title, key, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK, (ActionEvent e) ->
            textArea.insert(text, textArea.getCaretPosition())
        );
    }
}
