package Classes;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by SergioLanda on 8/4/2016.
 */
public class PanelNorth {

    private JMenuBar bar;
    private JMenu file, edit;
    private JMenuItem jMenuItemNew;
    PanelCenter panelCenter;
    PanelWest panelWest;
    public JPanel panelNorthFirst, panelNorth, panelNorthSecond;
    private JToolBar toolBar;
    private JButton btnPrevius, btnUp, btnNext;
    //private Classes.WindowFormEditor windowFormEditor;

    private JFrame windowFormEditor;
    private Action openAction = new OpenAction();
    private Action saveAction = new SaveAction();
    private JTextPane textComp;
    private Hashtable actionHash = new Hashtable();

    public PanelNorth(PanelCenter panelCenter, PanelWest panelWest, JFrame windowFormEditor){
        this.panelCenter = panelCenter;
        this.panelWest = panelWest;
        this.windowFormEditor=windowFormEditor;
    }
    /**
     * Menu Bar of the window form
     */
    public JMenuBar createMenuBar() {
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        menubar.add(file);
        menubar.add(edit);

        file.add(getOpenAction());
        file.add(getSaveAction());
        file.add(new ExitAction());
        edit.add(panelCenter.editor.getActionMap().get(DefaultEditorKit.cutAction));
        edit.add(panelCenter.editor.getActionMap().get(DefaultEditorKit.copyAction));
        edit.add(panelCenter.editor.getActionMap().get(DefaultEditorKit.pasteAction));
        edit.add(panelCenter.editor.getActionMap().get(DefaultEditorKit.selectAllAction));

        JMenuItem edit_find = new JMenuItem("Find");
        edit.add(edit_find);

        JMenuItem edit_replace = new JMenuItem("Replace");
        edit.add(edit_replace);

        edit_find.addActionListener(new ActionListenerFindReplace(panelCenter.editor));
        edit_replace.addActionListener(new ActionListenerFindReplace(panelCenter.editor));

        JMenuItem open_project = new JMenuItem("Open Project");
        file.add(open_project);

        open_project.addActionListener(new ActionListenerOpenProject(panelWest.treeWest,windowFormEditor,panelCenter));
        return menubar;
    }

    // Subclass can override to use a different open action.
    protected Action getOpenAction() { return openAction; }

    // Subclass can override to use a different save action.
    protected Action getSaveAction() { return saveAction; }
    // Create the JTextComponent subclass.

    protected JTextPane createTextComponent() {
        JTextPane ta = new JTextPane();
        JPanel noWrapPanel = new JPanel(new BorderLayout());
        noWrapPanel.add(ta);
        return ta;
    }

    //INNER CLASSES (I dont know how to oimprove this, help)
    // A simple exit action
    public class ExitAction extends AbstractAction {
        public ExitAction() { super("Exit"); }
        public void actionPerformed(ActionEvent ev) { System.exit(0); }
    }

    class OpenAction extends AbstractAction {
        public OpenAction() {
            super("Open", new ImageIcon("icons/open.gif"));
        }

        // Query user for a filename and attempt to open and read the file into the
        // text component.
        public void actionPerformed(ActionEvent ev) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(windowFormEditor) !=
                    JFileChooser.APPROVE_OPTION)
                return;
            File file = chooser.getSelectedFile();
            if (file == null)
                return;

            FileReader reader = null;
            try {
                reader = new FileReader(file);
                panelCenter.editor.read(reader,null);
            }

            catch (IOException ex) {
                JOptionPane.showMessageDialog(windowFormEditor,
                        "File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException x) {}
                }
            }
        }
    }

    // An action that saves the document to a file
    class SaveAction extends AbstractAction {
        public SaveAction() {
            super("Save", new ImageIcon("icons/save.gif"));
        }

        // Query user for a filename and attempt to open and write the text
        // components content to the file.
        public void actionPerformed(ActionEvent ev) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(windowFormEditor) !=
                    JFileChooser.APPROVE_OPTION)
                return;
            File file = chooser.getSelectedFile();
            if (file == null)
                return;

            FileWriter writer = null;
            try {
                writer = new FileWriter(file);
                panelCenter.editor.write(writer);
            }
            catch (IOException ex) {
                try {
                    JOptionPane.showMessageDialog(new WindowFormEditor(),
                            "File Not Saved", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException x) {}
                }
            }
        }
    }
    ////END INNER CLASSES

    /**
     * Panel container of the two controlers
     */
    public void createPanelNorth() {
        panelNorth = new JPanel();
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
        createPanelNorthFirst();
        createPanelNorthSecond();
        panelNorth.add(panelNorthFirst);
        panelNorth.add(panelNorthSecond);
    }

    /**
     *
     */
    public void createPanelNorthSecond() {
        panelNorthSecond = new JPanel();
        panelNorthSecond.setLayout(new BoxLayout(panelNorthSecond, BoxLayout.Y_AXIS));
        //createToolBar();
        panelNorthSecond.add(createToolBar());
    }

    /**
     *
     */
    public void createPanelNorthFirst() {
        panelNorthFirst = new JPanel();
        panelNorthFirst.setLayout(new BoxLayout(panelNorthFirst, BoxLayout.Y_AXIS));
        //createMenuBar();
        panelNorthFirst.add(createMenuBar());
    }

    /**
     *
     */
    protected JToolBar createToolBar() {
        JToolBar bar = new JToolBar();

        // Add simple actions for opening & saving.
        bar.add(getOpenAction()).setText("");
        bar.add(getSaveAction()).setText("");
        bar.addSeparator();

        // Add cut/copy/paste buttons.
        bar.add(panelCenter.editor.getActionMap().get(DefaultEditorKit.cutAction)).setText("");
        bar.add(panelCenter.editor.getActionMap().get(DefaultEditorKit.copyAction)).setText("");
        bar.add(panelCenter.editor.getActionMap().get(DefaultEditorKit.pasteAction)).setText("");
        return bar;
    }

    // Add icons and friendly names to actions we care about.
    protected void makeActionsPretty() {
        Action a;
        a = panelCenter.editor.getActionMap().get(DefaultEditorKit.cutAction);
        a.putValue(Action.SMALL_ICON, new ImageIcon("icons/cut.gif"));
        a.putValue(Action.NAME, "Cut");

        a = panelCenter.editor.getActionMap().get(DefaultEditorKit.copyAction);
        a.putValue(Action.SMALL_ICON, new ImageIcon("icons/copy.gif"));
        a.putValue(Action.NAME, "Copy");

        a = panelCenter.editor.getActionMap().get(DefaultEditorKit.pasteAction);
        a.putValue(Action.SMALL_ICON, new ImageIcon("icons/paste.gif"));
        a.putValue(Action.NAME, "Paste");

        a = panelCenter.editor.getActionMap().get(DefaultEditorKit.selectAllAction);
        a.putValue(Action.NAME, "Select All");
    }

}
