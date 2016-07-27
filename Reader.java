import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Reader {

    /**
     * Location of all the files that
     */
    String path = "src\\Module\\";

    /**
     * Method to be implemented in the child classes
     *
     * @return Array with data per line read
     */
    abstract ArrayList<String[]> read();

    /**
     * Finish the process of read some file
     *
     * @param br => Th object used to read the files
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
