import javax.swing.*;

/**
 * Created by SergioLanda on 8/3/2016.
 */
public class PanelSouth {

    private PanelCenter panelCenter;
    public JPanel panelSouth;
    private JEditorPane output;
    private JLabel labelOutPut;

    private int tabCount=0;

    public void createPanelSouth(){
        panelSouth=new JPanel();
        panelSouth.setLayout(new BoxLayout(panelSouth,BoxLayout.Y_AXIS));
        labelOutPut=new JLabel();
        labelOutPut.setText("output");
        createOutPut();
        panelSouth.add(labelOutPut);
        panelSouth.add(output);
    }

    public void createOutPut(){
        output=new JEditorPane();
    }
}
