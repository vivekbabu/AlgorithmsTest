package in.algorithms.interviewprep.validparentheses;

import java.util.*;

// LeetCode 20: Valid Parentheses - https://leetcode.com/problems/valid-parentheses/description/
//
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if
// the input string is valid.
//
// An input string is valid if:
//   1. Open brackets must be closed by the same type of brackets.
//   2. Open brackets must be closed in the correct order.
//   3. Every close bracket has a corresponding open bracket of the same type.
//
// Constraints:
//   - 1 <= s.length <= 10^4
//   - s consists of parentheses only '()[]{}'.
public class ValidParentheses {

    /**
     * Determines whether {@code s} is a correctly nested and matched sequence of the six bracket
     * characters.
     *
     * @param s a non-empty string consisting only of the characters '(', ')', '{', '}', '[', ']'
     * @return {@code true} if every bracket is closed by the same type in the correct order,
     *         {@code false} otherwise
     */
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(map.containsValue(c)) {
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()) return false;

            char value = stack.pop();
            if(value != map.get(c)) return false;
        }

        return stack.isEmpty();
    }
}
