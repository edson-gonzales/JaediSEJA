import java.lang.reflect.Parameter;

/**
 * Created by HP-PC on 26/07/2016.
 */
public class MethodMember extends Member {

    private Parameter[] parametersList;

    /**
     * Constructor method
     * @param name
     * @param accessModifier
     * @param type
     * @param dataType
     * @param parameters
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
        String text = "";
        String prefix = "";
        text = concatModifier() + name + "(";

        for (Parameter parameter : parametersList) {
            text += prefix + parameter.getType().getTypeName().substring(parameter.getType().getTypeName().lastIndexOf(".") + 1) + " " + parameter.getName();
            prefix = ", ";
        }

        return text + ")";
    }
}
