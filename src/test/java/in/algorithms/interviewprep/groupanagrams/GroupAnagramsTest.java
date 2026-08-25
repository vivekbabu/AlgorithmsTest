package in.algorithms.interviewprep.groupanagrams;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GroupAnagramsTest {

    // The problem allows groups, and the strings within a group, to be returned in any order.
    // We normalize both the actual and expected results into a canonical form (each group's
    // strings sorted, then the groups themselves sorted) before comparing, so ordering never
    // matters. Sorting rather than using Sets also correctly preserves duplicate strings within
    // a group, since two literally-identical input strings both belong in the same group.
    private static void assertGroupsMatch(String[] strs, List<List<String>> expectedGroups) {
        List<List<String>> actual = GroupAnagrams.groupAnagrams(strs);
        Assert.assertEquals(normalize(expectedGroups), normalize(actual));
    }

    private static List<List<String>> normalize(List<List<String>> groups) {
        List<List<String>> copy = new ArrayList<>();
        for (List<String> group : groups) {
            List<String> sortedGroup = new ArrayList<>(group);
            Collections.sort(sortedGroup);
            copy.add(sortedGroup);
        }
        copy.sort((a, b) -> {
            if (a.size() != b.size()) return Integer.compare(a.size(), b.size());
            return String.join(",", a).compareTo(String.join(",", b));
        });
        return copy;
    }

    @Test
    public void testProblemStatementExampleOne() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        assertGroupsMatch(strs, expected);
    }

    @Test
    public void testProblemStatementExampleTwoEmptyString() {
        assertGroupsMatch(new String[]{""}, Arrays.asList(Arrays.asList("")));
    }

    @Test
    public void testProblemStatementExampleThreeSingleCharacter() {
        assertGroupsMatch(new String[]{"a"}, Arrays.asList(Arrays.asList("a")));
    }

    @Test
    public void testAllStringsAreMutualAnagramsFormOneGroup() {
        String[] strs = {"abc", "bca", "cab", "acb"};
        assertGroupsMatch(strs, Arrays.asList(Arrays.asList("abc", "bca", "cab", "acb")));
    }

    @Test
    public void testNoSharedAnagramsEachStringGetsItsOwnGroup() {
        String[] strs = {"abc", "def", "ghi"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("abc"),
                Arrays.asList("def"),
                Arrays.asList("ghi")
        );
        assertGroupsMatch(strs, expected);
    }

    @Test
    public void testMultipleEmptyStringsGroupTogether() {
        assertGroupsMatch(new String[]{"", "", ""}, Arrays.asList(Arrays.asList("", "", "")));
    }

    @Test
    public void testDuplicateIdenticalStringsGroupTogetherPreservingCount() {
        // Two literally-identical "eat" entries must both appear in the resulting group.
        String[] strs = {"eat", "eat", "tea"};
        assertGroupsMatch(strs, Arrays.asList(Arrays.asList("eat", "eat", "tea")));
    }

    @Test
    public void testSingleCharacterStringsGroupByCharacter() {
        String[] strs = {"a", "b", "a", "c", "b", "a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a", "a", "a"),
                Arrays.asList("b", "b"),
                Arrays.asList("c")
        );
        assertGroupsMatch(strs, expected);
    }

    @Test
    public void testStringsOfDifferentLengthsNeverGroupTogether() {
        String[] strs = {"ab", "abc", "ba", "cba"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("ab", "ba"),
                Arrays.asList("abc", "cba")
        );
        assertGroupsMatch(strs, expected);
    }

    @Test
    public void testGroupingDistinguishesLetterFrequencyNotJustLetterSet() {
        // "aab"/"aba"/"baa" share two a's and one b; "abb" has one a and two b's - different group
        // even though both groups are built from the same two distinct letters.
        String[] strs = {"aab", "aba", "baa", "abb"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("aab", "aba", "baa"),
                Arrays.asList("abb")
        );
        assertGroupsMatch(strs, expected);
    }

    @Test
    public void testCaseSensitiveCharactersAreNotTreatedAsEquivalent() {
        // Beyond the problem's documented lowercase-only constraint, but a correct character-count
        // (or sorted-key) approach naturally treats 'a' and 'A' as distinct, so this must not merge.
        String[] strs = {"ab", "AB"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("ab"), Arrays.asList("AB"));
        assertGroupsMatch(strs, expected);
    }

    @Test
    public void testEveryInputStringAppearsExactlyOnceAcrossTheResult() {
        String[] strs = {"listen", "silent", "enlist", "google", "gogole", "cat"};
        List<List<String>> actual = GroupAnagrams.groupAnagrams(strs);

        List<String> flattened = new ArrayList<>();
        for (List<String> group : actual) {
            flattened.addAll(group);
        }
        Collections.sort(flattened);

        List<String> expectedFlattened = new ArrayList<>(Arrays.asList(strs));
        Collections.sort(expectedFlattened);

        Assert.assertEquals(expectedFlattened, flattened);
    }

    @Test
    public void testLargeInputWhereEveryStringSharesOneGroup() {
        int n = 10000;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = (i % 2 == 0) ? "ab" : "ba"; // mutual anagrams of each other
        }

        List<List<String>> result = GroupAnagrams.groupAnagrams(strs);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(n, result.get(0).size());
    }

    @Test
    public void testLargeInputWithManyDistinctGroups() {
        // 1000 distinct single-character-repeated strings ("a","bb","ccc",... reused twice each),
        // each only an anagram of its own duplicate, giving exactly 1000 groups of size 2.
        int distinctGroups = 1000;
        String[] strs = new String[distinctGroups * 2];
        int idx = 0;
        for (int i = 0; i < distinctGroups; i++) {
            char c = (char) ('a' + (i % 26));
            StringBuilder letters = new StringBuilder();
            for (int r = 0; r < (i / 26) + 1; r++) {
                letters.append(c);
            }
            String base = letters + "_" + i; // unique per group
            strs[idx++] = base;
            strs[idx++] = new StringBuilder(base).reverse().toString(); // anagram of itself
        }

        List<List<String>> result = GroupAnagrams.groupAnagrams(strs);
        Assert.assertEquals(distinctGroups, result.size());
        for (List<String> group : result) {
            Assert.assertEquals(2, group.size());
        }
    }
}
