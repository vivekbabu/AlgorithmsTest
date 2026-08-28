package in.algorithms.interviewprep.reversestring;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ReverseStringTest {

    /** Runs the solution in place on {@code input.toCharArray()} and asserts the result spells {@code expected}. */
    private static void assertReverses(String input, String expected) {
        char[] s = input.toCharArray();

        ReverseString.reverseString(s);

        Assert.assertEquals(
                "reverseString(\"" + input + "\") -> \"" + new String(s) + "\"",
                expected, new String(s));
    }

    /** Reverses {@code input} with StringBuilder and checks the solution agrees. */
    private static void assertReverses(String input) {
        assertReverses(input, new StringBuilder(input).reverse().toString());
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // ["h","e","l","l","o"] -> ["o","l","l","e","h"]
        assertReverses("hello", "olleh");
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // ["H","a","n","n","a","h"] -> ["h","a","n","n","a","H"]
        assertReverses("Hannah", "hannaH");
    }

    // ---------------------------------------------------------------------
    // Minimal inputs (constraint: length >= 1)
    // ---------------------------------------------------------------------

    @Test
    public void testSingleCharacterIsUnchanged() {
        assertReverses("x", "x");
    }

    @Test
    public void testSingleSpaceCharacter() {
        assertReverses(" ", " ");
    }

    @Test
    public void testTwoCharactersAreSwapped() {
        assertReverses("ab", "ba");
    }

    @Test
    public void testTwoIdenticalCharacters() {
        assertReverses("aa", "aa");
    }

    // ---------------------------------------------------------------------
    // Even vs odd length
    // ---------------------------------------------------------------------

    @Test
    public void testEvenLength() {
        assertReverses("abcd", "dcba");
    }

    @Test
    public void testOddLengthKeepsMiddleCharacterInPlace() {
        assertReverses("abcde", "edcba");
    }

    // ---------------------------------------------------------------------
    // Palindromes come back unchanged
    // ---------------------------------------------------------------------

    @Test
    public void testEvenLengthPalindromeIsUnchanged() {
        assertReverses("abba", "abba");
    }

    @Test
    public void testOddLengthPalindromeIsUnchanged() {
        assertReverses("racecar", "racecar");
    }

    // ---------------------------------------------------------------------
    // Character variety across printable ASCII
    // ---------------------------------------------------------------------

    @Test
    public void testDigits() {
        assertReverses("123456789", "987654321");
    }

    @Test
    public void testMixedCaseLetters() {
        assertReverses("AbCdEf", "fEdCbA");
    }

    @Test
    public void testWithSpacesAndPunctuation() {
        assertReverses("a b, c.", ".c ,b a");
    }

    @Test
    public void testLeadingAndTrailingSpacesArePreservedAtOppositeEnds() {
        assertReverses("  hi  ", "  ih  ");
    }

    @Test
    public void testSymbolsOnly() {
        assertReverses("!@#$%^&*()", ")(*&^%$#@!");
    }

    @Test
    public void testAllPrintableAsciiRange() {
        StringBuilder sb = new StringBuilder();
        for (char c = 32; c < 127; c++) { // space (32) through '~' (126)
            sb.append(c);
        }
        assertReverses(sb.toString());
    }

    @Test
    public void testRepeatedCharacterBlock() {
        assertReverses("aaaabbbbcccc", "ccccbbbbaaaa");
    }

    // ---------------------------------------------------------------------
    // In-place contract
    // ---------------------------------------------------------------------

    @Test
    public void testOperatesOnTheSameArrayInstance() {
        char[] s = "abcdef".toCharArray();
        char[] sameRef = s;

        ReverseString.reverseString(s);

        Assert.assertSame("reverseString must mutate the array in place, not replace it", sameRef, s);
        Assert.assertArrayEquals("fedcba".toCharArray(), s);
    }

    @Test
    public void testLengthIsUnchanged() {
        char[] s = "abcdefg".toCharArray();
        ReverseString.reverseString(s);
        Assert.assertEquals(7, s.length);
    }

    @Test
    public void testCharacterMultisetIsUnchanged() {
        String input = "the quick brown fox";
        char[] s = input.toCharArray();

        ReverseString.reverseString(s);

        char[] sortedBefore = input.toCharArray();
        char[] sortedAfter = s.clone();
        Arrays.sort(sortedBefore);
        Arrays.sort(sortedAfter);
        Assert.assertArrayEquals("characters may be reordered but not added, dropped, or changed",
                sortedBefore, sortedAfter);
    }

    @Test
    public void testReversingTwiceRestoresTheOriginal() {
        String original = "abcdefghij";
        char[] s = original.toCharArray();

        ReverseString.reverseString(s);
        ReverseString.reverseString(s);

        Assert.assertEquals(original, new String(s));
    }

    @Test
    public void testEachCharacterEndsAtItsMirroredIndex() {
        char[] input = "abcdefg".toCharArray();
        char[] s = input.clone();

        ReverseString.reverseString(s);

        int n = input.length;
        for (int i = 0; i < n; i++) {
            Assert.assertEquals("index " + i + " should hold the character from index " + (n - 1 - i),
                    input[n - 1 - i], s[i]);
        }
    }

    // ---------------------------------------------------------------------
    // Large inputs (constraint upper bound: 10^5)
    // ---------------------------------------------------------------------

    @Test
    public void testLargeEvenLengthInput() {
        int n = 100_000;
        char[] s = new char[n];
        for (int i = 0; i < n; i++) {
            s[i] = (char) ('a' + (i % 26));
        }
        char[] expected = new char[n];
        for (int i = 0; i < n; i++) {
            expected[i] = s[n - 1 - i];
        }

        ReverseString.reverseString(s);

        Assert.assertArrayEquals(expected, s);
    }

    @Test
    public void testLargeOddLengthInput() {
        int n = 99_999;
        char[] s = new char[n];
        for (int i = 0; i < n; i++) {
            s[i] = (char) ('0' + (i % 10));
        }
        char middleBefore = s[n / 2];
        char[] expected = new char[n];
        for (int i = 0; i < n; i++) {
            expected[i] = s[n - 1 - i];
        }

        ReverseString.reverseString(s);

        Assert.assertArrayEquals(expected, s);
        Assert.assertEquals("centre character must stay put for odd length", middleBefore, s[n / 2]);
    }

    @Test
    public void testLargePalindromeIsUnchanged() {
        int half = 50_000;
        char[] s = new char[2 * half];
        for (int i = 0; i < half; i++) {
            char c = (char) ('a' + (i % 26));
            s[i] = c;
            s[2 * half - 1 - i] = c;
        }
        char[] expected = s.clone();

        ReverseString.reverseString(s);

        Assert.assertArrayEquals(expected, s);
    }
}
