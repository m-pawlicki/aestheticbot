import java.io.*;
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

        //Initialization
        Map<String, List> map = new HashMap<>();
        List<String> a = new ArrayList<>();
        List<String> n = new ArrayList<>();
        String line;

        try{

            //Read from file in UTF-8
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));

            //While there's still lines in the file to be processed
            while ((line = br.readLine()) != null) {
                String[] parse = line.split(",");
                if (parse[1].contains("a")){
                    a.add(parse[0]);
                }
                else if (parse[1].contains("n")){
                    n.add(parse[0]);
                }
            }

            br.close();
            map.put("adj",a);
            map.put("noun",n);
            return map;

        } catch(IOException e){ e.printStackTrace();}

        return null;
    }
}