package in.algorithms.interviewprep.evaluatereversepolishnotation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class EvaluateReversePolishNotationTest {

    private static void assertEval(String[] tokens, int expected) {
        int actual = EvaluateReversePolishNotation.evalRPN(tokens);
        Assert.assertEquals(
                "evalRPN(" + Arrays.toString(tokens) + ")",
                expected, actual);
    }

    /** Independent reference evaluator using an explicit operand stack. */
    private static int reference(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    int r;
                    switch (token) {
                        case "+": r = a + b; break;
                        case "-": r = a - b; break;
                        case "*": r = a * b; break;
                        default:  r = a / b; break; // Java integer division truncates toward zero
                    }
                    stack.push(r);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // ["2","1","+","3","*"] -> ((2 + 1) * 3) = 9
        assertEval(new String[]{"2", "1", "+", "3", "*"}, 9);
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // ["4","13","5","/","+"] -> (4 + (13 / 5)) = 4 + 2 = 6
        assertEval(new String[]{"4", "13", "5", "/", "+"}, 6);
    }

    @Test
    public void testProblemStatementExampleThree() {
        // ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        // -> ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
        assertEval(new String[]{
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        }, 22);
    }

    // ---------------------------------------------------------------------
    // Single token (constraint: length >= 1)
    // ---------------------------------------------------------------------

    @Test
    public void testSinglePositiveNumber() {
        assertEval(new String[]{"42"}, 42);
    }

    @Test
    public void testSingleNegativeNumber() {
        assertEval(new String[]{"-200"}, -200);
    }

    @Test
    public void testSingleZero() {
        assertEval(new String[]{"0"}, 0);
    }

    // ---------------------------------------------------------------------
    // One operation per operator
    // ---------------------------------------------------------------------

    @Test
    public void testAddition() {
        assertEval(new String[]{"7", "5", "+"}, 12);
    }

    @Test
    public void testSubtractionIsOrderSensitive() {
        // "a b -" means a - b, not b - a
        assertEval(new String[]{"7", "5", "-"}, 2);
        assertEval(new String[]{"5", "7", "-"}, -2);
    }

    @Test
    public void testMultiplication() {
        assertEval(new String[]{"6", "7", "*"}, 42);
        assertEval(new String[]{"-6", "7", "*"}, -42);
        assertEval(new String[]{"-6", "-7", "*"}, 42);
    }

    @Test
    public void testDivisionIsOrderSensitive() {
        // "a b /" means a / b
        assertEval(new String[]{"20", "4", "/"}, 5);
        assertEval(new String[]{"4", "20", "/"}, 0);
    }

    // ---------------------------------------------------------------------
    // Division truncates toward zero (not floor)
    // ---------------------------------------------------------------------

    @Test
    public void testDivisionTruncatesTowardZeroForPositiveResult() {
        assertEval(new String[]{"13", "5", "/"}, 2);   // 2.6 -> 2
        assertEval(new String[]{"7", "2", "/"}, 3);    // 3.5 -> 3
    }

    @Test
    public void testDivisionTruncatesTowardZeroForNegativeResult() {
        assertEval(new String[]{"-13", "5", "/"}, -2); // -2.6 -> -2 (toward zero, NOT -3)
        assertEval(new String[]{"13", "-5", "/"}, -2); // -2.6 -> -2
        assertEval(new String[]{"-7", "2", "/"}, -3);  // -3.5 -> -3
        assertEval(new String[]{"7", "-2", "/"}, -3);  // -3.5 -> -3
    }

    @Test
    public void testDivisionOfTwoNegativesIsPositiveAndTruncates() {
        assertEval(new String[]{"-13", "-5", "/"}, 2); // 2.6 -> 2
    }

    @Test
    public void testDivisionResultingInZero() {
        assertEval(new String[]{"3", "7", "/"}, 0);
        assertEval(new String[]{"-3", "7", "/"}, 0);
        assertEval(new String[]{"0", "9", "/"}, 0);
    }

    @Test
    public void testExactDivision() {
        assertEval(new String[]{"100", "25", "/"}, 4);
        assertEval(new String[]{"-100", "25", "/"}, -4);
    }

    // ---------------------------------------------------------------------
    // Nesting and evaluation order
    // ---------------------------------------------------------------------

    @Test
    public void testLeftToRightChainOfAdditions() {
        // ((((1 + 2) + 3) + 4) + 5) = 15
        assertEval(new String[]{"1", "2", "+", "3", "+", "4", "+", "5", "+"}, 15);
    }

    @Test
    public void testChainOfSubtractionsRespectsOperandOrder() {
        // ((10 - 2) - 3) = 5
        assertEval(new String[]{"10", "2", "-", "3", "-"}, 5);
    }

    @Test
    public void testMixedPrecedenceIsDeterminedByStructureNotByOperator() {
        // "2 3 + 4 *" = (2 + 3) * 4 = 20   (no operator precedence in RPN)
        assertEval(new String[]{"2", "3", "+", "4", "*"}, 20);
        // "2 3 4 * +" = 2 + (3 * 4) = 14
        assertEval(new String[]{"2", "3", "4", "*", "+"}, 14);
    }

    @Test
    public void testDeeplyNestedExpression() {
        // (((2 * 3) + (4 * 5)) - ((6 / 2) + 1)) = (6 + 20) - (3 + 1) = 22
        assertEval(new String[]{
                "2", "3", "*", "4", "5", "*", "+", "6", "2", "/", "1", "+", "-"
        }, 22);
    }

    @Test
    public void testExpressionThatUsesEveryOperator() {
        // "15 7 1 1 + - / 3 *" = 15 / (7 - (1 + 1)) * 3 = 15 / 5 * 3 = 3 * 3 = 9
        assertEval(new String[]{"15", "7", "1", "1", "+", "-", "/", "3", "*"}, 9);
        // then " ... 2 1 1 + + -" = 9 - (2 + (1 + 1)) = 9 - 4 = 5
        assertEval(new String[]{
                "15", "7", "1", "1", "+", "-", "/", "3", "*", "2", "1", "1", "+", "+", "-"
        }, 5);
    }

    // ---------------------------------------------------------------------
    // Negative literals and zero operands
    // ---------------------------------------------------------------------

    @Test
    public void testNegativeLiteralsAreParsedNotTreatedAsSubtraction() {
        assertEval(new String[]{"-3", "-4", "+"}, -7);
        assertEval(new String[]{"-3", "4", "*"}, -12);
        assertEval(new String[]{"5", "-2", "-"}, 7); // 5 - (-2) = 7
    }

    @Test
    public void testZeroOperands() {
        assertEval(new String[]{"0", "0", "+"}, 0);
        assertEval(new String[]{"0", "5", "-"}, -5);
        assertEval(new String[]{"0", "9", "*"}, 0);
        assertEval(new String[]{"5", "0", "*"}, 0);
    }

    @Test
    public void testResultCanBeNegative() {
        // (3 - 10) * 4 = -28
        assertEval(new String[]{"3", "10", "-", "4", "*"}, -28);
    }

    // ---------------------------------------------------------------------
    // Value range (constraint: literals in [-200, 200])
    // ---------------------------------------------------------------------

    @Test
    public void testBoundaryLiteralValues() {
        assertEval(new String[]{"200", "200", "+"}, 400);
        assertEval(new String[]{"-200", "-200", "+"}, -400);
        assertEval(new String[]{"200", "-200", "*"}, -40000);
        assertEval(new String[]{"-200", "-200", "*"}, 40000);
    }

    @Test
    public void testIntermediateValuesLargerThanLiteralRange() {
        // 200 * 200 = 40000, then 40000 / 3 = 13333 (truncated)
        assertEval(new String[]{"200", "200", "*", "3", "/"}, 13333);
    }

    // ---------------------------------------------------------------------
    // Cross-check against an independent reference
    // ---------------------------------------------------------------------

    @Test
    public void testHandBuiltExpressionsAgainstReference() {
        String[][] cases = {
                {"3"},
                {"-200"},
                {"1", "2", "3", "+", "+"},
                {"9", "3", "/", "2", "*"},
                {"100", "7", "-", "6", "/"},
                {"200", "199", "-", "198", "*"},
                {"-50", "50", "+", "10", "/"},
                {"7", "2", "/", "3", "2", "/", "-"},
        };
        for (String[] tokens : cases) {
            assertEval(tokens, reference(tokens));
        }
    }

    @Test
    public void testRandomValidExpressionsAgainstReference() {
        final long seed = 150_20260829L;
        final int magnitudeCap = 1_000_000; // keep every intermediate value well inside a 32-bit int
        Random random = new Random(seed);

        for (int trial = 0; trial < 400; trial++) {
            // Build a random valid postfix expression by simulating the operand stack depth and
            // the running magnitude of the top values so nothing overflows or divides by zero.
            java.util.List<String> tokens = new java.util.ArrayList<>();
            Deque<Integer> model = new ArrayDeque<>();

            int steps = 1 + random.nextInt(300);
            for (int i = 0; i < steps; i++) {
                boolean canApplyOperator = model.size() >= 2;
                boolean forcePushAtEnd = (i == steps - 1) && model.size() != 1;

                if (!canApplyOperator || forcePushAtEnd || random.nextInt(3) == 0) {
                    int value = random.nextInt(401) - 200; // [-200, 200]
                    tokens.add(Integer.toString(value));
                    model.push(value);
                } else {
                    int b = model.pop();
                    int a = model.pop();
                    String[] ops = {"+", "-", "*", "/"};
                    // Pick an operator whose result is safe (no div-by-zero, bounded magnitude).
                    String chosen = null;
                    int[] order = {random.nextInt(4), 0, 1, 2, 3};
                    for (int idx : order) {
                        String op = ops[idx % 4];
                        if (op.equals("/") && b == 0) {
                            continue;
                        }
                        long r;
                        switch (op) {
                            case "+": r = (long) a + b; break;
                            case "-": r = (long) a - b; break;
                            case "*": r = (long) a * b; break;
                            default:  r = a / b; break;
                        }
                        if (Math.abs(r) <= magnitudeCap) {
                            chosen = op;
                            break;
                        }
                    }
                    if (chosen == null) {
                        chosen = (b == 0) ? "+" : "/"; // both are always safe here
                    }
                    int result;
                    switch (chosen) {
                        case "+": result = a + b; break;
                        case "-": result = a - b; break;
                        case "*": result = a * b; break;
                        default:  result = a / b; break;
                    }
                    tokens.add(chosen);
                    model.push(result);
                }
            }

            // Reduce any remaining operands down to a single value with safe "+" operations.
            while (model.size() >= 2) {
                int b = model.pop();
                int a = model.pop();
                tokens.add("+");
                model.push(a + b);
            }

            String[] arr = tokens.toArray(new String[0]);
            assertEval(arr, reference(arr));
        }
    }

    // ---------------------------------------------------------------------
    // Large input (constraint upper bound: 10^4 tokens)
    // ---------------------------------------------------------------------

    @Test
    public void testLargeRunningSum() {
        // "1 1 + 1 + 1 + ..." : one seed operand then alternating "1","+".
        java.util.List<String> tokens = new java.util.ArrayList<>();
        tokens.add("0");
        int additions = 4999; // total tokens = 1 + 2 * 4999 = 9999
        for (int i = 0; i < additions; i++) {
            tokens.add("1");
            tokens.add("+");
        }
        assertEval(tokens.toArray(new String[0]), additions);
    }

    @Test
    public void testLargeAlternatingAddSubNetsToZero() {
        // 0, then (+1 -1) repeated: stays bounded and ends at 0.
        java.util.List<String> tokens = new java.util.ArrayList<>();
        tokens.add("0");
        for (int i = 0; i < 2499; i++) {
            tokens.add("1");
            tokens.add("+");
            tokens.add("1");
            tokens.add("-");
        }
        assertEval(tokens.toArray(new String[0]), 0);
    }

    @Test
    public void testLargeExpressionAgainstReference() {
        Random random = new Random(9_999L);
        java.util.List<String> tokens = new java.util.ArrayList<>();
        tokens.add(Integer.toString(random.nextInt(401) - 200));
        // Keep a single accumulator on the stack: push an operand then an operator each round.
        int rounds = 4000; // ~8001 tokens
        int acc = Integer.parseInt(tokens.get(0));
        for (int i = 0; i < rounds; i++) {
            int operand = random.nextInt(401) - 200;
            String op;
            if (operand == 0) {
                op = (random.nextBoolean()) ? "+" : "-"; // avoid "/" by zero
            } else {
                String[] ops = {"+", "-", "*", "/"};
                op = ops[random.nextInt(4)];
            }
            // Guard magnitude so the reference (int) stays exact.
            long candidate;
            switch (op) {
                case "+": candidate = (long) acc + operand; break;
                case "-": candidate = (long) acc - operand; break;
                case "*": candidate = (long) acc * operand; break;
                default:  candidate = (long) acc / operand; break;
            }
            if (Math.abs(candidate) > 1_000_000) {
                op = "-"; // pull back toward zero
                candidate = (long) acc - operand;
            }
            tokens.add(Integer.toString(operand));
            tokens.add(op);
            acc = (int) candidate;
        }
        String[] arr = tokens.toArray(new String[0]);
        assertEval(arr, reference(arr));
        assertEval(arr, acc);
    }
}
