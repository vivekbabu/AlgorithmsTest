package in.algorithms.interviewprep.validparentheses;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesesTest {

    private static void assertValid(String s) {
        Assert.assertTrue("expected \"" + s + "\" to be valid", ValidParentheses.isValid(s));
    }

    private static void assertInvalid(String s) {
        Assert.assertFalse("expected \"" + s + "\" to be invalid", ValidParentheses.isValid(s));
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // "()" -> true
        assertValid("()");
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // "()[]{}" -> true
        assertValid("()[]{}");
    }

    @Test
    public void testProblemStatementExampleThree() {
        // "(]" -> false
        assertInvalid("(]");
    }

    @Test
    public void testProblemStatementExampleFour() {
        // "([])" -> true
        assertValid("([])");
    }

    @Test
    public void testProblemStatementExampleFive() {
        // "([)]" -> false (wrong closing order)
        assertInvalid("([)]");
    }

    // ---------------------------------------------------------------------
    // Smallest inputs (constraint: length >= 1)
    // ---------------------------------------------------------------------

    @Test
    public void testSingleOpenBracketIsInvalid() {
        assertInvalid("(");
        assertInvalid("[");
        assertInvalid("{");
    }

    @Test
    public void testSingleCloseBracketIsInvalid() {
        assertInvalid(")");
        assertInvalid("]");
        assertInvalid("}");
    }

    @Test
    public void testEachMatchingPairAlone() {
        assertValid("()");
        assertValid("[]");
        assertValid("{}");
    }

    // ---------------------------------------------------------------------
    // Nesting
    // ---------------------------------------------------------------------

    @Test
    public void testDeeplyNestedSameType() {
        assertValid("((((()))))");
    }

    @Test
    public void testDeeplyNestedMixedTypes() {
        assertValid("([{([{}])}])");
    }

    @Test
    public void testNestedThenSequential() {
        assertValid("({}[]){}");
    }

    @Test
    public void testValidPairInsideValidPair() {
        assertValid("{[()()]}");
    }

    // ---------------------------------------------------------------------
    // Ordering violations
    // ---------------------------------------------------------------------

    @Test
    public void testCloseBeforeOpen() {
        assertInvalid(")(");
    }

    @Test
    public void testCloseBeforeOpenMixed() {
        assertInvalid("]{}[");
    }

    @Test
    public void testInterleavedNotNested() {
        assertInvalid("([)]");
        assertInvalid("{[}]");
        assertInvalid("({[)}]");
    }

    @Test
    public void testCorrectCountsButWrongPairing() {
        // Three opens, three closes, but types don't line up in order.
        assertInvalid("([{)]}");
    }

    // ---------------------------------------------------------------------
    // Unbalanced counts
    // ---------------------------------------------------------------------

    @Test
    public void testMoreOpensThanCloses() {
        assertInvalid("(()");
        assertInvalid("((())");
        assertInvalid("{[()]");
    }

    @Test
    public void testMoreClosesThanOpens() {
        assertInvalid("())");
        assertInvalid("(())]");
        assertInvalid("{[()]}}");
    }

    @Test
    public void testOnlyOpens() {
        assertInvalid("(((");
        assertInvalid("([{");
    }

    @Test
    public void testOnlyCloses() {
        assertInvalid(")))");
        assertInvalid(")]}");
    }

    // ---------------------------------------------------------------------
    // Type-mismatch on close
    // ---------------------------------------------------------------------

    @Test
    public void testWrongClosingTypeForSingleOpen() {
        assertInvalid("(]");
        assertInvalid("(}");
        assertInvalid("[)");
        assertInvalid("[}");
        assertInvalid("{)");
        assertInvalid("{]");
    }

    @Test
    public void testWrongClosingTypeAfterValidPrefix() {
        assertInvalid("()[}");
        assertInvalid("(){]");
        assertInvalid("[]{)");
    }

    // ---------------------------------------------------------------------
    // Longer valid sequences
    // ---------------------------------------------------------------------

    @Test
    public void testLongAlternatingPairs() {
        assertValid("()()()()()()");
    }

    @Test
    public void testLongMixedButBalanced() {
        assertValid("{}[]()({[]})[({})]{}");
    }

    @Test
    public void testStaircaseNesting() {
        assertValid("(((((((((())))))))))");
    }

    // ---------------------------------------------------------------------
    // Large inputs (constraint upper bound: 10^4)
    // ---------------------------------------------------------------------

    @Test
    public void testLargeBalancedNesting() {
        int depth = 5_000; // 5000 '(' + 5000 ')' = 10000 chars
        StringBuilder sb = new StringBuilder(2 * depth);
        for (int i = 0; i < depth; i++) {
            sb.append('(');
        }
        for (int i = 0; i < depth; i++) {
            sb.append(')');
        }
        assertValid(sb.toString());
    }

    @Test
    public void testLargeBalancedRepeatedPairs() {
        int pairs = 5_000; // 10000 chars
        StringBuilder sb = new StringBuilder(2 * pairs);
        String[] units = {"()", "[]", "{}"};
        for (int i = 0; i < pairs; i++) {
            sb.append(units[i % 3]);
        }
        assertValid(sb.toString());
    }

    @Test
    public void testLargeNestingWithASingleMismatchInTheMiddle() {
        int depth = 2_500;
        StringBuilder sb = new StringBuilder(4 * depth);
        for (int i = 0; i < depth; i++) {
            sb.append('(');
        }
        sb.append(']'); // one intruder that cannot match the '(' on top of the stack
        for (int i = 0; i < depth; i++) {
            sb.append(')');
        }
        assertInvalid(sb.toString());
    }

    @Test
    public void testLargeNearMissMissingFinalCloser() {
        int depth = 5_000;
        StringBuilder sb = new StringBuilder(2 * depth);
        for (int i = 0; i < depth; i++) {
            sb.append('{');
        }
        for (int i = 0; i < depth - 1; i++) { // one closer short
            sb.append('}');
        }
        assertInvalid(sb.toString());
    }

    @Test
    public void testLargeNearMissOneExtraCloser() {
        int depth = 5_000;
        StringBuilder sb = new StringBuilder(2 * depth + 1);
        for (int i = 0; i < depth; i++) {
            sb.append('[');
        }
        for (int i = 0; i < depth + 1; i++) { // one closer too many
            sb.append(']');
        }
        assertInvalid(sb.toString());
    }

    @Test
    public void testLargeValidSequenceWithSwappedAdjacentClosersNearTheEnd() {
        // Build a valid deeply-nested string, then swap the last two closers to break order.
        int depth = 3_000;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append('(').append('[');
        }
        for (int i = 0; i < depth; i++) {
            sb.append(']').append(')');
        }
        // Valid as built; now corrupt near the very end.
        int len = sb.length();
        char a = sb.charAt(len - 2);
        char b = sb.charAt(len - 1);
        sb.setCharAt(len - 2, b);
        sb.setCharAt(len - 1, a);
        assertInvalid(sb.toString());
    }
}
