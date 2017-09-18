import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.TextPost;
import java.io.IOException;
import java.util.Random;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

class AestheticGenerator {
    public static void main(String args[]) {

        //Initialize data
        String[] adjective =
                {"soft", "grunge", "punk", "trash", "vaporwave", "indie", "pastel", "kawaii", "vintage", "forest", "space", "ocean", "vapor", "dark", "light", "toasty", "glitch"};
        String[] noun =
                {"trash", "dad", "mom", "opossum", "dog", "cat", "meme", "taco", "gay", "lesbian", "bi", "trans", "goth", "punk", "wave", "shoe", "Danny DeVito"};

        Properties auth = new Properties();
        InputStream input;

        try{
            input = new FileInputStream("config.properties");
            auth.load(input);
        } catch (IOException e){ e.printStackTrace();}

        // Authenticate via OAuth
        JumblrClient client = new JumblrClient(
                auth.getProperty("consumerKey"),
                auth.getProperty("consumerSecret")
        );
        client.setToken(
                auth.getProperty("token"),
                auth.getProperty("tokenSecret")
        );

        // Make a new post
        try {
            final AestheticGenerator textBody = new AestheticGenerator();
            final TextPost toPost = client.newPost("aestheticgenbot.tumblr.com", TextPost.class);
            toPost.setTitle("");
            toPost.setBody(textBody.genPost(adjective, noun));
            toPost.addTag("aesthetic");
            toPost.addTag("aesthetics");
            toPost.addTag("aestheticgenbot");
            toPost.save();
        } catch (IllegalAccessException | InstantiationException e){
            e.printStackTrace();
        }
    }

    private String genPost(String[] s1, String[] s2) {
        Random r = new Random();
        int firstIndex = r.nextInt(s1.length);
        int secondIndex = r.nextInt(s2.length);
        return s1[firstIndex] + " " + s2[secondIndex];
    }
}