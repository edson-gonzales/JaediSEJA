package Classes.JavaDocsST;

import Classes.Reader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by HP-PC on 07/08/2016.
 */
public class ReadHTML extends Reader {
    private String filename;

    public ReadHTML(String filename) {
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

            ArrayList<String[]> links = new ArrayList<String[]>();
            String content = "";
            FileInputStream inputStream = null;
            Scanner sc = null;

            try {
                inputStream = new FileInputStream(pathjava + filename);
                sc = new Scanner(inputStream, "UTF-8");

                while (sc.hasNextLine()){
                    content += sc.nextLine();
                }

                links.add(new String[]{content});
                if (sc.ioException() != null){
                    throw sc.ioException();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (sc != null){
                    sc.close();

                }
                return links;
            }

//            BufferedReader br = null;
//            String line;
//            try {
//
//                br = new BufferedReader(new FileReader(pathjava + filename));
//                while ((line = br.readLine()) != null) {
//                    content+=line;
//                }
//                links.add(new String[]{content});
//
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                closeReader(br);
//                return links;
//            }
    }


    public String getURLJavaDoc(String textWhereFindCoincidences,String wordToFind){
        Document htmlDocument = Jsoup.parse(textWhereFindCoincidences);
        ArrayList<Element> elements = htmlDocument.select("dt > a[href]");

        for (Element element: elements) {
            if(element.text().equals(wordToFind)) {
                return element.attr("href");
            }
        }
        return "";
    }

    public String getBodyFromWebPage(String webPage){
        Document htmlDocument = Jsoup.parse(webPage);
        return htmlDocument.body().select("div.contentContainer").toString();
    }
}
