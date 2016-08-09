package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Reader {

    /**
     * Global location of all the files
     */
    protected String path = "src\\Module\\";
    protected String pathjava = "C:\\Program Files\\Java\\jdk1.8.0_65\\jdk-8u101-docs-all\\docs\\api\\index-files\\";

    /**
     * Method to be implemented in the child classes.
     * @return Array with data per line read
     */
    public abstract ArrayList<String[]> read();

    /**
     * Finish the process of read some file.
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
