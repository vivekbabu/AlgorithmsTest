package in.algorithms.interviewprep.validpalindrome;

// LeetCode 125: Valid Palindrome - https://leetcode.com/problems/valid-palindrome/description/
//
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
// removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric
// characters include letters and numbers.
//
// Given a string s, return true if it is a palindrome, or false otherwise.
//
// Constraints:
//   - 1 <= s.length <= 2 * 10^5
//   - s consists only of printable ASCII characters.
public class ValidPalindrome {

    /**
     * Determines whether {@code s} is a palindrome when comparison is restricted to alphanumeric
     * characters and is case-insensitive.
     *
     * @param s the phrase to test; consists only of printable ASCII characters
     * @return {@code true} if the filtered, lower-cased phrase reads the same in both directions
     *         (an empty filtered phrase counts as a palindrome), {@code false} otherwise
     */
    public static boolean isPalindrome(String s) {
        int length = s.length();

        for(int i=0, j = length -1; i<=j; i++, j--) {
            while(i < length && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(j>=0 && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(i> j) break;
            if(Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) return false;
        }

        return true;
    }
}
