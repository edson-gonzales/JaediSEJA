

/**
 * Created by HP-PC on 26/07/2016.
 */
public enum MemberDataType {

    Parameter("Parameter"),
    Method("Method"),
    Field("Field");

    private final String memberType;

    /**
     * Constructor of the enumerator that has
     * the text that reflects the type of the
     * member
     * @param memberType
     */
    MemberDataType(String memberType) {
        this.memberType = memberType;
    }

    /**
     * Getter of the text that could change
     * according the member type.
     * @return the text of the member type
     */
    public String getMemberType() {
        return memberType;
    }

}
