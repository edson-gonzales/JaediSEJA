package Classes;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Belial on 09/08/2016.
 */
public class PopupParameters {
    JPopupMenu jPopupMenu;

    public void createPopupOfParameters(JTextPane textPane,ArrayList<String> listParameters,int posX, int posY){
        jPopupMenu=new JPopupMenu();
        for(String item:listParameters)
        {
            jPopupMenu.add(new JMenuItem(item));
        }
        jPopupMenu.show(textPane,posX,posY);
    }
}
