package in.algorithms.interviewprep.reversestring;

// LeetCode 344: Reverse String - https://leetcode.com/problems/reverse-string/description/
//
// Write a function that reverses a string. The input string is given as an array of characters s.
// You must do this by modifying the input array in-place with O(1) extra memory.
//
// Constraints:
//   - 1 <= s.length <= 10^5
//   - s[i] is a printable ASCII character.
public class ReverseString {

    /**
     * Reverses the character array {@code s} in place, using only constant extra memory.
     *
     * @param s the characters to reverse in place
     */
    public static void reverseString(char[] s) {
        int length = s.length;

        for(int i =0, j=length - 1; i<=j; i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
