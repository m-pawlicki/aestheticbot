import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.TextPost;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

class User {

    static JumblrClient authenticateUser(String file) {

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

    static String getBlog(String file) {

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

    static void makePost(JumblrClient client){
        try {
            TextPost toPost = client.newPost(User.getBlog("config.properties"), TextPost.class);
            toPost.setTitle("");
            Generator gen = new Generator();
            toPost.setBody(Generator.genPost(gen.adjective,gen.noun));
            toPost.addTag("aesthetic");
            toPost.addTag("aesthetics");
            toPost.addTag("aestheticgenbot");
            toPost.save();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}