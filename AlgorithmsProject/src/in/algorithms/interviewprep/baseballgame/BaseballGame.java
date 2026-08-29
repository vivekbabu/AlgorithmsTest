package in.algorithms.interviewprep.baseballgame;

import java.util.ArrayDeque;
import java.util.Deque;

// LeetCode 682: Baseball Game - https://leetcode.com/problems/baseball-game/description/
//
// You are keeping the scores for a baseball game with strange rules. At the beginning of the game,
// you start with an empty record. You are given a list of strings operations, where operations[i]
// is the i-th operation you must apply to the record and is one of the following:
//
//   - An integer x: Record a new score of x.
//   - "+": Record a new score that is the sum of the previous two scores.
//   - "D": Record a new score that is the double of the previous score.
//   - "C": Invalidate the previous score, removing it from the record.
//
// Return the sum of all the scores on the record after applying all the operations.
//
// The test cases are generated such that the answer and all intermediate calculations fit in a
// 32-bit integer, and all operations are valid.
//
// Constraints:
//   - 1 <= operations.length <= 1000
//   - operations[i] is "C", "D", "+", or a string representing an integer in the range
//     [-3 * 10^4, 3 * 10^4].
//   - For "+" operations, there are at least two previous scores on the record.
//   - For "C" and "D" operations, there is at least one previous score on the record.
public class BaseballGame {

    /**
     * Applies each operation to an initially empty record and returns the sum of the scores that
     * remain on the record afterwards.
     *
     * @param operations the operations to apply, each an integer literal or one of "+", "D", "C"
     * @return the total of all scores left on the record
     */
    public static int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (String value : operations) {

            switch (value) {
                case "C" -> stack.pop();
                case "D" -> stack.push(2 * stack.peek());
                case "+" -> {
                    int lastValue = stack.pop();
                    int sum = stack.peek() + lastValue;
                    stack.push(lastValue);
                    stack.push(sum);
                }
                default -> stack.push(Integer.parseInt(value));
            }

        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
