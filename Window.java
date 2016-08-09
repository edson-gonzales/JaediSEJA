import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTree;



public class Window extends JFrame{
	
	private JPanel panelNorth,panelNorthFirst, panelNorthSecond, panelWest, panelEast, panelSouth, panelCenter, panel1, panel2, panel3;
	private JButton btnPrevius, btnUp, btnNext;
	private MenuBar bar;
	private Menu file, edit, view;
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
	
	public void createMenuBar(){
		bar = new MenuBar();
		file = new Menu("File");
		edit = new Menu("Edit");
		view = new Menu("View");
		bar.add(file);
		bar.add(edit);
		bar.add(view);
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
		setMenuBar(bar);
		
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
