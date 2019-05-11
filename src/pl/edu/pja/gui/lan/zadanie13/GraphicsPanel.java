package pl.edu.pja.gui.lan.zadanie13;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphicsPanel extends JPanel {

    private final ArrayList<Color> colors = new ArrayList<>();
    private final ArrayList<String> elems;

    public GraphicsPanel(ArrayList<String> elems) {

        this.elems = elems;
        this.setPreferredSize(new Dimension(1000, 1000));

        for(String elem : elems) {
            colors.add(new Color((int)(Math.random() * 0xFFFFFF)));
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Pattern pOkrag = Pattern.compile("^(\\d+) (\\d+) (\\d+)$");
        Pattern pProstokat = Pattern.compile("^(\\d+) (\\d+) (\\d+) (\\d+)$");
        int i = 0;
        for(String line : elems) {
            g.setColor(colors.get(i++));
            Matcher pMatcher = pProstokat.matcher(line);
            if (pMatcher.matches()) {
                int x = Integer.parseInt(pMatcher.group(1)),
                        y = Integer.parseInt(pMatcher.group(2)),
                        z = Integer.parseInt(pMatcher.group(3)),
                        t = Integer.parseInt(pMatcher.group(4));
                g.fillRect(x, y + (t/2), z - x, t - y);
                continue;
            }
            Matcher oMatcher = pOkrag.matcher(line);
            if (oMatcher.matches()) {
                int x = Integer.parseInt(oMatcher.group(1)),
                        y = Integer.parseInt(oMatcher.group(2)),
                        r = Integer.parseInt(oMatcher.group(3));
                g.fillOval(x - r, y + r, 2 * r, 2 * r);
            }
        }
    }
}
