

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.tree.DefaultMutableTreeNode;


public class Window extends JFrame implements KeyListener {

    private JPanel panelNorth,panelNorthFirst, panelNorthSecond, panelWest, panelEast, panelSouth, panelCenter, panel1, panel2, panel3;
    private JButton btnPrevius, btnUp, btnNext;
    private JMenuBar bar;
    private JMenu file, edit, view, tools, help;
    private JMenuItem newFile, saveFile, saveAsFile, closeFile, closeAllFile, exit, copyEdit, cutEdit, pasteEdit, searchEdit, replaceEdit, undoEdit, redoEdit, settingEdit, toolbarView, sidebarView, outputPanelView, snippetTool, compileTool, executeOptionsTool, aboutHelp;
    private JToolBar toolBar;
    private JEditorPane output;
    private JTextPane editor;
    private JTree treeEast, treeWest;
    private JLabel labelOutPut;
    private JTabbedPane tabbedPane;

    private int tabCount=0;
    public void createTabbedPane(){
        tabbedPane=new JTabbedPane();
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();

        tabbedPane.addTab("Coding 1", panel1);
        tabbedPane.addTab("Coding 2", panel2);
        tabbedPane.addTab("Coding 3", panel3);
    }

    public void createTreeEast() throws ClassNotFoundException {

        ClassParser classParser=new ClassParser("Window");
        ArrayList<Member> methodsNames=classParser.getMethods();
        ArrayList<Member> fieldsNames=classParser.getFields();


        DefaultMutableTreeNode principalNode=new DefaultMutableTreeNode("Window");
        DefaultMutableTreeNode methodsNode=new DefaultMutableTreeNode("Methods");
        DefaultMutableTreeNode fieldsNode=new DefaultMutableTreeNode("Fields");

        for (Member methodName: methodsNames){
            DefaultMutableTreeNode methodNode=new DefaultMutableTreeNode(methodName.toString());
            methodsNode.add(methodNode);
        }

        for (Member fieldName: fieldsNames){
            DefaultMutableTreeNode fieldNode=new DefaultMutableTreeNode(fieldName.toString());
            fieldsNode.add(fieldNode);
        }

        principalNode.add(methodsNode);
        principalNode.add(fieldsNode);
        treeEast=new JTree(principalNode);
        treeEast.setMinimumSize(new Dimension(250,getHeight()));

    }

    public void createTreeWest(){
        treeWest=new JTree();
    }

    public void createEditor(){
        editor=new JTextPane();
        editor.setMinimumSize(new Dimension(panel1.getWidth(),panel1.getHeight()));
        editor.addKeyListener(this);
    }

