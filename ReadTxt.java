import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ericka-VS on 10/07/2016.
 */
public class ReadTxt implements Reader{


        private String filename;

        public ReadTxt(String filename)
        {
            this.filename=filename;
        }

        @Override
        public ArrayList<String[]> read()
        {
            {
                ArrayList<String[]> txtData = new ArrayList<String[]>();
                BufferedReader br = null;
                String line = "";
                try {
                    br = new BufferedReader(new FileReader(path+filename));
                    while ((line = br.readLine()) != null) {
                        String[] element=new String[1];
                        element[0]=line;
                        txtData.add(element);

                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                            return txtData;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return null;
        }
 }

