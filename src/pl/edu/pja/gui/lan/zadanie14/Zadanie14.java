package pl.edu.pja.gui.lan.zadanie14;

import javax.swing.*;
import java.awt.*;

public class Zadanie14 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.GREEN);
        textArea.setForeground(Color.RED);
        textArea.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
        textArea.setPreferredSize(new Dimension(100, 100));
        frame.add(textArea);
        frame.pack();
        frame.setVisible(true);
    }
}
