package Classes;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.io.*;
import java.net.URI;
import java.nio.file.Path;

/**
 * Created by HP-PC on 09/08/2016.
 */
public class TreeWestSelectionListener extends JTree implements TreeSelectionListener {

    private PanelCenter panelCenter;
    private DefaultListModel mldFiles;
    public TreeWestSelectionListener(PanelCenter panelCenter) {
        addTreeSelectionListener(this);
        this.panelCenter = panelCenter;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        // se obtiene el nodo seleccionado
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)this.getLastSelectedPathComponent();
        if(selectedNode == null) return;
        if(selectedNode.isLeaf()){
        File file = new File((String) selectedNode.getUserObject());
//            File[] files = file.listFiles(new FileFilter() {
//                @Override
//                public boolean accept(File pathname) {
//                    return pathname.isFile();
//                }
//            });
            TreePath path=e.getPath();
            Object[] totalpath=  path.getPath();
            //String pathToConcatenate=path.toString().replaceAll("\\]| |\\[|","").replaceAll(",",File.separator);
            StringBuilder sb= new StringBuilder();
//            if (totalpath.length<2){
                for(int i=1;i<totalpath.length;i++){
                    sb.append(File.separatorChar).append(totalpath[i].toString());
                    //pathToConcatenate+="\\"+totalpath[i];
                }
            String pathToConcatenate = sb.toString();
//            }
            FilePath.filesPath+=pathToConcatenate;
//            mldFiles.removeAllElements();
//            if (files !=null)
//            {
//                for (int i=0; i<files.length;i++){
//                    mldFiles.addElement(files[i]);
//                }
//            }
            panelCenter.addTabb(file.getName(),"");
            FileReader reader = null;
            try {
                //System.out.println(file.gets);

                reader = new FileReader(FilePath.filesPath);
                panelCenter.editor.read(reader,null);
                FilePath.filesPath=FilePath.filesAbsolutedPath;
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            }
        //JOptionPane.showMessageDialog(windowFormEditor, nseleccionado.getPath());
    }
}
