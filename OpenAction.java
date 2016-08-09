//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//class OpenAction extends AbstractAction {
//    private JFrame windowFormEditor;
//    private JPanel panelCenter;
//
//    public OpenAction(JFrame mainWindow, JPanel centerPanel) {
//        super("Open", new ImageIcon("icons/open.gif"));
//        this.windowFormEditor = mainWindow;
//        this.panelCenter = panelCenter;
//    }
//
//    // Query user for a filename and attempt to open and read the file into the
//    // text component.
//    public void actionPerformed(ActionEvent ev) {
//        JFileChooser chooser = new JFileChooser();
//        if (chooser.showOpenDialog(windowFormEditor) !=
//                JFileChooser.APPROVE_OPTION)
//            return;
//        File file = chooser.getSelectedFile();
//        if (file == null)
//            return;
//
//        FileReader reader = null;
//        try {
//            reader = new FileReader(file);
//            panelCenter.editor.read(reader, null);
//        }
//        catch (IOException ex) {
//            JOptionPane.showMessageDialog(windowFormEditor,
//                    "File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//        finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException x) {}
//            }
//        }
//    }
//}