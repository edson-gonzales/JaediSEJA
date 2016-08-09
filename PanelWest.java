package Classes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SergioLanda on 8/3/2016.
 */
public class PanelWest {
    public JPanel panelWest;
    public JTree treeWest;
    private PanelCenter panelCenter;
    public PanelWest(PanelCenter panelCenter){
        this.panelCenter=panelCenter;
    }
    public void createPanelWest(){
        panelWest=new JPanel();
        panelWest.setLayout(new FlowLayout());
        createTreeWest();
        panelWest.add(treeWest);
    }
    public void createTreeWest(){
        treeWest=new TreeWestSelectionListener(panelCenter);
    }
}