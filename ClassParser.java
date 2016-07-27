import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * Created by HP-PC on 25/07/2016.
 */
public class ClassParser {

    private Class classObject;

    public ClassParser(String className) throws ClassNotFoundException {
        this.classObject = Class.forName(className);
    }

    /**
     * Obtain all the public methods in the class object
     * @return an array list of all public methods of the class
     */
    public ArrayList<Method> getPublicMethods() {
        ArrayList<Method> publicMethodsArray = new ArrayList<>();
        for (Method method : classObject.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                publicMethodsArray.add(method);
            }
        }
        return publicMethodsArray;
    }

    /**
     * Obtain all methods of the class as a member
     * The member is an object that have the most
     * important attributes of the method object
     * @return An array list of members
     */
    public ArrayList<Member> getMethods() {
        ArrayList<Member> methodsArray = new ArrayList<>();
        for (Method method : classObject.getDeclaredMethods()) {
            Member member = new MethodMember(method.getName(), method.getModifiers(), "", MemberDataType.Method.getMemberType(), method.getParameters());
            methodsArray.add(member);
        }
        return methodsArray;
    }

    /**
     * Obtain all fields of the class as a member
     * The member is an object that have the most
     * important attributes of the field object
     * @return An array list of members
     */
    public ArrayList<Member> getFields() {
        ArrayList<Member> fieldsArray = new ArrayList<>();
        for (Field field : classObject.getDeclaredFields()) {
            Member member = new Member(field.getName(), field.getModifiers(), field.getGenericType().getTypeName(), MemberDataType.Field.getMemberType());
            fieldsArray.add(member);
        }
        return fieldsArray;
    }

    /**
     * Obtain all the private methods in the class
     * @return an array list of all private methods of the class
     */
    public ArrayList<Method> getPrivateMethods() {
        ArrayList<Method> privateMethodsArray = new ArrayList<>();
        for (Method method : classObject.getDeclaredMethods()) {
            if (Modifier.isPrivate(method.getModifiers())) {
                privateMethodsArray.add(method);
            }
        }
        return privateMethodsArray;
    }

    /**
     * Obtain all the public fields in the class object
     * @return an array list of all public fields of the class
     */
    public ArrayList<Field> getPublicFields() {
        ArrayList<Field> publicFieldsArray = new ArrayList<>();
        for (Field field : classObject.getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers())) {
                publicFieldsArray.add(field);
            }
        }
        return publicFieldsArray;
    }

    /**
     * Obtain all the private fields in the class object
     * @return an array list of all private fields of the class
     */
    public ArrayList<Field> getPrivateFields() {
        ArrayList<Field> privateFieldsArray = new ArrayList<>();
        for (Field field : classObject.getDeclaredFields()) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFieldsArray.add(field);
            }
        }
        return privateFieldsArray;
    }

}
