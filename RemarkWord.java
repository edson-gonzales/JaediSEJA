/**
 * Created by Ericka-VS on 10/07/2016.
 */
import java.util.ArrayList;

public class RemarkWord {
    private ReadTxt reader;

    public boolean isReservedWord(String reservedWord){
        reader=new ReadTxt("reservedWords.txt");
        ArrayList<String[]> reservedWords;
        reservedWords=reader.read();
        String newWord=reservedWord.replaceAll("\\s","");
        for (String[] reservedWordItem:reservedWords) {
            if (reservedWordItem[0].equals(newWord)){
                return true;
            }
        }
        return false;
    }
}
