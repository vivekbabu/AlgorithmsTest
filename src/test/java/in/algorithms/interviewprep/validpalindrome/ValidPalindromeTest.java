package in.algorithms.interviewprep.validpalindrome;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindromeTest {

    private static void assertPalindrome(String s) {
        Assert.assertTrue("expected \"" + s + "\" to be a valid palindrome",
                ValidPalindrome.isPalindrome(s));
    }

    private static void assertNotPalindrome(String s) {
        Assert.assertFalse("expected \"" + s + "\" NOT to be a valid palindrome",
                ValidPalindrome.isPalindrome(s));
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // "A man, a plan, a canal: Panama" -> "amanaplanacanalpanama" -> true
        assertPalindrome("A man, a plan, a canal: Panama");
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // "race a car" -> "raceacar" -> false
        assertNotPalindrome("race a car");
    }

    @Test
    public void testProblemStatementExampleThree() {
        // " " -> "" after filtering -> true (empty string reads the same both ways)
        assertPalindrome(" ");
    }

    // ---------------------------------------------------------------------
    // Filtered string becomes empty
    // ---------------------------------------------------------------------

    @Test
    public void testStringOfOnlyPunctuationIsAPalindrome() {
        assertPalindrome(".,!?;:'\"-()[]{}");
    }

    @Test
    public void testSingleNonAlphanumericCharacter() {
        assertPalindrome("!");
    }

    @Test
    public void testStringOfOnlySpaces() {
        assertPalindrome("     ");
    }

    // ---------------------------------------------------------------------
    // Minimal inputs (constraint: length >= 1)
    // ---------------------------------------------------------------------

    @Test
    public void testSingleLetter() {
        assertPalindrome("a");
    }

    @Test
    public void testSingleDigit() {
        assertPalindrome("7");
    }

    @Test
    public void testSingleUppercaseLetter() {
        assertPalindrome("Z");
    }

    // ---------------------------------------------------------------------
    // Case-insensitivity
    // ---------------------------------------------------------------------

    @Test
    public void testMixedCasePalindromeWithNoOtherNoise() {
        assertPalindrome("AbBa");
    }

    @Test
    public void testMixedCaseNonPalindrome() {
        assertNotPalindrome("AbCa");
    }

    @Test
    public void testCaseIsNormalisedNotUsedForComparison() {
        // Would only be a palindrome if case were ignored.
        assertPalindrome("Madam");
    }

    // ---------------------------------------------------------------------
    // Alphanumeric handling — digits count, letters count
    // ---------------------------------------------------------------------

    @Test
    public void testDigitsOnlyPalindrome() {
        assertPalindrome("12321");
    }

    @Test
    public void testDigitsOnlyNonPalindrome() {
        assertNotPalindrome("12345");
    }

    @Test
    public void testLettersAndDigitsMixedPalindrome() {
        // "1a2b2a1" reads the same both ways.
        assertPalindrome("1a2b2a1");
    }

    @Test
    public void testLetterVersusDigitMismatchIsNotAPalindrome() {
        // Filtered: "a1a1" — first char 'a' vs last char '1' differ.
        assertNotPalindrome("a1a1");
    }

    @Test
    public void testAlphanumericPalindromeSurroundedByNoise() {
        assertPalindrome("  ,,0P@p0,, ");
    }

    // ---------------------------------------------------------------------
    // Even vs odd filtered length
    // ---------------------------------------------------------------------

    @Test
    public void testEvenLengthPalindrome() {
        assertPalindrome("abba");
    }

    @Test
    public void testOddLengthPalindrome() {
        assertPalindrome("abcba");
    }

    @Test
    public void testEvenLengthNonPalindrome() {
        assertNotPalindrome("abca");
    }

    @Test
    public void testNearPalindromeDifferingOnlyAtTheCentreNeighbours() {
        assertNotPalindrome("abccxa");
    }

    // ---------------------------------------------------------------------
    // Longer / classic phrases
    // ---------------------------------------------------------------------

    @Test
    public void testClassicPhrasePalindrome() {
        assertPalindrome("Was it a car or a cat I saw?");
    }

    @Test
    public void testClassicPhrasePalindromeWithLeadingArticleStripped() {
        // Filtered: "ratsliveonnoevilstar"
        assertPalindrome("Rats live on no evil star");
    }

    @Test
    public void testLongNonPalindromeSentence() {
        assertNotPalindrome("The quick brown fox jumps over the lazy dog");
    }

    @Test
    public void testMismatchOnlyAtTheVeryEnds() {
        // "xanax" without the leading/trailing match: "banana" -> b...a differ.
        assertNotPalindrome("banana");
    }

    // ---------------------------------------------------------------------
    // Punctuation and whitespace placement
    // ---------------------------------------------------------------------

    @Test
    public void testLeadingAndTrailingPunctuationIgnored() {
        assertPalindrome("...tacocat...");
    }

    @Test
    public void testInternalPunctuationAndSpacingIgnored() {
        assertPalindrome("ta,c o.c-a t");
    }

    @Test
    public void testTabAndNewlineTreatedAsNonAlphanumeric() {
        assertPalindrome("ab\tb\na");
    }

    // ---------------------------------------------------------------------
    // Large inputs (constraint upper bound: 2 * 10^5)
    // ---------------------------------------------------------------------

    @Test
    public void testVeryLongPalindrome() {
        int half = 100_000;
        StringBuilder sb = new StringBuilder(2 * half);
        for (int i = 0; i < half; i++) {
            sb.append('a');
        }
        for (int i = 0; i < half; i++) {
            sb.append('a');
        }
        assertPalindrome(sb.toString());
    }

    @Test
    public void testVeryLongPalindromeWithInterspersedNoise() {
        int n = 50_000;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('x').append(", ");
        }
        for (int i = 0; i < n; i++) {
            sb.append(" ,").append('x');
        }
        assertPalindrome(sb.toString());
    }

    @Test
    public void testVeryLongNonPalindromeDifferingAtTheLastCharacter() {
        int n = 200_000;
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n - 1; i++) {
            sb.append('a');
        }
        sb.append('b'); // single mismatch against the first character
        assertNotPalindrome(sb.toString());
    }

    @Test
    public void testVeryLongStringOfOnlyPunctuation() {
        int n = 200_000;
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append('#');
        }
        assertPalindrome(sb.toString());
    }
}
