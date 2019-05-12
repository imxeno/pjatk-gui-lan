package pl.edu.pja.gui.lan.zadanie15;

import javax.swing.*;
import java.awt.*;

public class Zadanie15 {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        String layout = JOptionPane.showInputDialog("Wybierz layout (A-G)").toUpperCase();
        switch(layout) {
            case "A":
                frame.setLayout(new BorderLayout());
                break;
            case "B":
                frame.setLayout(new FlowLayout());
                break;
            case "C":
                frame.setLayout(new FlowLayout(FlowLayout.LEFT));
                break;
            case "D":
                frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
                break;
            case "E":
                frame.setLayout(new GridLayout(1, -1));
                break;
            case "F":
                frame.setLayout(new GridLayout(-1, 1));
                break;
            case "G":
                frame.setLayout(new GridLayout(3, 2));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Błąd - niepoprawny wybór");
                return;
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] buttonCaptions = new String[] {
                "Przycisk 1",
                "P 2",
                "Większy przycisk numer 3",
                "Przycisk 4",
                "P5"
        };

        for(int i = 0; i < buttonCaptions.length; i++) {
            frame.add(new JButton(buttonCaptions[i]));
        }

frame.pack();
        frame.setVisible(true);

    }
}
