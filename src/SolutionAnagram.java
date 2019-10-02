import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionAnagram {


    static boolean isAnagram(String a, String b) {
        // Complete the function
        Map<Character, Integer> aFrq = getLetterFrq(a);
        Map<Character, Integer> bFrq = getLetterFrq(b);

        if (aFrq.keySet().size() != bFrq.keySet().size()) return false;

        Integer k;
        for (Map.Entry<Character, Integer> entry : aFrq.entrySet()) {
            if ((k = bFrq.get(entry.getKey())) == null) {
                return false;
            } else {
                if(k != entry.getValue()) return false;
            }
        }
        return true;
    }

    static Map<Character, Integer> getLetterFrq(String str) {
        Map<Character, Integer> result = new HashMap();

        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            chr = Character.isLowerCase(chr) ? chr : Character.toLowerCase(chr);
            Integer cnt;
            if ((cnt = result.get(chr)) == null) {
                result.put(chr, 1);
            } else {
                result.put(chr, cnt + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
