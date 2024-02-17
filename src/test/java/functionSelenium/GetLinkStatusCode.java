package functionSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetLinkStatusCode {
    static int invalidLink;

    public static void verifyLink(String linkString) {
        try {
            URL url = new URL(linkString);
            // Open HTTP connection
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            // Timeout
            urlConnect.setConnectTimeout(5000);

            // Hit URL
            urlConnect.connect();
            int responseCode = urlConnect.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println(linkString + ": " + urlConnect.getResponseMessage() + " : " + responseCode);
                invalidLink++;
            }

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + linkString);
            invalidLink++;
        } catch (IOException e) {
            System.out.println("IOException for URL: " + linkString);
            e.printStackTrace();
            invalidLink++;
        }
    }

    public static void getInvalidLinkCount() {
        System.out.println("Total invalid Links: " + invalidLink);
    }
}
