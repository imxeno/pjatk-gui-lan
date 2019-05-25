package pl.edu.pja.gui.lan.zadanie17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ProstyEdytor extends JFrame {

    private String currentFileName = "bez tytułu";
    private boolean fileLoaded = false;

    private JFileChooser fileChooser;
    private final JTextArea textArea = new JTextArea();

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
                this.setCurrentFileName(fileChooser.getSelectedFile().getPath());
                this.loadFile();
            }
        }));
        fileMenu.add(new FancyMenuItem("Save", KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> {
            if(!fileLoaded)
            {
                if(fileChooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
                    return;

                this.setCurrentFileName(fileChooser.getSelectedFile().getPath());
            }
            this.saveFile();
        }));
        fileMenu.add(new FancyMenuItem("Save as", KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> {
            if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                this.setCurrentFileName(fileChooser.getSelectedFile().getPath());
                this.saveFile();
            }
        }));
        fileMenu.add(new JSeparator());
        fileMenu.add(new FancyMenuItem("Exit", KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> System.exit(0)));
        menuBar.add(fileMenu);

        // Edit Menu

        JMenu editMenu = new JMenu("Edit");
        JMenu adresyMenu = new JMenu("Adresy");
        adresyMenu.add(new AdresMenuItem("Dom", KeyEvent.VK_P, this.textArea, "ul. Domowa 1, 00-000 Warszawa"));
        adresyMenu.add(new AdresMenuItem("Szkoła", KeyEvent.VK_S, this.textArea, "ul. Szkolna 2, 00-001 Warszawa"));
        adresyMenu.add(new AdresMenuItem("Firma", KeyEvent.VK_D, this.textArea, "ul. Firmowa 3, 00-002 Warszawa"));
        editMenu.add(adresyMenu);
        menuBar.add(editMenu);

        // Options Menu

        JMenu optionsMenu = new JMenu("Options");
        JMenu foregroundMenu = new JMenu("Foreground");
        JMenu backgroundMenu = new JMenu("Background");

        @SuppressWarnings("unchecked")
        Pair<String, Color>[] colors = new Pair[]{
                new Pair<>("Blue", Color.BLUE),
                new Pair<>("Yellow", Color.YELLOW),
                new Pair<>("Orange", Color.ORANGE),
                new Pair<>("Red", Color.RED),
                new Pair<>("White", Color.WHITE),
                new Pair<>("Black", Color.BLACK),
                new Pair<>("Green", Color.GREEN)
        };

        for(Pair<String, Color> color : colors) {
            foregroundMenu.add(new ForegroundColorMenuItem(textArea, color.getSecond(), color.getFirst()));
            backgroundMenu.add(new BackgroundColorMenuItem(textArea, color.getSecond(), color.getFirst()));
        }
        optionsMenu.add(foregroundMenu);
        optionsMenu.add(backgroundMenu);

        JMenu fontSizeMenu = new JMenu("Font size");
        for(int i = 8; i < 26; i += 2) {
            fontSizeMenu.add(new FontSizeMenuItem(textArea, i));
        }

        optionsMenu.add(fontSizeMenu);
        menuBar.add(optionsMenu);

        // JTextArea

        textArea.setPreferredSize(new Dimension(600, 400));
        this.add(textArea);

        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void loadFile() {
        try {
            this.textArea.setText(new String(Files.readAllBytes(Paths.get(this.currentFileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile() {
        try {
            Files.write(Paths.get(this.currentFileName), this.textArea.getText().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
