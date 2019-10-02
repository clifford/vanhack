
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

public class Solution {



    // Complete the numberOfCharactersEscaped function below.
    static int numberOfCharactersEscaped(String expression) {
        List<Integer> indices = indicesOf(expression, '#');
        Pattern pattern = Pattern.compile("(![a-z]{1})");
        int count = 0;

        for(int i = 0, j=0; i<indices.size()/2; i++, j+=2) {
            int p1 = indices.get(j);
            int p2 = indices.get(j+1);
            Matcher matcher = pattern.matcher(expression.substring(p1+1,p2));

            while (matcher.find())
                count++;
        }
        return count;
    }

    static List<Integer> indicesOf(String expression, char charToFind) {
        List<Integer> indices = new ArrayList();
        int index = expression.indexOf(charToFind);

        while(index >= 0) {
            indices.add(index);
            index = expression.indexOf(charToFind, index+1);
        }
        return indices;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String expression = bufferedReader.readLine();

        int res = numberOfCharactersEscaped(expression);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
