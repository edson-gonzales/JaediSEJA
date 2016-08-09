package Classes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SergioLanda on 8/4/2016.
 */
    public class WindowFormEditor extends JFrame {
    private PanelCenter panelCenter;
    private PanelEast panelEast;
    private PanelNorth panelNorth;
    private PanelWest panelWest;
    private PanelSouth panelSouth;
    //private int tabCount=0;

    public WindowFormEditor() throws ClassNotFoundException {
            panelCenter=new PanelCenter();
            panelEast=new PanelEast();

            panelWest=new PanelWest(panelCenter);
            panelSouth=new PanelSouth();
            setTitle("Principal");
            setBackground(Color.gray);
            setLayout(new BorderLayout());

            panelWest.createPanelWest();
            panelEast.createPanelEast();
            panelSouth.createPanelSouth();
            panelCenter.createPanelCenter();

            add(panelWest.panelWest, BorderLayout.WEST);
            add(panelEast.panelEast, BorderLayout.EAST);
            add(panelSouth.panelSouth, BorderLayout.SOUTH);
            add(panelCenter.panelCenter, BorderLayout.CENTER);
            setSize(600, 600);

        panelCenter.addTabb("new++", "public static void main(String[] args){ S}");

        PanelNorth panelNorth=new PanelNorth(panelCenter,panelWest,this);
        panelNorth.makeActionsPretty();

        //add(panelNorth.createTextComponent(), BorderLayout.CENTER);
        setJMenuBar(panelNorth.createMenuBar());
        add(panelNorth.createToolBar(), BorderLayout.NORTH);
        panelNorth.createPanelNorth();
        add(panelNorth.panelNorth, BorderLayout.NORTH);
        }
}


