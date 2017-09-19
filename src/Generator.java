import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Generator {

    //Generates random String phrase
    String genPhrase(List<List<String>> lists) {
        Random r = new Random();
        int firstIndex = r.nextInt(lists.get(0).size());
        int secondIndex = r.nextInt(lists.get(1).size());
        return lists.get(0).get(firstIndex) + " " + lists.get(1).get(secondIndex);
    }

    //Parses File to a List<List<String>>
    List<List<String>> parseFile(String file) {
        File f = new File(file);
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

            List<List<String>> superList = new ArrayList<>();
            superList.add(a);
            superList.add(n);
            return superList;

        } catch(FileNotFoundException e){ e.printStackTrace();}

        return null;
    }
}