package Classes;

import Classes.JavaDocsST.ClassParser;
import Classes.JavaDocsST.Member;
import Classes.JavaDocsST.MethodMember;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by SergioLanda on 8/3/2016.
 */
public class PanelEast {
    public JPanel panelEast;
    private JTree treeEast;

    private int tabCount=0;

    public void createPanelEast() throws ClassNotFoundException {
        panelEast=new JPanel();
        panelEast.setLayout(new FlowLayout());
        createTreeEast();
        panelEast.add(treeEast);
    }
    public void createTreeEast() throws ClassNotFoundException {
        ClassParser classParser=new ClassParser("Classes.PanelNorth");
        ArrayList<MethodMember> methodsNames=classParser.getMethods();
        ArrayList<Member> fieldsNames=classParser.getFields();


        DefaultMutableTreeNode principalNode=new DefaultMutableTreeNode("PanelNorth");
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
        treeEast.setMinimumSize(new Dimension(250,panelEast.getHeight()));
    }
}