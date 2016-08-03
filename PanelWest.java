import javax.swing.*;

/**
 * Created by SergioLanda on 8/3/2016.
 */
public class PanelWest {
    private PanelCenter panelCenter;
    public JPanel panelWest;
    private JTree treeWest;

    public void createPanelWest(){


        panelWest=new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest,BoxLayout.Y_AXIS));
        createTreeWest();
        panelWest.add(treeWest);
    }
    public void createTreeWest(){
        treeWest=new JTree();
    }
}
