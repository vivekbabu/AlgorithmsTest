package in.algorithms.interviewprep.mergetwosortedlists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeTwoSortedListsTest {

    // ---------------------------------------------------------------------
    // Helpers
    // ---------------------------------------------------------------------

    /** Builds a linked list from the given values and returns its head (null for an empty array). */
    private static ListNode listOf(int... values) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    /** Serialises a linked list back into an int array so results can be compared by value. */
    private static int[] toArray(ListNode head) {
        int length = 0;
        for (ListNode node = head; node != null; node = node.next) {
            length++;
        }
        int[] out = new int[length];
        int i = 0;
        for (ListNode node = head; node != null; node = node.next) {
            out[i++] = node.val;
        }
        return out;
    }

    /** Collects the identity (reference) of every node reachable from {@code head}, in order. */
    private static java.util.List<ListNode> nodesOf(ListNode head) {
        java.util.List<ListNode> nodes = new java.util.ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            nodes.add(node);
        }
        return nodes;
    }

    /** Fails if the list contains a cycle; otherwise returns its length. */
    private static int assertAcyclicAndMeasure(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        int length = 0;
        for (ListNode node = head; node != null; node = node.next) {
            Assert.assertTrue("merged list must not contain a cycle", seen.add(node));
            length++;
        }
        return length;
    }

    /** Asserts the array is sorted in non-decreasing order. */
    private static void assertNonDecreasing(int[] values) {
        for (int i = 1; i < values.length; i++) {
            Assert.assertTrue(
                    "merged list must be sorted; " + values[i - 1] + " > " + values[i]
                            + " at index " + i + " of " + Arrays.toString(values),
                    values[i - 1] <= values[i]);
        }
    }

    /**
     * Merges {@code a} and {@code b}, then asserts the result is acyclic, sorted, and contains
     * exactly the multiset of values from both inputs.
     */
    private static void assertMerges(int[] a, int[] b) {
        int[] expected = new int[a.length + b.length];
        System.arraycopy(a, 0, expected, 0, a.length);
        System.arraycopy(b, 0, expected, a.length, b.length);
        Arrays.sort(expected);

        ListNode merged = MergeTwoSortedLists.mergeTwoLists(listOf(a), listOf(b));

        int length = assertAcyclicAndMeasure(merged);
        Assert.assertEquals("merged length must equal the sum of input lengths",
                a.length + b.length, length);

        int[] actual = toArray(merged);
        assertNonDecreasing(actual);
        Assert.assertArrayEquals("merged values (as a sorted multiset) mismatch", expected, actual);
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // list1 = [1,2,4], list2 = [1,3,4] -> [1,1,2,3,4,4]
        assertMerges(new int[]{1, 2, 4}, new int[]{1, 3, 4});
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // list1 = [], list2 = [] -> []
        ListNode merged = MergeTwoSortedLists.mergeTwoLists(listOf(), listOf());
        Assert.assertNull("merging two empty lists must return null", merged);
    }

    @Test
    public void testProblemStatementExampleThree() {
        // list1 = [], list2 = [0] -> [0]
        assertMerges(new int[]{}, new int[]{0});
    }

    // ---------------------------------------------------------------------
    // Empty-input handling
    // ---------------------------------------------------------------------

    @Test
    public void testFirstListEmptyReturnsSecondListContents() {
        assertMerges(new int[]{}, new int[]{-3, 0, 7, 7, 20});
    }

    @Test
    public void testSecondListEmptyReturnsFirstListContents() {
        assertMerges(new int[]{-8, -8, 1, 9}, new int[]{});
    }

    @Test
    public void testSecondListEmptyReturnsTheActualFirstListHead() {
        // When one input is empty the result should splice in the other list's existing nodes.
        ListNode list1 = listOf(1, 2, 3);
        ListNode firstNode = list1;

        ListNode merged = MergeTwoSortedLists.mergeTwoLists(list1, listOf());

        Assert.assertSame("expected the original list1 nodes to be reused", firstNode, merged);
    }

    // ---------------------------------------------------------------------
    // Interleaving / ordering behaviour
    // ---------------------------------------------------------------------

    @Test
    public void testFullyInterleavedLists() {
        assertMerges(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8});
    }

    @Test
    public void testDisjointListsWhereFirstListIsEntirelyBeforeSecond() {
        assertMerges(new int[]{1, 2, 3}, new int[]{4, 5, 6});
    }

    @Test
    public void testDisjointListsWhereSecondListIsEntirelyBeforeFirst() {
        assertMerges(new int[]{10, 11, 12}, new int[]{1, 2, 3});
    }

    @Test
    public void testListsOfVeryDifferentLengths() {
        assertMerges(new int[]{5}, new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10});
    }

    @Test
    public void testSingleElementEachHeadOrdering() {
        assertMerges(new int[]{2}, new int[]{1});
        assertMerges(new int[]{1}, new int[]{2});
        assertMerges(new int[]{5}, new int[]{5});
    }

    // ---------------------------------------------------------------------
    // Duplicates and repeated values
    // ---------------------------------------------------------------------

    @Test
    public void testDuplicatesAcrossBothLists() {
        assertMerges(new int[]{1, 1, 1}, new int[]{1, 1});
    }

    @Test
    public void testDuplicatesWithinASingleList() {
        assertMerges(new int[]{2, 2, 5, 5, 5}, new int[]{1, 2, 5, 6});
    }

    @Test
    public void testAllValuesIdenticalAcrossEverything() {
        assertMerges(new int[]{7, 7, 7, 7}, new int[]{7, 7, 7});
    }

    // ---------------------------------------------------------------------
    // Value range
    // ---------------------------------------------------------------------

    @Test
    public void testNegativeValues() {
        assertMerges(new int[]{-10, -7, -3}, new int[]{-9, -8, -1});
    }

    @Test
    public void testMixOfNegativeZeroAndPositive() {
        assertMerges(new int[]{-5, 0, 3}, new int[]{-2, 0, 0, 4});
    }

    @Test
    public void testConstraintBoundaryValues() {
        // -100 <= Node.val <= 100
        assertMerges(new int[]{-100, -100, 0, 100}, new int[]{-100, 50, 100, 100});
    }

    // ---------------------------------------------------------------------
    // Boundary sizes
    // ---------------------------------------------------------------------

    @Test
    public void testMaximumSizeInputs() {
        // Upper constraint bound: up to 50 nodes per list.
        int[] a = new int[50];
        int[] b = new int[50];
        for (int i = 0; i < 50; i++) {
            a[i] = 2 * i - 50;      // even offsets
            b[i] = 2 * i - 49;      // odd offsets, fully interleaving with a
        }
        assertMerges(a, b);
    }

    // ---------------------------------------------------------------------
    // Structural guarantees
    // ---------------------------------------------------------------------

    @Test
    public void testMergeSplicesExistingNodesRatherThanAllocatingNew() {
        ListNode list1 = listOf(1, 3, 5);
        ListNode list2 = listOf(2, 4, 6);

        Set<ListNode> originalNodes = new HashSet<>();
        originalNodes.addAll(nodesOf(list1));
        originalNodes.addAll(nodesOf(list2));

        ListNode merged = MergeTwoSortedLists.mergeTwoLists(list1, list2);

        for (ListNode node : nodesOf(merged)) {
            Assert.assertTrue(
                    "mergeTwoLists is expected to relink existing nodes, not create new ones",
                    originalNodes.contains(node));
        }
    }

    @Test
    public void testMergedListContainsEachInputNodeExactlyOnce() {
        ListNode list1 = listOf(1, 4, 4, 9);
        ListNode list2 = listOf(2, 4, 10);
        int expectedLength = nodesOf(list1).size() + nodesOf(list2).size();

        ListNode merged = MergeTwoSortedLists.mergeTwoLists(list1, list2);

        java.util.List<ListNode> mergedNodes = nodesOf(merged);
        Assert.assertEquals(expectedLength, mergedNodes.size());
        Assert.assertEquals("no node may appear twice in the merged list",
                expectedLength, new HashSet<>(mergedNodes).size());
    }

    @Test
    public void testMergedListIsProperlyNullTerminated() {
        ListNode merged = MergeTwoSortedLists.mergeTwoLists(listOf(1, 2), listOf(3, 4));

        ListNode node = merged;
        while (node.next != null) {
            node = node.next;
        }
        Assert.assertEquals("largest value should sit at the tail", 4, node.val);
        Assert.assertNull("merged list must be null-terminated", node.next);
    }

    @Test
    public void testInputsAreNotRequiredToRetainTheirOriginalStructureButValuesSurvive() {
        // The merge is allowed to mutate next-pointers of the inputs; what must hold is that
        // every value from both original lists appears exactly once in the result.
        int[] aValues = {0, 2, 2, 8};
        int[] bValues = {1, 2, 9, 9};

        ListNode merged = MergeTwoSortedLists.mergeTwoLists(listOf(aValues), listOf(bValues));

        int[] expected = new int[aValues.length + bValues.length];
        System.arraycopy(aValues, 0, expected, 0, aValues.length);
        System.arraycopy(bValues, 0, expected, aValues.length, bValues.length);
        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, toArray(merged));
    }
}
