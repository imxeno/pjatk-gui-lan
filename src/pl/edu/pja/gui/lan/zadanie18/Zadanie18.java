package pl.edu.pja.gui.lan.zadanie18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Zadanie18 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Quadratic Equation");
        frame.setLayout(new GridLayout(4, 1));

        JLabel wynik = new JLabel("Enter parameters below.");
        wynik.setOpaque(true);
        wynik.setBackground(Color.WHITE);
        wynik.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(wynik);

        JPanel danePanel = new JPanel();
        danePanel.setLayout(new GridLayout(1, 3));
        JTextField aField = new JTextField();
        aField.setToolTipText("Enter a");
        danePanel.add(aField);
        JTextField bField = new JTextField();
        bField.setToolTipText("Enter b");
        danePanel.add(bField);
        JTextField cField = new JTextField();
        cField.setToolTipText("Enter c");
        danePanel.add(cField);
        frame.add(danePanel);

        JButton solveButton = new JButton("Solve");
        solveButton.setMnemonic('S');
        solveButton.addActionListener((ActionEvent e) -> {

            try {
                double a = Double.parseDouble(aField.getText());
                double b = Integer.valueOf(bField.getText());
                double c = Integer.valueOf(cField.getText());
                if (a == 0) {
                    wynik.setText("Please enter valid value for A parameter.");
                    return;
                }
                Silnik s = new Silnik(a, b, c);
                double[] r = s.rozwiazania();
                if (r.length == 0) {
                    wynik.setBackground(Color.RED);
                    wynik.setForeground(Color.BLACK);
                    wynik.setText("This equation has no real solutions.");
                } else if (r.length == 1) {
                    wynik.setBackground(Color.WHITE);
                    wynik.setForeground(Color.BLUE);
                    wynik.setText("x=" + r[0]);
                } else if (r.length == 2) {
                    wynik.setBackground(Color.WHITE);
                    wynik.setForeground(Color.BLUE);
                    wynik.setText("x1=" + r[0] + ", x2=" + r[1]);
                }
            } catch (NumberFormatException ex) {
                wynik.setBackground(Color.RED);
                wynik.setForeground(Color.BLACK);
                wynik.setText("Number format error!");
            }

        });
        frame.add(solveButton);
        JButton clearButton = new JButton("Clear");
        clearButton.setMnemonic('C');
        clearButton.addActionListener((ActionEvent e) -> {
            wynik.setBackground(Color.WHITE);
            wynik.setForeground(Color.BLACK);
            wynik.setText("Enter parameters below.");
            aField.setText("");
            bField.setText("");
            cField.setText("");
        });
        frame.add(clearButton);

        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
