package Classes.JavaDocsST;

import java.lang.reflect.Modifier;

/**
 * Created by HP-PC on 26/07/2016.
 */
public class Member {
    private String name;
    private int accessModifier;
    private String type;
    private String dataType;

    public String getName(){
        return this.name;
    }
    /**
     * Constructor method, a member can be a method, field or parameter.
     * @param name -> The name of the member
     * @param accessModifier -> Could be public, private, etc.
     * @param type -> Is the data type that has a field or parameter.
     * @param dataType -> Is the type of member. It could be a method, field
     *                 or parameter.
     */
    public Member(String name, int accessModifier, String type, String dataType) {

        this.name = name;
        this.accessModifier = accessModifier;
        this.type = type;
        this.dataType = dataType;
    }

    /**
     * Converts in clear form the way to show the member
     * A member could be a method, field or parameter
     * The way to show changes according the member type
     * @return the text formatted ready to be showed
     */
    public String toString() {
        String text = "";
        if (this.dataType.equalsIgnoreCase(MemberDataType.Method.getMemberType())) {
            text = concatModifier() + name;
        }
        if (this.dataType.equalsIgnoreCase(MemberDataType.Field.getMemberType())) {
            text = concatModifier() + type.substring(type.lastIndexOf(".") + 1) + ": " + name;
        }
        if (this.dataType.equalsIgnoreCase(MemberDataType.Parameter.getMemberType())) {
            text = type.substring(type.lastIndexOf(".")) + " " + name;
        }
        return text;
    }

    /**
     * According to the modifier concat at the beginning the corresponding symbol:
     * Public: concat "+"
     * Private: concat "-"
     * Protected: concat "#"
     * Other: concat " " -> empty
     * @return the correspond symbol
     */
    protected String concatModifier() {
        String modifier;
        if (Modifier.isPublic(accessModifier)) {
            modifier = "+";
        } else if (Modifier.isPrivate(accessModifier)) {
            modifier = "-";
        } else if (Modifier.isProtected(accessModifier)) {
            modifier = "#";
        } else {
            modifier = " ";
        }
        return modifier;
    }
}
