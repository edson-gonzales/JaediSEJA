package Classes.JavaDocsST;

import Classes.BareBonesBrowserLaunch;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by HP-PC on 08/08/2016.
 */
public class PopUpJavaDocs {

    private JTextPane javaDocContainer;
    private JDialog javaDocsDialogContainer;

    public PopUpJavaDocs(){
        this.javaDocContainer = new JTextPane();
        this.javaDocsDialogContainer = new JDialog();
    }

    public void buildJavaDocsShower(String content, int posX, int posY){

        javaDocContainer.setEditable(false);
        javaDocContainer.setMaximumSize(new Dimension(500,200));
        javaDocContainer.setContentType("text/html");
        javaDocContainer.addHyperlinkListener(new HyperlinkListener() {

            public void hyperlinkUpdate(
                    HyperlinkEvent evt) {
                if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    //Pega o valor da url
                    System.out.println(evt.getURL().toString());
                    String url = evt.getURL().toString();
                    //Passa valor da URL para clase que realiza a abertura do Browser
                    BareBonesBrowserLaunch.openURL(url);
                }
            }
        });

        javaDocContainer.setText(content);


        javaDocsDialogContainer.setUndecorated(true);
        javaDocsDialogContainer.setResizable(true);
        javaDocsDialogContainer.setBounds(posX, posY, 500, 200);
        JScrollPane scroll = new JScrollPane ( javaDocContainer );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        //Add Textarea in to middle panel
        javaDocsDialogContainer.add ( scroll );
        //javaDocsDialogContainer.add(javaDocContainer);
        javaDocsDialogContainer.setVisible(true);
        ActionListener hider = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                javaDocsDialogContainer.dispose();
            }
        };
        // Hide popup in 3 seconds

        Timer timer = new Timer(7000, hider);
        timer.start();
    }
}
