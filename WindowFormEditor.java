import com.sun.javafx.css.Style;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.text.*;
/**
 * Created by SergioLanda on 8/3/2016.
 */
public class WindowFormEditor extends JFrame{

        private PanelCenter panelCenter;
        private PanelEast panelEast;
        private PanelNorth panelNorth;
        private PanelWest panelWest;
        private PanelSouth panelSouth;


        private int tabCount=0;

        public WindowFormEditor(){
            panelCenter=new PanelCenter();
            panelEast=new PanelEast();
            panelNorth=new PanelNorth();
            panelWest=new PanelWest();
            panelSouth=new PanelSouth();
            setTitle("Principal");
            setBackground(Color.gray);
            setLayout(new BorderLayout());
            panelNorth.createPanelNorth();
            panelWest.createPanelWest();
            panelEast.createPanelEast();
            panelSouth.createPanelSouth();
            panelCenter.createPanelCenter();

            add(panelNorth.panelNorth,BorderLayout.NORTH);
            add(panelWest.panelWest,BorderLayout.WEST);
            add(panelEast.panelEast,BorderLayout.EAST);
            add(panelSouth.panelSouth,BorderLayout.SOUTH);
            add(panelCenter.panelCenter,BorderLayout.CENTER);

            setSize(600,600);
        }
}
