import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.TextPost;

class AestheticGenerator {

    public static void main(String args[]) {

        //Authenticate new user
        JumblrClient client = User.authenticateUser("config.properties");

        // Make a new post
        User.makePost(client);
    }
}