    public void createOutPut(){
        output=new JEditorPane();
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

    public void createMenuBar(){
        bar = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        tools = new JMenu ("Tools");
        help = new JMenu ("Help");
        bar.add(file);
        bar.add(edit);
        bar.add(view);
        bar.add(tools);
        bar.add(help);
        newFile = new JMenuItem("New");
        saveFile = new JMenuItem("Save");
        saveAsFile = new JMenuItem("Save As");
        closeFile = new JMenuItem("Close");
        closeAllFile = new JMenuItem("Close all files");
        exit = new JMenuItem("Exit");
        file.add(newFile);
        file.add(saveFile);
        file.add(saveAsFile);
        file.add(closeFile);
        file.add(closeAllFile);
        file.add(exit);
        copyEdit = new JMenuItem("Copy");
        cutEdit = new JMenuItem("Cut");
        pasteEdit = new JMenuItem("Paste");
        searchEdit = new JMenuItem("Search");
        replaceEdit = new JMenuItem("Replace");
        undoEdit = new JMenuItem("Undo");
        redoEdit = new JMenuItem("Redo");
        settingEdit = new JMenuItem("Settings menu options");
        edit.add(copyEdit);
        edit.add(cutEdit);
        edit.add(pasteEdit);
        edit.add(searchEdit);
        edit.add(replaceEdit);
        edit.add(undoEdit);
        edit.add(redoEdit);
        edit.add(settingEdit);
        toolbarView = new JMenuItem("Toolbar");
        sidebarView = new JMenuItem("Sidebar");
        outputPanelView = new JMenuItem("Output Panel");
        view.add(toolbarView);
        view.add(sidebarView);
        view.add(outputPanelView);
        snippetTool = new JMenuItem("Snippets");
        compileTool = new JMenuItem("Compile");
        executeOptionsTool = new JMenuItem("Execute options");
        tools.add(snippetTool);
        tools.add(compileTool);
        tools.add(executeOptionsTool);
        aboutHelp = new JMenuItem("About");
        help.add(aboutHelp);
    }

    public void createPanelNorth(){
        panelNorth = new JPanel();
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
        createPanelNorthFirst();
        createPanelNorthSecond();
        panelNorth.add(panelNorthFirst);
        panelNorth.add(panelNorthSecond);
    }

    public void createPanelNorthFirst(){
        panelNorthFirst = new JPanel();
        panelNorthFirst.setLayout(new BoxLayout(panelNorthFirst, BoxLayout.Y_AXIS));

        createMenuBar();
        setJMenuBar(bar);

    }

    public void createPanelNorthSecond(){
        panelNorthSecond=new JPanel();
        panelNorthSecond.setLayout(new BoxLayout(panelNorthSecond,BoxLayout.Y_AXIS));

        createToolBar();
        panelNorthSecond.add(toolBar);
    }

    public void createPanelWest(){
        panelWest=new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest,BoxLayout.Y_AXIS));
        createTreeWest();
        panelWest.add(treeWest);
    }

    public void createPanelEast() throws ClassNotFoundException {
        panelEast=new JPanel();
        panelEast.setLayout(new BoxLayout(panelEast,BoxLayout.Y_AXIS));
        createTreeEast();
        panelEast.add(treeEast);
    }

    public void createPanelSouth(){
        panelSouth=new JPanel();
        panelSouth.setLayout(new BoxLayout(panelSouth,BoxLayout.Y_AXIS));
        labelOutPut=new JLabel();
        labelOutPut.setText("output");
        createOutPut();
        panelSouth.add(labelOutPut);
        panelSouth.add(output);
    }

    public void createPanelCenter(){
        panelCenter=new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter,BoxLayout.Y_AXIS));
        createTabbedPane();
        createEditor();
        editor.setMinimumSize(new Dimension(600,600));
        panel1.add(editor);
        editor.setText("pPublic class Dog{\n" +
                "private String name;\n" +
                "private int age;\n" +
                "public void Eat(){\n" +
                "name=\"hello\";}\n" +
                "}");
        panelCenter.add(tabbedPane);
    }

    public Window() throws ClassNotFoundException {
        setTitle("Principal");
        setBackground(Color.gray);
        setLayout(new BorderLayout());
        createPanelNorth();
        createPanelWest();
        createPanelCenter();
        createPanelEast();
        createPanelSouth();


        add(panelNorth,BorderLayout.NORTH);
        add(panelWest,BorderLayout.WEST);
        add(panelEast,BorderLayout.EAST);
        add(panelSouth,BorderLayout.SOUTH);
        add(panelCenter,BorderLayout.CENTER);

        setSize(800,800);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.VK_TAB==e.getKeyCode()){
            tabCount++;
            if (tabCount==2){

                String text=new String(" "+editor.getText());
                String lastWord=text.substring(text.lastIndexOf(" "));
                Snippet snippet=new Snippet();

                String newWord= null;
                try {
                    newWord = snippet.obtainSnippet(lastWord);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if(newWord!=""){text.replaceAll("^\\s*","");text.replaceAll("\\s*$","");}

                editor.setText(text.substring(0,text.lastIndexOf(" "))+" "+newWord+" ");

                tabCount=0;
            }
        }
        else if(e.VK_SPACE==e.getKeyCode()){
            tabCount=0;
            try {
                ReconizeSpace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else{
            tabCount=0;
        }

    }

    private void ReconizeSpace() throws IOException {
        RemarkWord remarkWord=new RemarkWord();
        String text=new String(" "+editor.getText());
        String lastWord=text.substring(text.lastIndexOf(" ")).replaceAll("\\s","");
        if(remarkWord.isReservedWord(lastWord)) {
            StyleContext sc = StyleContext.getDefaultStyleContext();
            AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.blue);

            int len = editor.getDocument().getLength();
            editor.setCaretPosition(len);
            editor.setText(text.substring(0, text.lastIndexOf(" ")));

            editor.setCharacterAttributes(aset, false);
            editor.replaceSelection(lastWord);
            aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.black);
            editor.setCharacterAttributes(aset, true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

