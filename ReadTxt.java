import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HP-PC on 08/07/2016.
 */

/**
 * Read txt files
 */
public class ReadTxt extends Reader {

    /**
     * Name of the txt file
     */
    private String filename;

    public ReadTxt(String filename) {
        this.filename = filename;
    }

    /**
     * Start to fill a strings array reading a txt file,
     * Each line represents an string array,
     * Position 0 of the array has the value of one line.
     *
     * @return The array created
     */
    @Override
    public ArrayList<String[]> read() {
        {
            ArrayList<String[]> txtData = new ArrayList<String[]>();

            BufferedReader br = null;
            String line;
            try {

                br = new BufferedReader(new FileReader(path + filename));
                while ((line = br.readLine()) != null) {

                    // use comma as separator
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

}

