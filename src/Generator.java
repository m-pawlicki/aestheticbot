import java.util.Random;

public class Generator {

    //Initialization
    static String[] adjective =
            {"soft", "grunge", "punk", "trash", "vaporwave", "indie", "pastel", "kawaii", "vintage", "forest", "space", "ocean", "vapor", "dark", "light", "toasty", "glitch"};
    static String[] noun =
            {"trash", "dad", "mom", "opossum", "dog", "cat", "meme", "taco", "gay", "lesbian", "bi", "trans", "goth", "punk", "wave", "shoe", "Danny DeVito"};

    //Generates random String phrase
    String genPhrase(String[] s1, String[] s2) {
        Random r = new Random();
        int firstIndex = r.nextInt(s1.length);
        int secondIndex = r.nextInt(s2.length);
        return s1[firstIndex] + " " + s2[secondIndex];
    }
}