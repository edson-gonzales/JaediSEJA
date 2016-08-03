import javax.swing.*;

/**
 * Created by SergioLanda on 8/3/2016.
 */
public class PanelCenter {

    private JTextPane editor;
    public JPanel panelCenter,panel, panelForTab;
    private JTabbedPane tabbedPane;

    public void createTabbedPane(){
        tabbedPane=new JTabbedPane();
    }

    public void createEditor(){
        editor=new JTextPane();
    }

    public void addTabb(String name, String content){
        panelForTab=new JPanel();
        tabbedPane.addTab(name, panelForTab);
        createEditor();
        editor.setText("test");
        panelForTab.add(editor);
    }

    public void createPanelCenter(){
        panelCenter=new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter,BoxLayout.Y_AXIS));
        createTabbedPane();
        createEditor();
        panel.add(editor);
        panelCenter.add(tabbedPane);
    }
}
