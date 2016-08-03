import javax.swing.*;

/**
 * Created by SergioLanda on 8/3/2016.
 */
public class PanelEast {
    public JPanel panelEast;
    private JTree treeEast;

    private int tabCount=0;

    public void createPanelEast(){
        panelEast=new JPanel();
        panelEast.setLayout(new BoxLayout(panelEast,BoxLayout.Y_AXIS));
        createTreeEast();
        panelEast.add(treeEast);
    }
    public void createTreeEast(){
        treeEast=new JTree();
    }
}
