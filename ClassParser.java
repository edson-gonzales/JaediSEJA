package Classes.JavaDocsST;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClassParser {

    private Class classObject;

    /**
     * Constructor that receive the class name and convert it in a class object.
     * @param className -> The name of the class to create the object.
     * @throws ClassNotFoundException -> When the class doesn't exist.
     */
    public ClassParser(String className) throws ClassNotFoundException {
        this.classObject = Class.forName(className);
    }

    /**
     * Obtain all the public methods in the class object.
     * @return an array list of all public methods of the class
     */
    public ArrayList<Method> getPublicMethods() {
        ArrayList<Method> publicMethodsArray = new ArrayList<Method>();
        for (Method method : classObject.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                publicMethodsArray.add(method);
            }
        }
        return publicMethodsArray;
    }

    /**
     * Obtain all methods of the class as a member.The member is an object
     * that have the most important attributes of the method object.
     * @return An array list of members
     */
    public ArrayList<MethodMember> getMethods() {
        ArrayList<MethodMember> methodsArray = new ArrayList<>();
        for (Method method : classObject.getDeclaredMethods()) {
            String methodName=method.getName();
            int methodModifier=method.getModifiers();
            String methodDataType= MemberDataType.Method.getMemberType();
            MethodMember member = new MethodMember(methodName, methodModifier, "", methodDataType, method.getParameters());
            methodsArray.add(member);
        }
        return methodsArray;
    }

    /**
     * Obtain all fields of the class as a member. The member is an object
     * that have the most important attributes of the field object
     * @return An array list of members
     */
    public ArrayList<Member> getFields() {
        ArrayList<Member> fieldsArray = new ArrayList<Member>();
        for (Field field : classObject.getDeclaredFields()) {
            String fieldName=field.getName();
            int fieldModifier=field.getModifiers();
            String fieldDataType=field.getGenericType().getTypeName();
            Member member = new Member(fieldName, fieldModifier, fieldDataType, MemberDataType.Field.getMemberType());
            fieldsArray.add(member);
        }
        return fieldsArray;
    }

    /**
     * Obtain all the private methods in the class
     * @return an array list of all private methods of the class
     */
    public ArrayList<Method> getPrivateMethods() {
        ArrayList<Method> privateMethodsArray = new ArrayList<Method>();
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
        ArrayList<Field> publicFieldsArray = new ArrayList<Field>();
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
        ArrayList<Field> privateFieldsArray = new ArrayList<Field>();
        for (Field field : classObject.getDeclaredFields()) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFieldsArray.add(field);
            }
        }
        return privateFieldsArray;
    }

    /**
     * Obtain all methods by a name and return all as a member type.
     * @param methodName -> Is the name of the method to find
     * @return a methods array that have coincidences with the name
     * @throws NoSuchMethodException ->In case that no exist any method
     */
    public ArrayList<MethodMember> getMethodsByName(String methodName) throws NoSuchMethodException {
        ArrayList<MethodMember> arrayMethods=
                (ArrayList<MethodMember>)getMethods().stream().filter(x -> x.getName().contains(methodName)).collect(Collectors.toList());
        return arrayMethods;
    }
}