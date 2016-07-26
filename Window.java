/**
 * Created by Ericka-VS on 10/07/2016.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.text.*;


public class Window extends JFrame implements KeyListener {

    private JPanel panelCenter, panel1;
    private JTextPane editor;
    private JTabbedPane tabbedPane;

    public int tabCount = 0;

    public void createTabbedPane() {
        tabbedPane = new JTabbedPane();
        panel1 = new JPanel();
        tabbedPane.addTab("Coding 1", panel1);
    }

    public void createEditor() {
        editor = new JTextPane();
        editor.addKeyListener(this);
    }

    //principal window to edition
    public void createPanelCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        createTabbedPane();
        createEditor();
        panel1.add(editor);
        panelCenter.add(tabbedPane);

    }

    //principal window with components
    public Window() {
        setTitle("JaEdi");
        setBackground(Color.white);
        setLayout(new BorderLayout());
        createPanelCenter();
        add(panelCenter, BorderLayout.CENTER);
        setSize(600, 600);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.VK_PERIOD == e.getKeyCode()) {
            tabCount = 0;
            RecognizeClass();
            }
        else if(e.VK_SPACE==e.getKeyCode()) {
             tabCount = 0;
             RecognizeSpace();
        } else {
             tabCount = 0;
        }
    }

    //method to recognize the space after a word inserted
    private void RecognizeSpace() {

        RemarkWord remarkWord=new RemarkWord();
        String textInserted=new String(" "+editor.getText());
        String lastWord = textInserted.substring(textInserted.lastIndexOf(" ")).replaceAll("\\s", "");

        if(remarkWord.isReservedWord(lastWord)) {
            StyleContext sc = StyleContext.getDefaultStyleContext();
            AttributeSet atribSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.blue);

            int len = editor.getDocument().getLength();
            editor.setCaretPosition(len);
            editor.setText(textInserted.substring(0, textInserted.lastIndexOf(" ")));
            editor.setCharacterAttributes(atribSet, false);
            editor.replaceSelection(lastWord);
            atribSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.black);
            editor.setCharacterAttributes(atribSet, true);
        }
    }

    private void RecognizeClass(){

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

