package pl.edu.pja.gui.lan.zadanie13;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphicsPanel extends JPanel {

    private final ArrayList<String> elems;

    public GraphicsPanel(ArrayList<String> elems) {

        this.elems = elems;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        Pattern pOkrag = Pattern.compile("(\\d) (\\d) (\\d)");
        Pattern pProstokat = Pattern.compile("(\\d) (\\d) (\\d) (\\d)");
        for(String line : elems) {
            Matcher pMatcher = pProstokat.matcher(line);
            if (pMatcher.matches()) {
                int x = Integer.parseInt(pMatcher.group(0)),
                        y = Integer.parseInt(pMatcher.group(1)),
                        z = Integer.parseInt(pMatcher.group(2)),
                        t = Integer.parseInt(pMatcher.group(3));
                g.drawRect(x, y, z - x, t - y);
                continue;
            }
            Matcher oMatcher = pOkrag.matcher(line);
            if (oMatcher.matches()) {
                int x = Integer.parseInt(pMatcher.group(0)),
                        y = Integer.parseInt(pMatcher.group(1)),
                        r = Integer.parseInt(pMatcher.group(2));
                g.drawOval(x - r, y - r, 2 * r, 2 * r);
            }
        }
    }
}
