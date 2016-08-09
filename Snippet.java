package Classes.JavaDocsST;

import Classes.Configuration;
import Classes.Reader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HP-PC on 08/07/2016.
 */

/**
 * Classes.Snippet handler
 */
public class Snippet {
    /**
     *Object of reader class to read any file.
     */
    private Reader reader;

    /**
     * Read a csv file where are defined all the snippets
     *
     * @param snippet -> Is the word to find in the csv
     * @return if the snippet is found return the complete word
     * if not return empty
     */
    public String obtainSnippet(String snippet) throws IOException {
        Configuration configuration= new Configuration();
        reader = new ReadCSV(configuration.getSnippetsFile());
        ArrayList<String[]> snippetsList;
        snippetsList = reader.read();
        String newSnippet = snippet.replaceAll("\\s", "");
        for (String[] snippetItem : snippetsList) {
            if (snippetItem[0].equals(newSnippet)) {
                return snippetItem[1];
            }
        }
        return "";
    }
}
