package pl.edu.pja.gui.lan.zadanie17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FontSizeMenuItem extends JMenuItem {
    public FontSizeMenuItem(JTextArea textArea, int pts) {
        super(pts + " pts");
        this.addActionListener((ActionEvent e) -> {
            Font font = textArea.getFont();
            textArea.setFont(font.deriveFont((float)pts));
        });
    }
}
