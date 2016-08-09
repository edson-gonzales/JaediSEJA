package Classes.JavaDocsST;

import Classes.Configuration;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HP-PC on 07/08/2016.
 */
public class LoadJavaDocs {
    /**
     *Object of reader class to read any file.
     */
    private ReadHTML reader;

    /**
     *
     * @param word
     * @return
     * @throws IOException
     */
    public String getJavaDoc(String word) throws IOException {
        Configuration configuration = new Configuration();
        String fileByLetterToFindJavaDocs = configuration.getFileByLetterToFindJavaDocs(Character.toUpperCase(word.charAt(0))+"");
        reader = new ReadHTML(fileByLetterToFindJavaDocs);
        ArrayList<String[]> htmlContent;
        htmlContent = reader.read();
        if(htmlContent.size() != 0){
            String url=reader.getURLJavaDoc(htmlContent.get(0)[0],word);
            if(url!="") {
                reader = new ReadHTML(url);
                return reader.getBodyFromWebPage(reader.read().get(0)[0]);
            }
            return "";
        }
        else {
            return "";
        }

    }
}
