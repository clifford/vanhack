import java.util.Scanner;

public class SolutionPalindrome {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(palindrome(str) ? "Yes" : "No");
    }

    private static boolean palindrome(String str) {
        for (int i = 0, j = str.length()-1;j>=0;i++,j--) {
            if(i==j) return true; // reached the middle on same character - like 'bob'
            if(str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}
