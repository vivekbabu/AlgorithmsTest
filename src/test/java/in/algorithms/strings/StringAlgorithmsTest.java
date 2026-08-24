package in.algorithms.strings;

import in.algorithms.anagram.AnagramChecking;
import in.algorithms.balanced.BalancedExpression;
import in.algorithms.duplicatecharacters.DuplicateCharacterChecker;
import in.algorithms.duplicatecharacters.DuplicateCharacterRemover;
import in.algorithms.kmpalgorithm.KMPAlgorithm;
import in.algorithms.palindrome.Palindrome;
import in.algorithms.stringpermute.StringPermutation;
import in.algorithms.stringreplacespaces.ReplaceSpaces;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class StringAlgorithmsTest {

    @Test
    public void testKMPAlgorithm() {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        List<Integer> matches = KMPAlgorithm.search(pat, txt);
        Assert.assertEquals(Arrays.asList(10), matches);

        int[] lps = KMPAlgorithm.computeLPSArray("AAAA");
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3}, lps);
    }

    @Test
    public void testAnagramChecking() {
        Assert.assertTrue(AnagramChecking.isAnagram("listen", "silent"));
        Assert.assertTrue(AnagramChecking.isAnagram("Debit Card", "Bad Credit"));
        Assert.assertFalse(AnagramChecking.isAnagram("hello", "world"));
    }

    @Test
    public void testDuplicateCharacterCheckerAndRemover() {
        Assert.assertFalse(DuplicateCharacterChecker.checkIfContainsDuplicateCharacters("abcdef"));
        Assert.assertTrue(DuplicateCharacterChecker.checkIfContainsDuplicateCharacters("aabcdef"));

        DuplicateCharacterRemover remover = new DuplicateCharacterRemover();
        Assert.assertEquals("arvid", remover.removeDuplicateCharacters("aarviidd"));
        Assert.assertEquals("abc", remover.removeDuplicateCharacters("abc"));
    }

    @Test
    public void testPalindrome() {
        Assert.assertTrue(Palindrome.palindromeCheck("racecar"));
        Assert.assertTrue(Palindrome.palindromeCheck("madam"));
        Assert.assertTrue(Palindrome.palindromeCheck("a"));
        Assert.assertTrue(Palindrome.palindromeCheck(""));
        Assert.assertFalse(Palindrome.palindromeCheck("algorithm"));
    }

    @Test
    public void testStringPermutations() {
        StringPermutation permuter = new StringPermutation();
        List<String> perms = permuter.permute("ABC".toCharArray(), 0, 2);
        Assert.assertEquals(6, perms.size());
        Assert.assertTrue(perms.contains("ABC"));
        Assert.assertTrue(perms.contains("CBA"));
    }

    @Test
    public void testReplaceSpaces() {
        Assert.assertEquals("Hello%20World", ReplaceSpaces.replaceSpaces("Hello World"));
        Assert.assertEquals("%20%20", ReplaceSpaces.replaceSpaces("  "));
        Assert.assertNull(ReplaceSpaces.replaceSpaces(null));
        Assert.assertEquals("NoSpaces", ReplaceSpaces.replaceSpaces("NoSpaces"));
        Assert.assertEquals("", ReplaceSpaces.replaceSpaces(""));
    }

    @Test
    public void testBalancedExpression() {
        Assert.assertTrue(BalancedExpression.isBalanced("()"));
        Assert.assertTrue(BalancedExpression.isBalanced("({[]})"));
        Assert.assertTrue(BalancedExpression.isBalanced("[()()]{}"));
        Assert.assertTrue(BalancedExpression.isBalanced(""));
        Assert.assertTrue(BalancedExpression.isBalanced(null));

        Assert.assertFalse(BalancedExpression.isBalanced("(]"));
        Assert.assertFalse(BalancedExpression.isBalanced("(()"));
        Assert.assertFalse(BalancedExpression.isBalanced("())"));
        Assert.assertFalse(BalancedExpression.isBalanced("{[(])}"));
        Assert.assertFalse(BalancedExpression.isBalanced(")("));
    }

    @Test
    public void testKMPAlgorithmNoMatchAndMultipleMatches() {
        Assert.assertTrue(KMPAlgorithm.search("XYZ", "ABABDABACDABABCABAB").isEmpty());
        Assert.assertTrue(KMPAlgorithm.search("", "ABC").isEmpty());
        Assert.assertTrue(KMPAlgorithm.search("ABC", "").isEmpty());
        Assert.assertTrue(KMPAlgorithm.search(null, "ABC").isEmpty());

        List<Integer> repeatedMatches = KMPAlgorithm.search("AA", "AAAA");
        Assert.assertEquals(Arrays.asList(0, 1, 2), repeatedMatches);
    }

    @Test
    public void testAnagramCheckingEdgeCases() {
        Assert.assertFalse(AnagramChecking.isAnagram(null, "abc"));
        Assert.assertFalse(AnagramChecking.isAnagram("abc", null));
        Assert.assertTrue(AnagramChecking.isAnagram("", ""));
        Assert.assertFalse(AnagramChecking.isAnagram("abc", "ab"));
        Assert.assertTrue(AnagramChecking.isAnagram("a", "A"));
    }

    @Test
    public void testDuplicateCharacterEdgeCases() {
        Assert.assertFalse(DuplicateCharacterChecker.checkIfContainsDuplicateCharacters(null));
        Assert.assertFalse(DuplicateCharacterChecker.checkIfContainsDuplicateCharacters(""));

        DuplicateCharacterRemover remover = new DuplicateCharacterRemover();
        Assert.assertNull(remover.removeDuplicateCharacters(null));
        Assert.assertEquals("", remover.removeDuplicateCharacters(""));
    }

    @Test
    public void testPalindromeEdgeCases() {
        Assert.assertFalse(Palindrome.palindromeCheck(null));
        Assert.assertTrue(Palindrome.palindromeCheck("aa"));
        Assert.assertFalse(Palindrome.palindromeCheck("ab"));
        Assert.assertTrue(Palindrome.palindromeCheck("wasitacaroracatisaw")); // case-sensitive, no normalization
    }

    @Test
    public void testStringPermutationsSingleAndDuplicateCharacters() {
        StringPermutation permuter = new StringPermutation();

        List<String> single = permuter.permute("A".toCharArray(), 0, 0);
        Assert.assertEquals(Arrays.asList("A"), single);

        // Repeated characters still generate one permutation per position arrangement,
        // even though several results are textually identical.
        List<String> duplicates = permuter.permute("AAB".toCharArray(), 0, 2);
        Assert.assertEquals(6, duplicates.size());
        Assert.assertTrue(duplicates.contains("AAB"));
        Assert.assertTrue(duplicates.contains("ABA"));
        Assert.assertTrue(duplicates.contains("BAA"));
    }
}
