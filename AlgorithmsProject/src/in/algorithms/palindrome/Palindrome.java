package in.algorithms.palindrome;

public class Palindrome {
    public static boolean palindromeCheck(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("malayalam is palindrome: " + palindromeCheck("malayalam"));
    }
}
