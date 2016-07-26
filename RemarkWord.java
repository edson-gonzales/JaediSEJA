/**
 * Created by Ericka-VS on 10/07/2016.
 */
import java.util.ArrayList;

/**
 * class to remark every reserved reserved word
 */
public class RemarkWord {

    private ReadTxt reader;

    public boolean isReservedWord(String reservedWord){

        reader=new ReadTxt("reservedWords.txt");
        ArrayList<String[]> reservedWords;
        reservedWords=reader.read();
        String newWord=reservedWord.replaceAll("\\s"," ");
        /**
         * tour all the position in the ReservedWordItem arrayList
         * to match the word recently inserted on the Editor with the txt file
         */
        for (String[] reservedWordItem:reservedWords) {

            if (reservedWordItem[0].equals(newWord)){
                return true;
            }
        }
        return false;
    }
}
