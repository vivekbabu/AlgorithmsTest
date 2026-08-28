package in.algorithms.interviewprep.issubsequence;

import org.junit.Assert;
import org.junit.Test;

public class IsSubsequenceTest {

    private static void assertIsSubsequence(String s, String t) {
        Assert.assertTrue(
                "expected \"" + s + "\" to be a subsequence of \"" + t + "\"",
                IsSubsequence.isSubsequence(s, t));
    }

    private static void assertIsNotSubsequence(String s, String t) {
        Assert.assertFalse(
                "expected \"" + s + "\" NOT to be a subsequence of \"" + t + "\"",
                IsSubsequence.isSubsequence(s, t));
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // s = "abc", t = "ahbgdc" -> true
        assertIsSubsequence("abc", "ahbgdc");
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // s = "axc", t = "ahbgdc" -> false
        assertIsNotSubsequence("axc", "ahbgdc");
    }

    @Test
    public void testClassicAceIsSubsequenceOfAbcde() {
        assertIsSubsequence("ace", "abcde");
    }

    @Test
    public void testClassicAecIsNotSubsequenceOfAbcde() {
        // relative order is violated
        assertIsNotSubsequence("aec", "abcde");
    }

    // ---------------------------------------------------------------------
    // Empty-string handling (constraints allow length 0 for both)
    // ---------------------------------------------------------------------

    @Test
    public void testEmptySIsSubsequenceOfNonEmptyT() {
        assertIsSubsequence("", "abcde");
    }

    @Test
    public void testEmptySIsSubsequenceOfEmptyT() {
        assertIsSubsequence("", "");
    }

    @Test
    public void testNonEmptySIsNotSubsequenceOfEmptyT() {
        assertIsNotSubsequence("a", "");
    }

    // ---------------------------------------------------------------------
    // Identity and trivial relationships
    // ---------------------------------------------------------------------

    @Test
    public void testStringIsASubsequenceOfItself() {
        assertIsSubsequence("abcdef", "abcdef");
    }

    @Test
    public void testSingleCharacterPresent() {
        assertIsSubsequence("c", "abcde");
    }

    @Test
    public void testSingleCharacterAbsent() {
        assertIsNotSubsequence("z", "abcde");
    }

    @Test
    public void testSCannotBeLongerThanT() {
        assertIsNotSubsequence("abcdef", "abc");
    }

    // ---------------------------------------------------------------------
    // Position of the matched characters within t
    // ---------------------------------------------------------------------

    @Test
    public void testMatchUsesOnlyThePrefixOfT() {
        assertIsSubsequence("abc", "abcxxxxxx");
    }

    @Test
    public void testMatchUsesOnlyTheSuffixOfT() {
        assertIsSubsequence("abc", "xxxxxxabc");
    }

    @Test
    public void testMatchIsSpreadAcrossTWithGaps() {
        assertIsSubsequence("abc", "aXXbXXXcXX");
    }

    @Test
    public void testCharactersPresentButInWrongOrder() {
        assertIsNotSubsequence("cba", "abcdef");
    }

    @Test
    public void testNeedsMoreCopiesOfACharacterThanTProvides() {
        // needs three 'a's, t only has two
        assertIsNotSubsequence("aaa", "aXaX");
    }

    // ---------------------------------------------------------------------
    // Repeated characters
    // ---------------------------------------------------------------------

    @Test
    public void testRepeatedCharactersMatchedGreedilyLeftToRight() {
        assertIsSubsequence("aaa", "aabbaa");
    }

    @Test
    public void testRepeatedCharactersInterleavedWithOthers() {
        assertIsSubsequence("aba", "abracadabra");
    }

    @Test
    public void testTIsAllOneCharacterAndSFits() {
        assertIsSubsequence("aaaa", "aaaaaaa");
    }

    @Test
    public void testTIsAllOneCharacterAndSDoesNotFit() {
        assertIsNotSubsequence("aaaaaaaa", "aaaa");
    }

    @Test
    public void testTIsAllOneCharacterButSNeedsADifferentOne() {
        assertIsNotSubsequence("ab", "aaaaaa");
    }

    // ---------------------------------------------------------------------
    // Near-miss cases (greedy matching must not backtrack incorrectly)
    // ---------------------------------------------------------------------

    @Test
    public void testGreedyMatchStillSucceedsWhenLaterOccurrenceIsNeeded() {
        // "acb": match a@0, then c must come from index 3, then b from index 4.
        assertIsSubsequence("acb", "aXcXb");
    }

    @Test
    public void testLastCharacterOfSMissingFromTail() {
        assertIsNotSubsequence("abcd", "abcXXXX");
    }

    @Test
    public void testFirstCharacterOfSMissingFromHead() {
        assertIsNotSubsequence("zabc", "abcabc");
    }

    // ---------------------------------------------------------------------
    // Larger inputs (constraints: |s| <= 100, |t| <= 10^4)
    // ---------------------------------------------------------------------

    @Test
    public void testLongTContainingSAsEveryNthCharacter() {
        int sLen = 100;
        int gap = 50;
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < sLen; i++) {
            char c = (char) ('a' + (i % 26));
            s.append(c);
            for (int g = 0; g < gap - 1; g++) {
                // filler that is guaranteed not to be the next needed char
                t.append((char) ('a' + ((i + 13) % 26)));
            }
            t.append(c);
        }
        assertIsSubsequence(s.toString(), t.toString());
    }

    @Test
    public void testLongTThatIsMissingExactlyTheLastNeededCharacter() {
        int sLen = 100;
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < sLen; i++) {
            s.append('a');
        }
        // t has 99 'a's spread through 10000 chars, but never a 100th.
        for (int i = 0; i < 10_000; i++) {
            t.append('b');
        }
        for (int i = 0; i < sLen - 1; i++) {
            t.setCharAt(i * 100, 'a');
        }
        assertIsNotSubsequence(s.toString(), t.toString());
    }

    @Test
    public void testMaxLengthTEqualToRepeatedAlphabetWithSAsTheAlphabet() {
        StringBuilder t = new StringBuilder();
        while (t.length() < 10_000) {
            t.append("abcdefghijklmnopqrstuvwxyz");
        }
        // Against a fully repeated alphabet almost any short in-order OR reversed string fits,
        // because there are hundreds of blocks to draw from.
        assertIsSubsequence("abcdefghijklmnopqrstuvwxyz", t.substring(0, 10_000));
        assertIsSubsequence("aabbccddeeffgg", t.substring(0, 10_000));
        assertIsSubsequence("zyx", t.substring(0, 10_000)); // z, then y/x from later blocks

        // But a single alphabet block (26 chars) cannot supply a repeated-then-earlier pattern.
        assertIsNotSubsequence("aa", "abcdefghijklmnopqrstuvwxyz");
        assertIsNotSubsequence("ba", "abcdefghijklmnopqrstuvwxyz");
    }

    // ---------------------------------------------------------------------
    // Follow-up spirit: same t, many different s
    // ---------------------------------------------------------------------

    @Test
    public void testManyQueriesAgainstTheSameT() {
        String t = "abpcplea";
        assertIsSubsequence("ale", t);
        assertIsSubsequence("apple", t);
        assertIsNotSubsequence("monkey", t);
        assertIsNotSubsequence("bb", t);   // t = "abpcplea" has only one 'b'
        assertIsSubsequence("plea", t);    // p@2, l@5, e@6, a@7
        assertIsSubsequence("acplea", t);
        assertIsSubsequence("", t);
        assertIsSubsequence(t, t);
    }
}
