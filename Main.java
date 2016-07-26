/**
 * Created by Ericka-VS on 10/07/2016.
 */

public class Main {
    public static void main(String []Args){
        Window window=new Window();
        window.setVisible(true);
        //proof methods and attributes
        Reflection test = new Reflection();
        test.getPrivateAttributes("Window");
        test.getPublicAttributes("Window");
        test.getPrivateMethods("Window");
        test.getPublicMethods("Window");
    }
}
