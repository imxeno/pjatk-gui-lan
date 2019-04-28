package pl.edu.pja.gui.lan.zadanie13;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadanie13 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextField fileName = new JTextField();

        fileName.setDropTarget(new DropTarget(){
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = (List<File>) evt
                            .getTransferable().getTransferData(
                                    DataFlavor.javaFileListFlavor);
                    for (File file : droppedFiles) {
                        fileName.setText(file.getAbsolutePath());
                    }
                } catch (UnsupportedFlavorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        fileName.setColumns(32);
        panel.add(fileName);
        JButton loadButton = new JButton();
        loadButton.addActionListener(e -> {
            try {
                FileReader fileReader = new FileReader(fileName.getText());
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                ArrayList<String> elems = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    elems.add(line);
                }
                GraphicsPanel newPanel = new GraphicsPanel(elems);
                frame.setContentPane(newPanel);

                } catch (IOException exc) {
                JOptionPane.showMessageDialog(frame, exc.getMessage());
            }
        });
        loadButton.setText("Załaduj");
        panel.add(loadButton);
        frame.pack();
        frame.setVisible(true);
    }
}
