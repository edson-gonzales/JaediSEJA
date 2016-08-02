/**
 * Created by ErickaViraca on 7/28/2016.
 */

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodsAndFields extends JFrame {
    /**
     * we use that class to see the progress
     */
    private final Reflection test;

    /**
     * it is the constructor, and it receive a class and
     * initialize the method after the VK_PERIOD event
     *
     * @param test
     */
    public MethodsAndFields(Reflection test) {
        this.test = test;
        setList();
    }

    /**
     * show the methods list on UI
     */
    public void setList() {
        JDialog jd = new JDialog();
        JList list;
        jd.setBounds(150, 200, 150, 200);
        String[] elements = returnNamesMethods();
        list = new javax.swing.JList(elements);
        jd.add(list);
        jd.setVisible(true);
    }

    /**
     * @return just the names of the methods in a array
     */
    private String[] returnNamesMethods() {

        ArrayList<Method> publicMethods = new ArrayList<>(test.getPublicMethods());
        int size = publicMethods.size();
        String[] elements = new String[size];
        String nameMethod;
        for (int i = 0; i < size; i++) {
            nameMethod = publicMethods.get(i).getName();
            elements[i] = nameMethod;
            System.out.println(nameMethod);
        }
        return elements;
    }

    /**
     * @return just the names of the fields in a array
     */
    public String[] returnNamesFields() {

        ArrayList<Field> publicFields = new ArrayList<>(test.getPublicAttributes());
        int size = publicFields.size();
        String[] elements = new String[size];
        String nameField;
        for (int i = 0; i < size; i++) {
            nameField = publicFields.get(i).getName();
            elements[i] = nameField;
            System.out.println(nameField);
        }
        return elements;
    }

}
