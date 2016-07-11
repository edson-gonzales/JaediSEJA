import java.util.ArrayList;

/**
 * Created by HP-PC on 08/07/2016.
 */
public class Snippet {
    private ReadCSV reader;

    public String obtainSnippet(String snippet){
        reader=new ReadCSV("snippets.csv");
        ArrayList<String[]> snippetsList;
        snippetsList=reader.read();
        String newSnippet=snippet.replaceAll("\\s","");
        for (String[] snippetItem:snippetsList) {
            if (snippetItem[0].equals(newSnippet)){
                return snippetItem[1];
            }
        }
        return "";
    }
}
