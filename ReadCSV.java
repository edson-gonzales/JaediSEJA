import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by HP-PC on 08/07/2016.
 */

/**
 * Read csv files
 */
public class ReadCSV extends Reader {

    /**
     * Name of the csv file
     */
    private String filename;

    public ReadCSV(String filename) {
        this.filename = filename;
    }

    /**
     * Start to fill a strings array reading a csv file,
     * Each line represents an string array,
     * Each position of the array has the value of one attribute of the line.
     *
     * @return The array created
     */
    @Override
    public ArrayList<String[]> read() {
        {
            ArrayList<String[]> csvData = new ArrayList<String[]>();

            BufferedReader br = null;
            String line;
            String cvsSplitBy = ",";
            try {

                br = new BufferedReader(new FileReader(path + filename));
                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] data = line.split(cvsSplitBy);
                    csvData.add(data);

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeReader(br);
                return csvData;
            }
        }
    }
}
