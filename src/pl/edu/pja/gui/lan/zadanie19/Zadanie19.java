package pl.edu.pja.gui.lan.zadanie19;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Zadanie19 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setName("Wykres");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        EquationPanel graphicsPanel = new EquationPanel();
        graphicsPanel.setPreferredSize(new Dimension(300, 300));
        frame.add(graphicsPanel);

        JPanel viewportPanel = new JPanel();
        viewportPanel.setLayout(new GridLayout(1, 4));

        JTextField xmin = new JTextField("-5");
        viewportPanel.add(xmin);
        JTextField xmax = new JTextField("4");
        viewportPanel.add(xmax);
        JTextField ymin = new JTextField("-3");
        viewportPanel.add(ymin);
        JTextField ymax = new JTextField("6");
        viewportPanel.add(ymax);
        frame.add(viewportPanel);

        JTextField equation = new JTextField("2x+1");
        frame.add(equation);

        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePanel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePanel();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePanel();
            }

            void updatePanel() {
                graphicsPanel.update(xmin.getText(), xmax.getText(),
                        ymin.getText(), ymax.getText(), equation.getText());
            }
        };

        xmin.getDocument().addDocumentListener(documentListener);
        xmax.getDocument().addDocumentListener(documentListener);
        ymin.getDocument().addDocumentListener(documentListener);
        ymax.getDocument().addDocumentListener(documentListener);
        equation.getDocument().addDocumentListener(documentListener);

        graphicsPanel.update(xmin.getText(), xmax.getText(),
                ymin.getText(), ymax.getText(), equation.getText());

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
