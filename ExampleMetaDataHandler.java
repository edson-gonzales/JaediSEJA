/**
 * Created by SergioLanda on 8/3/2016.
 */
import java.lang.reflect.Method;

public class ExampleMetaDataHandler {
    public static void main(String args[])
    {
        try{
            Class classCatch=Class.forName("Persona");
            Method method[]=classCatch.getDeclaredMethods();
            for(int i =0;i<method.length;i++)
            {
                System.out.println(method[i].getParameters()[0].getName().toString());
            }
        }
        catch(Throwable e){
            System.err.println(e);
        }
    }
}