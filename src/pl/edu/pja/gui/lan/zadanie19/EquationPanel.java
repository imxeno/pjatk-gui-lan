package pl.edu.pja.gui.lan.zadanie19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationPanel extends JPanel {

    String eq = "0", xmin = "0", xmax = "0", ymin = "0", ymax = "0";
    Point mousePoint = new Point(0, 0);

    public EquationPanel() {
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mousePoint = e.getPoint();
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mousePoint = e.getPoint();
                repaint();
            }
        });
    }

    void update(String xmin, String xmax, String ymin, String ymax, String equation) {
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
        this.eq = equation;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {

            int width = getWidth();
            int height = getHeight();
            int minX = Integer.parseInt(xmin);
            int maxX = Integer.parseInt(xmax);
            int minY = Integer.parseInt(ymin);
            int maxY = Integer.parseInt(ymax);
            int ptY = height / ((int) Point2D.distance(0, minY, 0, maxY));
            int ptX = width / ((int) Point2D.distance(0, minX, 0, maxX));

            // linie

            g.setColor(Color.BLUE);

            if (minY < 0) {
                int y = height - Math.abs(minY) * ptY;
                g.drawLine(0, y, width, y);
            }

            if (minX < 0) {
                int x = Math.abs(minX) * ptX;
                g.drawLine(x, 0, x, height);
            }

            ArrayList<Elem> elems = new ArrayList<>();

            Pattern pattern = Pattern.compile("(-|\\+|)(\\d*)(x|)(\\^\\d+|)");
            Matcher matcher = pattern.matcher(eq);

            while (matcher.find()) {
                if(matcher.group().compareTo("") == 0) continue;
                // Get the group matched using group() method
                int wspolczynnik = matcher.group(2).compareTo("") == 0 ? 1 : Integer.parseInt(matcher.group(2)) * (matcher.group(1).compareTo("-") == 0 ? -1 : 1);
                int potega = matcher.group(3).compareTo("x") == 0 ? 1 : 0;
                if(potega == 1 && matcher.group(4).length() > 1) {
                    potega = Integer.parseInt(matcher.group(4).substring(1));
                }
                elems.add(
                        new Elem(
                                wspolczynnik,
                                potega
                        )
                );
            }
            
            g.setColor(Color.RED);

            double scaleX = Point2D.distance(0, minX, 0, maxX);
            double scaleY = Point2D.distance(0, minY, 0, maxY);
            for(int x = 0; x < width; x++) {
                double scaledVal = getScaledVal(elems, minX, scaleX, minY, scaleY, width, height, x-1);
                double nextScaledVal = getScaledVal(elems, minX, scaleX, minY, scaleY, width, height, x+1);
                g.drawLine(x-1, (int)Math.round(scaledVal), x+1, (int)Math.round(nextScaledVal));
            }

            boolean gotIt = false;
            for(int mouseY = (int)mousePoint.getY() - 5; mouseY < (int)mousePoint.getY() + 5; mouseY++) {
                if(gotIt) break;
                for(int mouseX = (int)mousePoint.getX() - 5; mouseX < (int)mousePoint.getX() + 5; mouseX++) {
                    if(mouseY == getScaledVal(elems, minX, scaleX, minY, scaleY, width, height, mouseX)) {
                        g.setColor(Color.BLACK);
                        if (minY < 0) {
                            int y = height - Math.abs(minY) * ptY;
                            g.drawLine(mouseX, mouseY, mouseX, y);
                            g.drawString(String.format("%.2f", getScaledX(minX, scaleX, mouseX, width)), mouseX + 3, y - 3);
                        }

                        if (minX < 0) {
                            int x = Math.abs(minX) * ptX;
                            g.drawLine(mouseX, mouseY, x, mouseY);
                            g.drawString(String.format("%.2f", getVal(elems, minX, scaleX, mouseX, width)), x + 3, mouseY - 3);
                        }
                        gotIt = true;
                        break;
                    }
                }
            }



        } catch (Exception err) {
            System.out.println(err);
        }
    }

    private static double getScaledX(int minX, double scaleX, int x, int width) {
        return minX + scaleX * (double)x/width;
    }

    private static double getVal(ArrayList<Elem> elems, int minX, double scaleX, int x, int width) {
        double val = 0;
        double scaledX = getScaledX(minX, scaleX, x, width);
        for(Elem e : elems) {
            val += Math.pow(scaledX, e.potega) * e.wspolczynnik;
        }
        return val;
    }

    private static int getScaledVal(ArrayList<Elem> elems, int minX, double scaleX, int minY, double scaleY, int width, int height, int x) {
        double val = getVal(elems, minX, scaleX, x, width);
        return (int)(height - (val / scaleY) * height - (Math.abs(minY)/scaleY * height));
    }

    class Elem {
        final int wspolczynnik;
        final int potega;
        public Elem(int wspolczynnik, int potega) {
            this.wspolczynnik = wspolczynnik;
            this.potega = potega;
        }
        public String toString() {
            return this.potega + " " + this.wspolczynnik;
        }
    }
}
