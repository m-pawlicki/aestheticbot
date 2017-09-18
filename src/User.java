import com.tumblr.jumblr.JumblrClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

class User {

    public static JumblrClient authenticateUser(String file) {

        //Initialize data
        Properties auth = new Properties();
        InputStream input;

        //Open .properties file
        try {
            input = new FileInputStream(file);
            auth.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Authenticate via OAuth
        JumblrClient client = new JumblrClient(
                auth.getProperty("consumerKey"),
                auth.getProperty("consumerSecret")
        );

        client.setToken(
                auth.getProperty("token"),
                auth.getProperty("tokenSecret")
        );
        return client;
    }

    public static String getBlog(String file) {

        //Initialize data
        Properties auth = new Properties();
        InputStream input;

        //Open .properties file
        try {
            input = new FileInputStream(file);
            auth.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auth.getProperty("blogName");
    }
}