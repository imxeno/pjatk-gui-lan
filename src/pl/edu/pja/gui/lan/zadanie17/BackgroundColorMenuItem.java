package pl.edu.pja.gui.lan.zadanie17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BackgroundColorMenuItem extends JMenuItem {
    public BackgroundColorMenuItem(JTextArea textArea, Color color, String colorName) {
        super(colorName);
        this.setIcon(new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(color);
                g.fillOval(x, y, getIconWidth(), getIconHeight());
            }

            @Override
            public int getIconWidth() {
                return 16;
            }

            @Override
            public int getIconHeight() {
                return 16;
            }
        });
        this.addActionListener((ActionEvent e) -> textArea.setBackground(color));
    }
}
