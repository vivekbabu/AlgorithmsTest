package in.algorithms.palindrome;

public class Palindrome {
    public static boolean palindromeCheck(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
