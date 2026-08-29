package in.algorithms.interviewprep.evaluatereversepolishnotation;

import java.util.ArrayDeque;
import java.util.Deque;

// LeetCode 150: Evaluate Reverse Polish Notation
// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
//
// You are given an array of strings tokens that represents an arithmetic expression in a Reverse
// Polish Notation. Evaluate the expression and return an integer that represents its value.
//
// Note that:
//   - The valid operators are '+', '-', '*', and '/'.
//   - Each operand may be an integer or another expression.
//   - The division between two integers always truncates toward zero.
//   - There will not be any division by zero.
//   - The input represents a valid arithmetic expression in Reverse Polish Notation.
//   - The answer and all the intermediate calculations can be represented in a 32-bit integer.
//
// Constraints:
//   - 1 <= tokens.length <= 10^4
//   - tokens[i] is either an operator "+", "-", "*", "/", or an integer in the range [-200, 200].
public class EvaluateReversePolishNotation {

    /**
     * Evaluates the Reverse Polish Notation expression given by {@code tokens} and returns its
     * integer value. Division truncates toward zero.
     *
     * @param tokens a valid RPN expression; each entry is one of "+", "-", "*", "/" or an integer
     *               literal in the range [-200, 200]
     * @return the value of the expression
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String val : tokens) {
            if(val.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Integer.parseInt(val));
                continue;
            }
           int secondVal = stack.pop();
           int firstVal = stack.pop();
           int result = 0;
           switch (val) {
               case "+" : result = firstVal + secondVal;
               break;
               case "-" : result = firstVal - secondVal;
               break;
               case "*" : result = firstVal * secondVal;
               break;
               default : result = firstVal / secondVal;
               break;

           }
           stack.push(result);


        }

        return stack.pop();
    }
}
