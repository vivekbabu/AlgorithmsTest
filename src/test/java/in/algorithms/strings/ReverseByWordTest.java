package in.algorithms.strings;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.java.reversestringwords.ReverseByWord;

public class ReverseByWordTest {

    @Test
    public void testStandardSentenceReversal() {
        String input1 = "This is a good test for testing whether reverse works";
        String expected1 = "works reverse whether testing for test good a is This";
        Assert.assertEquals(expected1, ReverseByWord.reverseByWords(input1));

        String input2 = "The quick brown fox jumps over the lazy dog";
        String expected2 = "dog lazy the over jumps fox brown quick The";
        Assert.assertEquals(expected2, ReverseByWord.reverseByWords(input2));

        String input3 = "hello world";
        String expected3 = "world hello";
        Assert.assertEquals(expected3, ReverseByWord.reverseByWords(input3));
    }

    @Test
    public void testSingleWordSentences() {
        Assert.assertEquals("Antigravity", ReverseByWord.reverseByWords("Antigravity"));
        Assert.assertEquals("Algorithms", ReverseByWord.reverseByWords("Algorithms"));
        Assert.assertEquals("Java", ReverseByWord.reverseByWords("Java"));
        Assert.assertEquals("A", ReverseByWord.reverseByWords("A"));
        Assert.assertEquals("z", ReverseByWord.reverseByWords("z"));
    }

    @Test
    public void testOddAndEvenWordLengths() {
        // Words with odd lengths (3 chars each)
        Assert.assertEquals("dog and cat", ReverseByWord.reverseByWords("cat and dog"));

        // Words with even lengths (4 chars each)
        Assert.assertEquals("test with code even", ReverseByWord.reverseByWords("even code with test"));

        // Single character words
        Assert.assertEquals("e d c b a", ReverseByWord.reverseByWords("a b c d e"));

        // Mixed varying length words
        String mixed = "I love solving complex algorithmic challenges";
        String expected = "challenges algorithmic complex solving love I";
        Assert.assertEquals(expected, ReverseByWord.reverseByWords(mixed));
    }

    @Test
    public void testWordSymmetryAndPalindromicSentences() {
        String s1 = "fall leaves when leaves fall";
        Assert.assertEquals(s1, ReverseByWord.reverseByWords(s1));

        String s2 = "alpha beta gamma beta alpha";
        Assert.assertEquals(s2, ReverseByWord.reverseByWords(s2));

        String s3 = "one two three two one";
        Assert.assertEquals(s3, ReverseByWord.reverseByWords(s3));
    }

    @Test
    public void testSpecialCharactersAndPunctuation() {
        // Punctuation is attached to the word tokens
        Assert.assertEquals("world! Hello,", ReverseByWord.reverseByWords("Hello, world!"));
        Assert.assertEquals("email my is foo@bar.com", ReverseByWord.reverseByWords("foo@bar.com is my email"));
        Assert.assertEquals("3 = 2 + 1", ReverseByWord.reverseByWords("1 + 2 = 3"));
        Assert.assertEquals("test pair key:value", ReverseByWord.reverseByWords("key:value pair test"));
        Assert.assertEquals("[success] status: ok", ReverseByWord.reverseByWords("ok status: [success]"));
    }

    @Test
    public void testNumbersAndAlphanumericTokens() {
        Assert.assertEquals("2026 2025 2024", ReverseByWord.reverseByWords("2024 2025 2026"));
        Assert.assertEquals("live is v1.0.0 Release", ReverseByWord.reverseByWords("Release v1.0.0 is live"));
        Assert.assertEquals("port 8080 to 127.0.0.1 Bind", ReverseByWord.reverseByWords("Bind 127.0.0.1 to 8080 port"));
    }

    @Test
    public void testEdgeCasesNullAndEmpty() {
        Assert.assertNull(ReverseByWord.reverseByWords(null));
        Assert.assertEquals("", ReverseByWord.reverseByWords(""));
        Assert.assertEquals(" ", ReverseByWord.reverseByWords(" "));
    }

    @Test
    public void testReversibilityInversionProperty() {
        // Applying reverseByWords twice must return the original sentence (identity function)
        String[] testCorpus = new String[] {
                "Quick brown fox",
                "Deep learning models require balanced datasets",
                "Graph search algorithms include BFS and DFS",
                "Concurrency with actors and threads",
                "Design patterns enable modular decoupled architectures",
                "Step 1 Step 2 Step 3 Step 4",
                "Short and long sentences test reversibility guarantees"
        };

        for (String sentence : testCorpus) {
            String once = ReverseByWord.reverseByWords(sentence);
            String twice = ReverseByWord.reverseByWords(once);
            Assert.assertEquals("Reversing twice must restore original sentence: " + sentence,
                    sentence, twice);
        }
    }

    @Test
    public void testMainMethodSmokeTest() {
        // Ensure main method entry point executes without exception
        ReverseByWord.main(new String[]{});
    }
}
