package in.algorithms.interviewprep.validanagram;

import org.junit.Assert;
import org.junit.Test;

public class ValidAnagramTest {

    @Test
    public void testProblemStatementExampleOne() {
        // s = "anagram", t = "nagaram" -> true
        Assert.assertTrue(ValidAnagram.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // s = "rat", t = "car" -> false
        Assert.assertFalse(ValidAnagram.isAnagram("rat", "car"));
    }

    @Test
    public void testDifferentLengthsAreNeverAnagrams() {
        Assert.assertFalse(ValidAnagram.isAnagram("ab", "a"));
        Assert.assertFalse(ValidAnagram.isAnagram("a", "ab"));
    }

    @Test
    public void testIdenticalStringsAreAnagrams() {
        Assert.assertTrue(ValidAnagram.isAnagram("listen", "listen"));
    }

    @Test
    public void testSingleCharacterMatch() {
        Assert.assertTrue(ValidAnagram.isAnagram("a", "a"));
    }

    @Test
    public void testSingleCharacterMismatch() {
        Assert.assertFalse(ValidAnagram.isAnagram("a", "b"));
    }

    @Test
    public void testSameCharactersDifferentFrequencyIsNotAnagram() {
        // s has a:2,c:2 ; t has c:3,a:1
        Assert.assertFalse(ValidAnagram.isAnagram("aacc", "ccac"));
    }

    @Test
    public void testRepeatedCharacterAnagram() {
        // Both have a:2, b:2, c:2, just grouped differently.
        Assert.assertTrue(ValidAnagram.isAnagram("aabbcc", "abcabc"));
    }

    @Test
    public void testAllSameCharacterMatchingCounts() {
        Assert.assertTrue(ValidAnagram.isAnagram("aaaa", "aaaa"));
    }

    @Test
    public void testAllSameCharacterDifferentCounts() {
        Assert.assertFalse(ValidAnagram.isAnagram("aaa", "aaaa"));
    }

    @Test
    public void testCaseSensitivityMismatch() {
        // 'A' and 'a' are distinct characters; counts must not be merged across case.
        Assert.assertFalse(ValidAnagram.isAnagram("aA", "aa"));
    }

    @Test
    public void testCaseSensitivitySameMultisetDifferentOrder() {
        // Same multiset {A, a} in both, just reordered - still an anagram.
        Assert.assertTrue(ValidAnagram.isAnagram("Aa", "aA"));
    }

    @Test
    public void testAnagramWithAllDistinctLetters() {
        // Exact reverse permutation of distinct letters.
        Assert.assertTrue(ValidAnagram.isAnagram("abcdefg", "gfedcba"));
    }

    @Test
    public void testSameLengthDifferentLettersIsNotAnagram() {
        Assert.assertFalse(ValidAnagram.isAnagram("abcd", "abce"));
    }

    @Test
    public void testLargeRepeatedPatternIsAnagram() {
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            sb.append("ab");
            tb.append("ba");
        }
        Assert.assertTrue(ValidAnagram.isAnagram(sb.toString(), tb.toString()));
    }

    @Test
    public void testLargeStringsWithOneCharacterDifferenceIsNotAnagram() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            sb.append("ab");
        }
        String s = sb.toString();
        String t = s.substring(0, s.length() - 1) + "c"; // swap the trailing 'b' for a 'c'

        Assert.assertFalse(ValidAnagram.isAnagram(s, t));
    }
}
