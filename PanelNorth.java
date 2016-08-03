import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SergioLanda on 8/3/2016.
 */
public class PanelNorth {
    private JMenuBar bar;
    private JMenu file;
    private JMenuItem jMenuItemNew;
    PanelCenter panelCenter;
    public JPanel panelNorthFirst, panelNorth, panelNorthSecond;
    private JToolBar toolBar;
    private JButton btnPrevius, btnUp, btnNext;

    public void createMenuBar(){
        file=new JMenu("File");
        jMenuItemNew=new JMenuItem("New");
        jMenuItemNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCenter.addTabb("New","");
            }
        });
    }

    public void createPanelNorth(){
            panelNorth = new JPanel();
            panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
            createPanelNorthFirst();
            createPanelNorthSecond();
            panelNorth.add(panelNorthFirst);
            panelNorth.add(panelNorthSecond);
        }

    public void createPanelNorthSecond(){
        panelNorthSecond=new JPanel();
        panelNorthSecond.setLayout(new BoxLayout(panelNorthSecond,BoxLayout.Y_AXIS));

        createToolBar();
        panelNorthSecond.add(toolBar);
    }

    public void createPanelNorthFirst(){
        panelNorthFirst = new JPanel();
        panelNorthFirst.setLayout(new BoxLayout(panelNorthFirst, BoxLayout.Y_AXIS));

        createMenuBar();
    }
    public void createToolBar(){
        toolBar=new JToolBar();
        btnPrevius=new JButton("Previus");
        btnUp=new JButton("Up");
        btnNext=new JButton("Next");
        toolBar.add(btnPrevius);
        toolBar.addSeparator();
        toolBar.add(btnUp);
        toolBar.addSeparator();
        toolBar.add(btnNext);
    }


}
