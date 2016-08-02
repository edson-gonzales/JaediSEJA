/**
 * Created by Ericka-VS on 10/07/2016.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Read txt file
 */
public class ReadTxt extends Reader {
    /**
     * Name of the txt file
     */
    private String filename;

    /**
     * @param filename
     */
    public ReadTxt(String filename) {
        this.filename = filename;
    }

    /**
     * Start to fill a strings array reading the txt file,
     * Each position of the array content the value of one attribute per line
     * of the txt file
     * this method return the array created with the values inserted.
     */
    @Override
    public ArrayList<String[]> read() {

        ArrayList<String[]> txtData = new ArrayList<String[]>();

        BufferedReader br = null;
        String line = "";
        try {

            br = new BufferedReader(new FileReader(path + filename));
            while ((line = br.readLine()) != null) {

                String[] element = new String[1];
                element[0] = line;
                txtData.add(element);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReader(br);
            return txtData;
        }
    }
}

