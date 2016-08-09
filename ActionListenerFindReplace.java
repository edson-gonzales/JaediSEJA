package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HP-PC on 08/08/2016.
 */
public class ActionListenerFindReplace implements ActionListener {
    private JTextPane editor;

    public ActionListenerFindReplace (JTextPane editor){
        super();
        this.editor = editor;

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand()=="Find")
        {
            new FindReplace(editor);
        }
        else if(e.getActionCommand()=="Replace")
        {
            new ReplaceText(editor);
        }
    }
}
