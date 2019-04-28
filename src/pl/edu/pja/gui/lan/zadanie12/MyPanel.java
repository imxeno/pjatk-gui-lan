package pl.edu.pja.gui.lan.zadanie12;

import javax.swing.*;
import java.awt.*;

class MyPanel
        extends JPanel {

    // konstruktor
    MyPanel()
    {
        // ustalenie rozmiarĂłw poczÄtkowych
        setPreferredSize(new Dimension(400,400));
    }


    public void paintComponent(Graphics g)
    {
        // musi byÄ jako pierwsza instrukcja
        super.paintComponent(g);

        // pobranie aktualnych rozmiarĂłw
        int width = getWidth();
        int height = getHeight();

        // TU RYSUJEMY!
        // ........
        g.setColor(Color.red);
        g.fillOval(width / 2 - 100, height / 2 - 100, 200, 200);
        g.setColor(Color.white);
        g.fillArc(width / 2 - 84, height / 2 - 84, 168, 168, 0, 180);
        // ........
    }
}