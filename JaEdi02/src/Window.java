 import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Menu;
//import java.awt.MenuBar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar; 
import javax.swing.JTree;



public class Window extends JFrame{
	
	private JPanel panelNorth,panelNorthFirst, panelNorthSecond, panelWest, panelEast, panelSouth, panelCenter, panel1, panel2, panel3;
	private JButton btnPrevius, btnUp, btnNext;
	//I improved the manage of JMenuBar, JMenu, JMenuItem variables, I implement these variables
	private JMenuBar bar;
	private JMenu file, edit, view, tools, help;
	private JMenuItem newFile, saveFile, saveAsFile, closeFile, closeAllFile, exit, copyEdit, cutEdit, pasteEdit, searchEdit, replaceEdit, undoEdit, redoEdit, settingEdit, toolbarView, sidebarView, outputPanelView, snippetTool, compileTool, executeOptionsTool, aboutHelp, editSettingShowHideLineNumber;
//
	private JToolBar toolBar;
	private JEditorPane editor, output;
	private JTree treeEast, treeWest;
	private JLabel labelOutPut;
	private JTabbedPane tabbedPane;
	
	public void createTabbedPane(){
		tabbedPane=new JTabbedPane();
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		tabbedPane.addTab("Coding 1", panel1);
		tabbedPane.addTab("Coding 2", panel2);
		tabbedPane.addTab("Coding 3", panel3);
	}
	
	public void createTreeEast(){
		treeEast=new JTree();
	}
	
	public void createTreeWest(){
		treeWest=new JTree();
	}	
	
	public void createEditor(){
		editor=new JEditorPane();
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
	//I performed the method "createMenuBar", but I'm going to improve it.
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
	//I did it, until here.
	
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
	
	public void createPanelEast(){
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
		panel1.add(editor);
		panelCenter.add(tabbedPane);
	}
	
	public Window(){
		setTitle("Principal");
		setBackground(Color.gray);
		setLayout(new BorderLayout());
		createPanelNorth();
		createPanelWest();
		createPanelEast();
		createPanelSouth();
		createPanelCenter();
		
		add(panelNorth,BorderLayout.NORTH);
		add(panelWest,BorderLayout.WEST);
		add(panelEast,BorderLayout.EAST);
		add(panelSouth,BorderLayout.SOUTH);
		add(panelCenter,BorderLayout.CENTER);
		
		setSize(600,600);
	}
}
