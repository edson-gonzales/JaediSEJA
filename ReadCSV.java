import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by HP-PC on 08/07/2016.
 */

public class ReadCSV implements Reader{


    private String filename;

    public ReadCSV(String filename){
        this.filename=filename;
    }


    @Override
    public ArrayList<String[]> read() {
        {
            ArrayList<String[]> csvData = new ArrayList<String[]>();

            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            try {

                br = new BufferedReader(new FileReader(path+filename));
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
                if (br != null) {
                    try {
                        br.close();
                        return csvData;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
