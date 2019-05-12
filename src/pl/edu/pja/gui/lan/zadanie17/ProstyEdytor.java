package pl.edu.pja.gui.lan.zadanie17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class ProstyEdytor extends JFrame {

    private String currentFileName = "bez tytułu";
    private boolean fileLoaded = false;

    private JFileChooser fileChooser;

    public ProstyEdytor() {

        this.updateTitle();

        // Open File Chooser

        fileChooser = new JFileChooser(ProstyEdytor.class.getProtectionDomain()
                .getCodeSource().getLocation().getPath()); // cwd
        // JMenuBar

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        // File Menu


        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new FancyMenuItem("Open", KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> {
            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                this.setCurrentFileName(fileChooser.getName());
                this.loadFile();
            }
        }));
        fileMenu.add(new FancyMenuItem("Save", KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> {
            if(!fileLoaded)
            {
                if(fileChooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
                    return;

                this.setCurrentFileName(fileChooser.getName());
            }
            this.saveFile();
        }));
        fileMenu.add(new FancyMenuItem("Save as", KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> {
            if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                this.setCurrentFileName(fileChooser.getName());
                this.saveFile();
            }
        }));
        fileMenu.add(new JSeparator());
        fileMenu.add(new FancyMenuItem("Exit", KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> System.exit(0)));
        menuBar.add(fileMenu);

        // Edit Menu

        JMenu editMenu = new JMenu("Edit");
        JMenu adresyMenu = new JMenu("Adresy");
        adresyMenu.add(new JMenuItem("Dom"));
        adresyMenu.add(new JMenuItem("Szkoła"));
        adresyMenu.add(new JMenuItem("Firma"));
        editMenu.add(adresyMenu);
        menuBar.add(editMenu);

        // Options Menu

        JMenu optionsMenu = new JMenu("Options");
        menuBar.add(optionsMenu);

        // JTextArea

        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(600, 400));
        this.add(textArea);

        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void loadFile() {
    }

    private void saveFile() {
    }

    private void setCurrentFileName(String name) {
        this.currentFileName = name;
        this.fileLoaded = true;
        this.updateTitle();
    }

    private void updateTitle() {
        this.setTitle("Prosty edytor - " + this.currentFileName);
    }
}
