/**
 * Created by Ericka-VS on 10/07/2016.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Reader {

    /**
     * Location of the txt file.
     */
    String path = "src\\Module\\";

    abstract ArrayList<String[]> read();

    /**
     * finish the read file process
     *
     * @param br
     */
    public void closeReader(BufferedReader br) {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
