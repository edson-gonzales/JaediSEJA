package Classes;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by SergioLanda on 8/4/2016.
 */
public class PanelCenter {
    public JTextPane editor;
    public JPanel panelCenter;
    private JTabbedPane tabbedPane;

//    public void createTabbedPane() {
//        tabbedPane = new JTabbedPane();
//
//
//    }

    public void createEditor() {
        editor = new PanelCenterEvents();

    }

    public void addTabb(String name, String content) {
//        panelForTab = new JPanel();
//        panelTab=new JPanel();
//        tabbedPane.addTab(name, panelForTab);
//        createEditor();
//        editor.setText("test");
//        panelForTab.add(editor);
        boolean flag=false;
        for (int i=0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTabComponentAt(i).getName() == name) {
                flag = true;
                tabbedPane.setSelectedIndex(i);
            }
        }

        if(!flag) {
                createEditor();
                editor.setText(content);
                editor.setBounds(0,0,400,400);
                JPanel panelTab = new JPanel();
                panelTab.setLayout(null);
                panelTab.add(editor);
                panelTab.setName(name);
                tabbedPane.add(panelTab);

                tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(panelTab), getTitlePanel(tabbedPane, panelTab, name));
                panelCenter.add(tabbedPane);

        }

//
    }

    public void createPanelCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        tabbedPane = new JTabbedPane();
        tabbedPane.getSelectedIndex();
        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                editor = (JTextPane)((JPanel)sourceTabbedPane.getComponentAt(index)).getComponent(0);
            }
        };
        tabbedPane.addChangeListener(changeListener);
    }

    private static JPanel getTitlePanel(final JTabbedPane tabbedPane, final JPanel panel, String title) {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        titlePanel.setOpaque(false);
        JLabel titleLbl = new JLabel(title);
        titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        titlePanel.add(titleLbl);
        JButton closeButton = new JButton("x");

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabbedPane.remove(panel);
            }
        });
        titlePanel.add(closeButton);
        return titlePanel;
    }

}
