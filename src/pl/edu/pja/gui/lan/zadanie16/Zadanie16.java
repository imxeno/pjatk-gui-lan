package pl.edu.pja.gui.lan.zadanie16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class Zadanie16 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Initial state");
        button.addActionListener(new ActionListener() {

            int nextColorIndex = 0;
            Color[] colors = new Color[] {
                    new Color(255, 0, 0),
                    new Color(0, 255, 0),
                    new Color(0, 0, 255),
                    new Color(0, 255, 255),
                    new Color(255, 0, 255),
                    new Color(255, 255, 0)
            };

            @Override
            public void actionPerformed(ActionEvent e) {
                ((JButton)e.getSource()).setBackground(colors[nextColorIndex]);
                ((JButton)e.getSource()).setText(Integer.toHexString(colors[nextColorIndex].getRGB()).substring(2));
                if(++nextColorIndex >= colors.length) nextColorIndex = 0;
            }
        });

        frame.add(button);
        frame.pack();
        frame.setVisible(true);

    }
}
