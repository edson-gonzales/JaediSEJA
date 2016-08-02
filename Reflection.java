/**
 * Created by Ericka-VS on 23/07/2016.
 */

import java.lang.reflect.*;
import java.util.ArrayList;

public class Reflection {

    // public String nameClass;
    private Class classObject;

    /**
     * Constructor that receive a name String (of a class)
     * were is created an object class with the name received
     *
     * @param className
     * @throws ClassNotFoundException
     */
    public Reflection(String className) throws ClassNotFoundException {
        this.classObject = Class.forName(className);
    }

    /**
     * method to return an object arrayList of public methods.
     *
     * @return methods, only publics
     */
    public ArrayList<Method> getPublicMethods() {
        ArrayList<Method> publicMethods = new ArrayList<>();
        for (Method methodPublicMethods : classObject.getDeclaredMethods()) {
            boolean isPublic = Modifier.isPublic(methodPublicMethods.getModifiers());
            if (isPublic == true) {
                publicMethods.add(methodPublicMethods);
            }
        }
        return publicMethods;
    }

    /**
     * method to return an object arrayList of private methods .
     *
     * @return
     */
    public ArrayList<Method> getPrivateMethods() {
        ArrayList<Method> privateMethods = new ArrayList<>();
        for (Method methodPrivateMethods : classObject.getDeclaredMethods()) {
            boolean isPrivate = Modifier.isPrivate(methodPrivateMethods.getModifiers());
            if (isPrivate == true) {
                privateMethods.add(methodPrivateMethods);
            }
        }
        return privateMethods;
    }

    /**
     * method to return an object arrayList of public fields.
     *
     * @return
     */
    public ArrayList<Field> getPublicAttributes() {
        ArrayList<Field> publicAttributes = new ArrayList<>();
        for (Field fieldPublicAttributes : classObject.getDeclaredFields()) {
            Boolean isPublicAttribute = Modifier.isPublic(fieldPublicAttributes.getModifiers());
            if (isPublicAttribute == true)
                publicAttributes.add(fieldPublicAttributes);
        }
        return publicAttributes;
    }

    /**
     * method to return an object arrayList of private fields.
     *
     * @return
     */
    public ArrayList<Field> getPrivateAttributes() {
        ArrayList<Field> privateAttributes = new ArrayList<>();
        for (Field fieldPrivateAttributes : classObject.getDeclaredFields()) {
            Boolean isPrivateAttribute = Modifier.isPrivate(fieldPrivateAttributes.getModifiers());
            if (isPrivateAttribute == true)
                privateAttributes.add(fieldPrivateAttributes);
        }
        return privateAttributes;
    }
}
