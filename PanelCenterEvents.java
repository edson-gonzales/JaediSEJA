package Classes;
import Classes.HighlightCEP.*;
import Classes.JavaDocsST.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SergioLanda on 8/4/2016.
 */

public class PanelCenterEvents extends JTextPane implements KeyListener{

    PopupParameters popupParameters;
    private int tabCount=0;
    public PanelCenterEvents(){
        addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        if ((byte) c == 40) { tabCount = 0;
                popupParameters = new PopupParameters();
                WordsParser wordsParser = new WordsParser(this.getText());
                ArrayList<String> word = wordsParser.obtainTwoLastWords(this.getCaretPosition());
                ArrayList<String> param = new ArrayList<String>();
                //-------------------
                Rectangle caretRect = null;
                try {
                    caretRect = this.getUI().modelToView(this, getCaretPosition());
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
                int posX = caretRect.x;
                int posY = caretRect.y;

                //--------------------
                //-------------------
                try {
                    ClassParser classParser = new ClassParser("Classes."+word.get(0));
                    ArrayList<MethodMember> parameters = classParser.getMethodsByName(word.get(1));
                    for (MethodMember parameter : parameters) {
                        param.add(parameter.parametersToString());
                    }
//                for (MethodMember parameter : parameters) {
//                    this.setText(this.getText() + parameter.parametersToString()+'\n');
//                }
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                }
                //-------------------
                popupParameters.createPopupOfParameters(this, param, posX, posY);
                for (String wordToPrint : word) {
                    System.out.print(wordToPrint + " ");
                }
                //this.setText(this.getText()+"bla");
                //System.out.println(dot);
        }
        switch (e.getKeyCode()){

            case KeyEvent.VK_F12: tabCount = 0; if (e.isShiftDown()){
                WordsParser words= new WordsParser(this.getText());
                String wordFinded=words.obtainWordWhenTheCaretIsLocatedAtTheMiddle(this.getCaretPosition());
                LoadJavaDocs load=new LoadJavaDocs();
                    try {
                        String content = load.getJavaDoc(wordFinded);
                        if(content!="") {
                            PopUpJavaDocs popUpJavaDocs = new PopUpJavaDocs();
                            Rectangle caretRects = this.getUI().modelToView(this, getCaretPosition());
                            int possX = caretRects.x + (int) getLocationOnScreen().getX();
                            int possY = caretRects.y + (int) getLocationOnScreen().getY() + 15;
                            popUpJavaDocs.buildJavaDocsShower(content, possX, possY);
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                }
                break;
            case KeyEvent.VK_PERIOD: tabCount = 0;
                WordsParser wordssParser = new WordsParser(this.getText());
                String wordss = wordssParser.obtainWordWhenTheCaretIsLocatedAtTheMiddle(this.getCaretPosition());
                Reflection classToEvaluate = new Reflection("Classes."+wordss);
                Rectangle caretRectt = null;
                try {
                    caretRectt = this.getUI().modelToView(this, getCaretPosition());
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
                int posssX = caretRectt.x  + (int)getLocationOnScreen().getX();
                int posssY = caretRectt.y  + (int)getLocationOnScreen().getY() + 15;
                new MethodsAndFields(classToEvaluate, posssX, posssY, this, 0);
//                String propClass = new ProposalClass(this.getText()).getProposalClass();
//                File archivo = new File(FilePath.filesAbsolutedPath);
//                File[] actualTree = archivo.listFiles();
//                //File[] actualTree = ActionListenerOpenProject.class.getMethod("getTree", null).getReturnType(File[]);
//                boolean classExist = new VerifyIsAClass(propClass, actualTree).searchClass();
//                if (classExist == true) {
//                    Rectangle caretRect = null;
//                    Reflection classToEvaluate = new Reflection("propClass");
//                    try {
//                        caretRect = this.getUI().modelToView(this, getCaretPosition());
//                    } catch (BadLocationException e1) {
//                        e1.printStackTrace();
//                    }
//                    int posX = caretRect.x + (int) getLocationOnScreen().getX();
//                    int posY = caretRect.y + (int) getLocationOnScreen().getY() + 15;
//                    new MethodsAndFields(classToEvaluate, posX, posY, this, 0);
//                } else {
//                    //then do nothing
//                }
                break;
            case KeyEvent.VK_SPACE: tabCount = 0;
                if (e.isControlDown()){
                    Rectangle caretRect = null;
                    try {
                        caretRect = this.getUI().modelToView(this, getCaretPosition());
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    int posiX = caretRect.x + (int) getLocationOnScreen().getX();
                    int posiY = caretRect.y + (int) getLocationOnScreen().getY() + 15;
                    new Shorcuts(this,1,posiX,posiY);
                }
                else {
                    new RemarkWord(this);
                }
                break;
            case KeyEvent.VK_TAB:tabCount++; if (tabCount==2){

                String text=new String(" "+this.getText());
                String lastWord=text.substring(text.lastIndexOf(" "));
                Snippet snippet=new Snippet();

                String newWord= null;
                try {
                    newWord = snippet.obtainSnippet(lastWord);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if(newWord!=""){text.replaceAll("^\\s*","");text.replaceAll("\\s*$","");}

                this.setText(text.substring(0,text.lastIndexOf(" "))+" "+newWord+" ");

                tabCount=0;
            }
                break;
            default: tabCount = 0;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
