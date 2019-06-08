package pl.edu.pja.gui.lan.zadanie20;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class Zadanie20 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle(LocalDate.now().getMonthValue() + "." + LocalDate.now().getYear());
        JScrollPane scrollPane = new JScrollPane();
        JList<String> list = new JList<>(new WlasnyListModel());
        list.setSelectedIndex(LocalDate.now().getDayOfMonth() - 1);
        scrollPane.setViewportView(list);
        scrollPane.setPreferredSize(new Dimension(200, 400));
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
