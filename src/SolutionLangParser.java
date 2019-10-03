import java.util.Map;
import java.util.Scanner;

public class SolutionLangParser {

    /**
     * Given a dictionary of known words, find all the words in a foreign language which has no delimiters
     * theirhouseeeeee  -> their house
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] dictionary = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};
        System.out.println(segment("ilikesamsung", dictionary));
    }

    public static String contains(String[] dict, String word) {
        for(int i=0;i<dict.length-1;i++) {
            if(dict[i].equals(word)) return word;
        }
        return null;
    }

    public static String segment(String text, String[] dict) {
        String word, r = "";

        for (int i = 0; i <= text.length(); i++) {
            if ((word = contains(dict, text.substring(0, i))) != null) { // found word in dict
                String remaining = text.substring(i, text.length());
                if(remaining.isEmpty()) return word;
                if((r = segment(remaining, dict)) != null) { // recursive call found word
                    System.out.println("r:"+r);
                    return word.concat(" ").concat(r);
                }

            }
        }
        return null;
    }
}
