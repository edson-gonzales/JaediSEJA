/**
 * Created by Ericka-VS on 10/07/2016.
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

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
        tabbedPane.addTab("first", panel1);
    }

    /**
     * creation of editor principal
     */
    public void createEditor() {
        editor = new JTextPane();
        editor.addKeyListener(this);
        editor.setSize(500, 500);
    }

    /**
     * creation center panel
     */
    public void createPanelCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        createTabbedPane();
        createEditor();
        panel1.add(editor);
        panelCenter.add(tabbedPane);
    }

    /**
     * Constructor of principal window
     */
    public Window() {
        setTitle("JaEdi");
        setBackground(Color.white);
        setLayout(new BorderLayout());
        createPanelCenter();
        add(panelCenter, BorderLayout.CENTER);
        setSize(600, 600);
    }

    /**
     * the KeyPressed is override, and work with the
     * VK_PERIOD and VK_SPACE
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.VK_PERIOD == e.getKeyCode()) {
            System.out.println("Key Period recognized");
            try {
                Reflection test = new Reflection("RemarkWord");
                new MethodsAndFields(test);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }

        } else if (e.VK_SPACE == e.getKeyCode()) {
            tabCount = 0;
            try {
                RecognizeSpace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            tabCount = 0;
        }
    }

    /**
     * work on recognize the space event and colouring if the word match.
     *
     * @throws IOException
     */
    private void RecognizeSpace() throws IOException {

        RemarkWord remarkWord = new RemarkWord();
        String textInserted = new String(" " + editor.getText());
        String lastWord = textInserted.substring(textInserted.lastIndexOf(" ")).replaceAll("\\s", "");

        if (remarkWord.isReservedWord(lastWord)) {
            StyleContext sc = StyleContext.getDefaultStyleContext();
            AttributeSet atriSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.blue);

            int len = editor.getDocument().getLength();
            editor.setCaretPosition(len);
            editor.setText(textInserted.substring(0, textInserted.lastIndexOf(" ")));
            editor.setCharacterAttributes(atriSet, false);
            editor.replaceSelection(lastWord);
            atriSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.black);
            editor.setCharacterAttributes(atriSet, true);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


