import com.tumblr.jumblr.JumblrClient;

class AestheticGenerator {

    public static void main(String args[]) {

        //Initialization
        User blog = new User();

        //Authenticate new user
        JumblrClient client = blog.authenticateUser("config.properties");

        // Make a new post
        blog.makePost(client);
    }
}