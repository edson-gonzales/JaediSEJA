/**
 * Created by Ericka-VS on 10/07/2016.
 */

import java.io.IOException;
import java.util.ArrayList;

/**
 * class to remark every reserved reserved word
 */
public class RemarkWord {

    private ReadTxt reader;

    /**
     * tour all the position in the ReservedWordItem arrayList
     * to match the word recently inserted on the Editor with the txt file
     *
     * @param reservedWord
     * @return true if the word exist.
     * @throws IOException if nopt found return false
     */
    public boolean isReservedWord(String reservedWord) throws IOException {
        Config fileConfig = new Config();
        reader = new ReadTxt(fileConfig.getReservedWordsFile());
        ArrayList<String[]> reservedWords;
        reservedWords = reader.read();
        String newWord = reservedWord.replaceAll("\\s", " ");

        for (String[] reservedWordItem : reservedWords) {

            if (reservedWordItem[0].equals(newWord)) {
                return true;
            }
        }
        return false;
    }
}
