package Classes;
import javax.swing.*;
import java.lang.reflect.Method;

/**
 * Created by AngelaValdez on 8/2/2016.
 */
public class BareBonesBrowserLaunch {
    /**
     * Error message in case that the operation won't be executed
     */
    private static final String errMsg = "Error trying to open browser";

    public static void openURL(String url) {
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Mac OS")) {
                //MAC
                @SuppressWarnings("rawtypes")
                Class fileMgr = Class.forName("com.apple.eio.FileManager");
                @SuppressWarnings("unchecked")
                Method openURL = fileMgr.getDeclaredMethod("openURL",
                        new Class[]{String.class});
                openURL.invoke(null, new Object[]{url});
            } else if (osName.startsWith("Windows")) {
                //Windows
                Runtime.getRuntime().exec(
                        "rundll32 url.dll,FileProtocolHandler " + url);
            } else {
                //Linux
                String[] browsers = {"firefox", "opera", "konqueror",
                        "epiphany", "mozilla", "netscape"};
                String browser = null;
                for (int count = 0; count < browsers.length && browser == null; count++) {
                    if (Runtime.getRuntime().exec(
                            new String[]{"which", browsers[count]}).waitFor() == 0) {
                        browser = browsers[count];
                    }
                }
                if (browser == null) {
                    throw new Exception("Browser didn't found!");
                } else {
                    Runtime.getRuntime().exec(new String[]{browser, url});
                }
            }
        } catch (Exception e) {
            //Show error message
            JOptionPane.showMessageDialog(null, errMsg + ":\n"
                    + e.getLocalizedMessage());
        }
    }
}