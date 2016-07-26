package jEditor;

import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by JimmyRomero on 7/21/2016.
 */
public class MenuEditor extends JMenu {

    public JMenu fileMenu;
    private JMenuItem newFile, openFile, saveAsFile, exit;

    public JMenu editMenu;
    private JMenuItem undoEdit, redoEdit, selectAll, copy, paste, cut;

    public MenuEditor()
    {
        super();
    }

    public void fileMenu() {
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
                //openingFiles(file);
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
                            //saveFile(filename);
                        }
                    } else {
                        //saveFile(filename);
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

    public void editMenu() {
        editMenu = new JMenu("Edit");
        editMenu.setPreferredSize(new Dimension(40, 20));

        // Add file menu items
        undoEdit = new JMenuItem("Undo");
        undoEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                   //undo.undo();
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
                    //undo.redo();
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
                //textArea.selectAll();
            }
        });
        selectAll.setPreferredSize(new Dimension(100, 20));
        selectAll.setEnabled(true);

        copy = new JMenuItem("Copy");
        copy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //textArea.copy();
            }
        });
        copy.setPreferredSize(new Dimension(100, 20));
        copy.setEnabled(true);

        cut = new JMenuItem("Cut");
        cut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //textArea.cut();
            }
        });
        cut.setPreferredSize(new Dimension(100, 20));
        cut.setEnabled(true);

        paste = new JMenuItem("Paste");
        paste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //textArea.paste();
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
}