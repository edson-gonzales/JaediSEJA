package Classes;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by HP-PC on 09/08/2016.
 */
public class ActionListenerOpenProject implements ActionListener {
    private JTree treeWest;
    private JFrame windowFormEditor;
    private PanelCenter panelCenter;

    public ActionListenerOpenProject(JTree treeWest, JFrame windowFromEditor, PanelCenter panelCenter) {
        this.treeWest = treeWest;
        this.windowFormEditor = windowFromEditor;
        this.panelCenter = panelCenter;
    }



    @Override
    public void actionPerformed(ActionEvent arg0) {

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(windowFormEditor) !=
                JFileChooser.APPROVE_OPTION)
            return;
        File file = chooser.getSelectedFile();
        DefaultTreeModel arbol = (DefaultTreeModel) treeWest.getModel();
        DefaultMutableTreeNode nroot = new DefaultMutableTreeNode(
                file.getName());
        FilePath.filesPath=file.getAbsolutePath();
        FilePath.filesAbsolutedPath=file.getAbsolutePath();
        arbol.setRoot(nroot);
        if (file != null)
            CargaEstructuraDirectorios(arbol, nroot, file.getPath());
            return;




    }

    private void CargaEstructuraDirectorios(DefaultTreeModel arbol,
                                            DefaultMutableTreeNode padre, String ruta) {
        DefaultMutableTreeNode aux = null;

        File archivo = new File(ruta); // puntero al directorio de la ruta
        File[] archivos = archivo.listFiles(); // lista todos los archivos de la ruta

        // recorre lo que hay en la ruta
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {

                // creando un nodo con cada cosa del directorio
                aux = new DefaultMutableTreeNode(archivos[i].getName());
                // inserta el nodo hijo 
                arbol.insertNodeInto(aux, padre, i);

                // si encontramos un directorio volvemos a hacer lo mismo con sus hijos
                if (archivos[i].isDirectory()) {
                    try {

                        // llamando recursivamente de nuevo a ésta misma función
                        CargaEstructuraDirectorios(arbol, aux,
                                archivos[i].getAbsolutePath() + "/");

                    } catch (Exception e) {
                        System.out.println(e.getMessage()); // por si acaso le he puesto un try xD
                    }
                }

            }

        }
    }

}
