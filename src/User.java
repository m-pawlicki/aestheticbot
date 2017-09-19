import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.TextPost;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

class User {

    //Initialization
    Properties auth = new Properties();
    InputStream input;
    Generator gen = new Generator();

    //User authentication
    JumblrClient authenticateUser(String file) {

        //Open .properties file
        try {
            input = new FileInputStream(file);
            auth.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //OAuth
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

    //Gets blog URL
    String getBlog(String file) {

        //Open .properties file
        try {
            input = new FileInputStream(file);
            auth.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auth.getProperty("blogName");
    }

    //Makes a text post
    void makePost(JumblrClient client){
        try {
            User user = new User();
            TextPost toPost = client.newPost(user.getBlog("config.properties"), TextPost.class);
            toPost.setTitle("");
            toPost.setBody(gen.genPhrase((gen.parseFile("dict"))));
            toPost.addTag("aesthetic");
            toPost.addTag("aesthetics");
            toPost.addTag("aestheticgenbot");
            toPost.save();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}