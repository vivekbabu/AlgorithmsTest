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

    @Test
    public void testLeadingAndTrailingSpacesArePreserved() {
        Assert.assertEquals(" cd ab ", ReverseByWord.reverseByWords(" ab cd "));
    }

    @Test
    public void testMultipleInternalSpacesArePreserved() {
        Assert.assertEquals("b  a", ReverseByWord.reverseByWords("a  b"));
    }

    @Test
    public void testReverseHelperInPlace() {
        char[] chars = "hello".toCharArray();
        ReverseByWord.reverse(chars, 0, chars.length - 1);
        Assert.assertEquals("olleh", new String(chars));
    }

    @Test
    public void testReverseHelperIgnoresInvalidBounds() {
        char[] chars = "abc".toCharArray();
        ReverseByWord.reverse(null, 0, 1); // null array is a no-op
        ReverseByWord.reverse(chars, 2, 1); // first >= last is a no-op
        Assert.assertEquals("abc", new String(chars));

        ReverseByWord.reverse(chars, -1, 2); // out-of-range first is a no-op
        ReverseByWord.reverse(chars, 0, 5); // out-of-range last is a no-op
        Assert.assertEquals("abc", new String(chars));
    }
}
