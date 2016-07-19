package jEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class EditorGUI extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new EditorGUI();
    }

    //============================================
    // FIELDS
    //============================================

    // Menus
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenuItem newFile, openFile, saveFile, saveAsFile, pageSetup, printFile, exit;
    private JMenuItem undoEdit, redoEdit, selectAll, copy, paste, cut;


    // Window
    private JFrame editorWindow;

    // Text Area
    private Border textBorder;
    private JScrollPane scroll;
    private JTextArea textArea;
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

    //============================================
    // CONSTRUCTOR
    //============================================

    public EditorGUI() {
        super("JavaEdit");

        // Create Menus
        fileMenu();
        editMenu();

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

    private JTextArea createTextArea() {
        textBorder = BorderFactory.createBevelBorder(0, Color.BLACK, Color.BLACK);
        textArea = new JTextArea(30, 50);
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
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

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

    private void fileMenu() {
        // Create File Menu
        fileMenu = new JMenu("File");
        fileMenu.setPreferredSize(new Dimension(40, 20));

        // Add file menu items
        newFile = new JMenuItem("New");
        newFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EditorGUI();
            }
        });

        newFile.setPreferredSize(new Dimension(100, 20));
        newFile.setEnabled(true);

        openFile = new JMenuItem("Open...");
        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser open = new JFileChooser();
                open.showOpenDialog(null);
                File file = open.getSelectedFile();
                openingFiles(file);
            }
        });
        openFile.setPreferredSize(new Dimension(100, 20));
        openFile.setEnabled(true);

        saveAsFile = new JMenuItem("Save As...");
        saveAsFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser saveAs = new JFileChooser();
                    saveAs.showSaveDialog(null);
                    File filename = saveAs.getSelectedFile();
                    int confirmationResult;
                    if (filename.exists()) {
                        confirmationResult = JOptionPane.showConfirmDialog(saveAsFile, "Replace existing file?");
                        if (confirmationResult == JOptionPane.YES_OPTION) {
                            saveFile(filename);
                        }
                    } else {
                        saveFile(filename);
                    }
                } catch (Exception ex) {
                    System.out.println("File saved..");
                }
            }
        });
        saveAsFile.setPreferredSize(new Dimension(100, 20));
        saveAsFile.setEnabled(true);

        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.setPreferredSize(new Dimension(100, 20));
        exit.setEnabled(true);

        // Add items to menu
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(exit);
    }

    private void editMenu() {
        editMenu = new JMenu("Edit");
        editMenu.setPreferredSize(new Dimension(40, 20));

        // Add file menu items
        undoEdit = new JMenuItem("Undo");
        undoEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    undo.undo();
                } catch (CannotUndoException cu) {
                    cu.printStackTrace();
                }
            }
        });
        undoEdit.setPreferredSize(new Dimension(100, 20));
        undoEdit.setEnabled(true);

        redoEdit = new JMenuItem("Redo");
        redoEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    undo.redo();
                } catch (CannotUndoException cur) {
                    cur.printStackTrace();
                }
            }
        });
        redoEdit.setPreferredSize(new Dimension(100, 20));
        redoEdit.setEnabled(true);

        selectAll = new JMenuItem("Select All");
        selectAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.selectAll();
            }
        });
        selectAll.setPreferredSize(new Dimension(100, 20));
        selectAll.setEnabled(true);

        copy = new JMenuItem("Copy");
        copy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        });
        copy.setPreferredSize(new Dimension(100, 20));
        copy.setEnabled(true);

        cut = new JMenuItem("Cut");
        cut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        });
        cut.setPreferredSize(new Dimension(100, 20));
        cut.setEnabled(true);

        paste = new JMenuItem("Paste");
        paste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });
        paste.setPreferredSize(new Dimension(100, 20));
        paste.setEnabled(true);

        // Add items to menu
        editMenu.add(undoEdit);
        editMenu.add(redoEdit);
        editMenu.add(selectAll);
        editMenu.add(copy);
        editMenu.add(cut);
        editMenu.add(paste);
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
    private void openingFiles(File filename) {
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

    //============================================
    // GETTERS AND SETTERS
    //============================================

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea text) {
        textArea = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}