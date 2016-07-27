import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by HP-PC on 26/07/2016.
 */
public class Configuration {
    private InputStream inputStream;
    private Properties properties;

    /**
     * Constructor that prepares all the values to start reading
     * the configuration file called config.properties
     * @throws IOException
     */
    public Configuration() throws IOException {
        String configurationFile = "resources\\config.properties";
        inputStream = new FileInputStream(configurationFile);
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the name of the file where the snippets are stored
     * from the configuration file.
     * @return The file name
     */
    public String getSnippetsFile() {

        String snippetsFileName = properties.getProperty("snippets");
        return snippetsFileName;
    }

    /**
     * Get the name of the file where the reserved words are stored
     * from the configuration file.
     * @return The file name
     */
    public String getReservedWordsFile() {

        String reservedWordsFileName = properties.getProperty("reservedWords");
        return reservedWordsFileName;
    }
}
