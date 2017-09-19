import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Generator {

    //Generates random String phrase
    String genPhrase(Map<String, List> map) {
        Random r = new Random();
        int firstIndex = r.nextInt(map.get("adj").size());
        int secondIndex = r.nextInt(map.get("noun").size());
        return map.get("adj").get(firstIndex) + " " + map.get("noun").get(secondIndex);
    }

    //Parses File to a List<List<String>>
    Map<String, List> parseFile(String file) {
        File f = new File(file);
        Map<String, List> map = new HashMap<>();
        try{

            //Initialization
            Scanner scanner = new Scanner(f);
            List<String> a = new ArrayList<>();
            List<String> n = new ArrayList<>();

            //While there's still lines in the file to be processed
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parse = line.split(",");
                if (parse[1].contains("a")){
                    a.add(parse[0]);
                }
                else if (parse[1].contains("n")){
                    n.add(parse[0]);
                }
            }

            map.put("adj",a);
            map.put("noun",n);
            return map;

        } catch(FileNotFoundException e){ e.printStackTrace();}

        return null;
    }
}