package pl.edu.pja.gui.lan.zadanie17;

import javax.swing.*;
import java.awt.*;

public class ColorIcon implements Icon {

    private Color color;

    public ColorIcon(Color color) {
        this.color = color;
    }
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
}
