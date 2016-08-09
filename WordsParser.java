package Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by AngelaValdez on 8/3/2016.
 */
public class WordsParser {
    private String text;

    public WordsParser(String text){
        this.text=text;
    }

    public String obtainWordWhenTheCaretIsLocatedAtTheMiddle(int caretPosition){
        if(caretPosition!=0 && text.charAt(caretPosition-1)!=' '){
            String delimiters = "[({ .,;=\n)}]+";
            String[] firstTokens = text.substring(0,caretPosition).split(delimiters);
            String[] lastTokens = text.substring(caretPosition,text.length()).split(delimiters);
            return firstTokens[firstTokens.length-1]+lastTokens[0];
        }
        else{
            return null;
        }
    }

    public ArrayList<String> obtainTwoLastWords(int caretPosition){
        if(caretPosition!=0 && text.charAt(caretPosition-1)!=' ') {
            String delimiters = "[({.,;=\\s*)}]+";
            String subString=text.substring(0, caretPosition)+"(";
            String[] firstTokens = subString.split(delimiters);

            ArrayList<String> result = new ArrayList<String>();
            if (firstTokens.length > 1) {
                result.add(firstTokens[firstTokens.length - 2]);
            }
            result.add(firstTokens[firstTokens.length - 1]);

            return result;
        }
        else {
            return null;
        }
//        ArrayList<String> result = new ArrayList<String>();
//        StringTokenizer tokenizer=new StringTokenizer(text,"[({ .,;=\n)}]+");
//        while (tokenizer.hasMoreTokens()){
//            String tokens =tokenizer.nextToken();
//            //System.out.println(tokens);
//            result.add(tokens);
//        }
//        return result;
    }

    public String obtainLastWordOfTheLine(){
        String delimiters = "[({ .,;=)}]+";
        String[] tokens = text.split(delimiters);
        return tokens[tokens.length-1];
    }
}