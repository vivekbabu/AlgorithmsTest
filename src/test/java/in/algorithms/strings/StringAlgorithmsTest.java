package in.algorithms.strings;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.duplicatecharacters.DuplicateCharacterRemover;
import in.algorithms.duplicatecharacters.DuplicateCharacterChecker;
import in.algorithms.java.reversestringwords.ReverseByWord;
import in.algorithms.stringpermute.StringPermutation;
import in.algorithms.Palindrome;

public class StringAlgorithmsTest {

    @Test
    public void testDuplicateCharacterRemover() {
        DuplicateCharacterRemover remover = new DuplicateCharacterRemover();

        Assert.assertEquals("arvid", remover.removeDuplicateCharacters("aarviidd"));
        Assert.assertEquals("abc", remover.removeDuplicateCharacters("abc"));
        Assert.assertEquals("a", remover.removeDuplicateCharacters("aaaaaa"));
    }

    @Test
    public void testDuplicateCharacterChecker() {
        Assert.assertFalse(DuplicateCharacterChecker.checkIfContainsDuplicateCharacters("abcde"));
        Assert.assertTrue(DuplicateCharacterChecker.checkIfContainsDuplicateCharacters("aabcde"));
    }

    @Test
    public void testReverseWordsInSentence() {
        String input = "This is a good test for testing whether reverse works";
        String expected = "works reverse whether testing for test good a is This";
        Assert.assertEquals(expected, ReverseByWord.reverseByWords(input));

        Assert.assertEquals("world hello", ReverseByWord.reverseByWords("hello world"));
        Assert.assertEquals("single", ReverseByWord.reverseByWords("single"));
    }

    @Test
    public void testStringPermutations() {
        StringPermutation permuter = new StringPermutation();
        permuter.permute("ABC".toCharArray(), 0, 2);
    }

    @Test
    public void testLevenshteinDistance() {
        Assert.assertEquals(0, in.algorithms.levenstein.Levenstein.distance("kitten", "kitten"));
        Assert.assertEquals(3, in.algorithms.levenstein.Levenstein.distance("kitten", "sitting"));
        Assert.assertEquals(3, in.algorithms.levenstein.Levenstein.distance("saturday", "sunday"));
        Assert.assertEquals(0, in.algorithms.levenstein.Levenstein.distance("", ""));
        Assert.assertEquals(4, in.algorithms.levenstein.Levenstein.distance("", "test"));
    }

    @Test
    public void testPalindromeCheck() {
        Assert.assertTrue(Palindrome.palindromeCheck("racecar"));
        Assert.assertTrue(Palindrome.palindromeCheck("radar"));
        Assert.assertTrue(Palindrome.palindromeCheck("a"));
        Assert.assertFalse(Palindrome.palindromeCheck("hello"));
    }
}
