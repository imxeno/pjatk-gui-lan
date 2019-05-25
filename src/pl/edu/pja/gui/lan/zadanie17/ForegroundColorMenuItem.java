package pl.edu.pja.gui.lan.zadanie17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ForegroundColorMenuItem extends JMenuItem {
    public ForegroundColorMenuItem(JTextArea textArea, Color color, String colorName) {
        super(colorName);
        this.setIcon(new ColorIcon(color));
        this.addActionListener((ActionEvent e) -> textArea.setForeground(color));
    }
}
