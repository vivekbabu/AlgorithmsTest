package in.algorithms.strings;

import in.algorithms.java.reversestringwords.ReverseByWord;
import org.junit.Assert;
import org.junit.Test;

public class ReverseByWordTest {

    @Test
    public void testReverseWordsInSentence() {
        String input = "This is a good test for testing whether reverse works";
        String expected = "works reverse whether testing for test good a is This";
        Assert.assertEquals(expected, ReverseByWord.reverseByWords(input));
    }

    @Test
    public void testTwoWords() {
        Assert.assertEquals("world hello", ReverseByWord.reverseByWords("hello world"));
    }

    @Test
    public void testSingleWord() {
        Assert.assertEquals("hello", ReverseByWord.reverseByWords("hello"));
    }

    @Test
    public void testEmptyAndNull() {
        Assert.assertEquals("", ReverseByWord.reverseByWords(""));
        Assert.assertNull(ReverseByWord.reverseByWords(null));
    }

    @Test
    public void testInversionIdentity() {
        String original = "The quick brown fox jumps over the lazy dog";
        String once = ReverseByWord.reverseByWords(original);
        String twice = ReverseByWord.reverseByWords(once);
        Assert.assertEquals(original, twice);
    }
}
