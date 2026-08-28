package in.algorithms.interviewprep.issubsequence;

// LeetCode 392: Is Subsequence - https://leetcode.com/problems/is-subsequence/description/
//
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//
// A subsequence of a string is a new string that is formed from the original string by deleting
// some (can be none) of the characters without disturbing the relative positions of the remaining
// characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.)
//
// Constraints:
//   - 0 <= s.length <= 100
//   - 0 <= t.length <= 10^4
//   - s and t consist only of lowercase English letters.
//
// Follow-up: if there are many incoming s (say k >= 10^9) to be checked one by one against the
// same t, how would you change the code?
public class IsSubsequence {

    /**
     * Determines whether {@code s} can be obtained from {@code t} by deleting zero or more
     * characters of {@code t} without reordering the ones that remain.
     *
     * @param s the candidate subsequence (may be empty)
     * @param t the string to search within (may be empty)
     * @return {@code true} if {@code s} is a subsequence of {@code t}; the empty string is a
     *         subsequence of every string
     */
    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) return true;
        if(s.isEmpty()) return true;
        if(t.isEmpty()) return false;

        if(s.charAt(0) == t.charAt(0)) return  isSubsequence(s.substring(1), t.substring(1));

        return isSubsequence(s, t.substring(1));
    }
}
