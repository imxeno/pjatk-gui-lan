package pl.edu.pja.gui.lan.zadanie17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BackgroundColorMenuItem extends JMenuItem {
    public BackgroundColorMenuItem(JTextArea textArea, Color color, String colorName) {
        super(colorName);
        this.setIcon(new ColorIcon(color));
        this.addActionListener((ActionEvent e) -> textArea.setBackground(color));
    }
}
