package pl.edu.pja.gui.lan.zadanie12;

import javax.swing.*;
import java.awt.*;

public class Zadanie12 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MyPanel p = new MyPanel();
        frame.setContentPane(p);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}