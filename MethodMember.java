package Classes.JavaDocsST;

import java.lang.reflect.Parameter;

/**
 * Created by HP-PC on 26/07/2016.
 */
public class MethodMember extends Member {

    private Parameter[] parametersList;


    /**
     * Constructor method, a member is only a method.
     * @param name -> The name of the member
     * @param accessModifier -> Could be public, private, etc.
     * @param type -> Is the data type that has the member.
     * @param dataType -> Is the type of member. It could be  only a method.
     * @param parameters -> Are the parameters that the method contains.
     */
    public MethodMember(String name, int accessModifier, String type, String dataType, Parameter[] parameters) {
        super(name, accessModifier, type, dataType);
        this.parametersList = parameters;
    }

    /**
     * Converts in clear form the way to show the member
     * A member in this case is only a method
     * The way to show changes according the member type
     * @return the text formatted ready to be showed
     */
    public String toString() {
        String prefix = "";
        String text = concatModifier() + super.getName() + "(";

        for (Parameter parameter : parametersList) {
            String parameterTypeName=parameter.getType().getTypeName();
            text += prefix + parameterTypeName.substring(parameterTypeName.lastIndexOf(".") + 1) + " " + parameter.getName();
            prefix = ", ";
        }

        return text + ")";
    }

    /**
     * Converts in clear form the way to show the parameters of the member.
     * In this case the member is a method and show its parameters.
     * @return the text formatted ready to be showed
     */
    public String parametersToString(){
        String text ="(";
        String prefix = "";

        for (Parameter parameter : parametersList) {
            String parameterTypeName=parameter.getType().getTypeName();
            text += prefix + parameterTypeName.substring(parameterTypeName.lastIndexOf(".") + 1) + " " + parameter.getName();
            prefix = ", ";
        }

        return text + ")";
    }
}
