package jEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class EditorGUI extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new EditorGUI();
    }
    // FIELDS

    // Menus
    private MenuEditor fileMenuBar;

    // Window
    private JFrame editorWindow;

    // Text Area
    private Border textBorder;
    private JScrollPane scroll;
    private JTextPane textArea;
    private Font textFont;

    // Window
    private JFrame window;

    // Is File Saved/Opened
    private boolean opened = false;
    private boolean saved = false;

    // Record Open File for quick saving
    private File openedFile;

    // Undo manager for managing the storage of the undos
    // so that the can be redone if requested
    private UndoManager undo;

    // CONSTRUCTOR

    public EditorGUI() {
        super("JavaEdit");

        // Create Menus
        fileMenuBar = new MenuEditor();
        fileMenuBar.fileMenu();
        fileMenuBar.editMenu();

        // Create Text Area
        createTextArea();

        // Create Undo Manager for managing undo/redo commands
        undoMan();

        // Create Window
        createEditorWindow();
    }

    private JFrame createEditorWindow() {
        editorWindow = new JFrame("JavaEdit");
        editorWindow.setVisible(true);
        editorWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
        editorWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create Menu Bar
        editorWindow.setJMenuBar(createMenuBar());
        editorWindow.add(scroll, BorderLayout.CENTER);
        editorWindow.pack();
        // Centers application on screen
        editorWindow.setLocationRelativeTo(null);

        return editorWindow;
    }

    public JTextPane createTextArea() {
        textBorder = BorderFactory.createBevelBorder(0, Color.BLACK, Color.BLACK);
        textArea = new JTextPane();
        textArea.setEditable(true);
        textArea.setBorder(BorderFactory.createCompoundBorder(textBorder, BorderFactory.createEmptyBorder(2, 5, 0, 0)));

        textFont = new Font("Verdana", 0, 14);
        textArea.setFont(textFont);

        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        return textArea;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenuBar.fileMenu);
        menuBar.add(fileMenuBar.editMenu);

        return menuBar;
    }

    private UndoManager undoMan() {
        // Listener for undo and redo functions to document
        undo = new UndoManager();
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undo.addEdit(e.getEdit());
            }
        });

        return undo;
    }
    // Method for saving files - Removes duplication of code
    private void saveFile(File filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(textArea.getText());
            writer.close();
            saved = true;
            window.setTitle("JavaText - " + filename.getName());
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    // Method for opening files
    public void openingFiles(File filename) {
        try {
            openedFile = filename;
            FileReader reader = new FileReader(filename);
            textArea.read(reader, null);
            opened = true;
            window.setTitle("JavaEdit - " + filename.getName());
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    // GETTERS AND SETTERS

    public JTextPane getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextPane text) {
        textArea = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}