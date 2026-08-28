package in.algorithms.interviewprep.reverselinkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ReverseLinkedListTest {

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

    /** Collects the identity (reference) of every node in the list, in order. */
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
            Assert.assertTrue("reversed list must not contain a cycle", seen.add(node));
            length++;
        }
        return length;
    }

    /** Reverses {@code values}, runs the solution, and asserts the result equals the reverse. */
    private static void assertReverses(int[] values) {
        int[] expected = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            expected[i] = values[values.length - 1 - i];
        }

        ListNode result = ReverseLinkedList.reverseList(listOf(values));

        assertAcyclicAndMeasure(result);
        Assert.assertArrayEquals("reversed values mismatch", expected, toArray(result));
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // head = [1,2,3,4,5] -> [5,4,3,2,1]
        assertReverses(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // head = [1,2] -> [2,1]
        assertReverses(new int[]{1, 2});
    }

    @Test
    public void testProblemStatementExampleThree() {
        // head = [] -> []
        ListNode result = ReverseLinkedList.reverseList(listOf());
        Assert.assertNull("reversing an empty list must return null", result);
    }

    // ---------------------------------------------------------------------
    // Boundary sizes
    // ---------------------------------------------------------------------

    @Test
    public void testSingleElementListIsUnchangedInValue() {
        ListNode result = ReverseLinkedList.reverseList(listOf(42));

        Assert.assertNotNull(result);
        Assert.assertEquals(1, assertAcyclicAndMeasure(result));
        Assert.assertArrayEquals(new int[]{42}, toArray(result));
        Assert.assertNull("the sole node must terminate the list", result.next);
    }

    @Test
    public void testTwoElementList() {
        assertReverses(new int[]{7, 9});
    }

    @Test
    public void testThreeElementList() {
        assertReverses(new int[]{10, 20, 30});
    }

    @Test
    public void testMaximumLengthList() {
        // Upper constraint bound: 5000 nodes.
        int n = 5000;
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i - 2500; // spread across the legal value range
        }
        assertReverses(values);
    }

    // ---------------------------------------------------------------------
    // Value variety
    // ---------------------------------------------------------------------

    @Test
    public void testListWithNegativeValues() {
        assertReverses(new int[]{-1, -2, -3, -4});
    }

    @Test
    public void testListMixingPositiveNegativeAndZero() {
        assertReverses(new int[]{0, -5, 5, -10, 10, 0});
    }

    @Test
    public void testListWithAllEqualValues() {
        assertReverses(new int[]{3, 3, 3, 3, 3});
    }

    @Test
    public void testListWithDuplicateValuesAtDifferentPositions() {
        assertReverses(new int[]{1, 2, 1, 3, 1, 2});
    }

    @Test
    public void testConstraintBoundaryValues() {
        // -5000 <= Node.val <= 5000
        assertReverses(new int[]{-5000, 0, 5000, -5000, 5000});
    }

    @Test
    public void testAllZeros() {
        assertReverses(new int[]{0, 0, 0});
    }

    // ---------------------------------------------------------------------
    // Structural guarantees
    // ---------------------------------------------------------------------

    @Test
    public void testReversedListHasSameLengthAsInput() {
        ListNode result = ReverseLinkedList.reverseList(listOf(5, 4, 3, 2, 1, 0));
        Assert.assertEquals(6, assertAcyclicAndMeasure(result));
    }

    @Test
    public void testReversedListTailPointsToNull() {
        ListNode result = ReverseLinkedList.reverseList(listOf(1, 2, 3));

        ListNode node = result;
        while (node.next != null) {
            node = node.next;
        }
        Assert.assertEquals("original head value should now be the tail value", 1, node.val);
        Assert.assertNull("the reversed list must be properly null-terminated", node.next);
    }

    @Test
    public void testReversingTwiceRestoresOriginalOrder() {
        int[] original = {1, 2, 3, 4, 5, 6, 7};
        ListNode once = ReverseLinkedList.reverseList(listOf(original));
        ListNode twice = ReverseLinkedList.reverseList(once);

        assertAcyclicAndMeasure(twice);
        Assert.assertArrayEquals(original, toArray(twice));
    }

    @Test
    public void testReversalReusesExistingNodesRatherThanAllocatingNew() {
        ListNode head = listOf(1, 2, 3, 4);
        Set<ListNode> originalNodes = new HashSet<>(nodesOf(head));

        ListNode result = ReverseLinkedList.reverseList(head);

        for (ListNode node : nodesOf(result)) {
            Assert.assertTrue(
                    "reverseList is expected to relink existing nodes in place, not create new ones",
                    originalNodes.contains(node));
        }
    }

    @Test
    public void testInputNodesAreNotDuplicatedInResult() {
        ListNode head = listOf(9, 8, 7, 6, 5);
        int expectedLength = nodesOf(head).size();

        ListNode result = ReverseLinkedList.reverseList(head);

        Set<ListNode> distinct = new HashSet<>(nodesOf(result));
        Assert.assertEquals("every node must appear exactly once in the reversed list",
                expectedLength, distinct.size());
    }

    @Test
    public void testValueMultisetIsPreserved() {
        int[] values = {4, 1, 4, 2, 7, 7, 0, -3};
        int[] reversed = toArray(ReverseLinkedList.reverseList(listOf(values)));

        int[] sortedInput = values.clone();
        int[] sortedOutput = reversed.clone();
        java.util.Arrays.sort(sortedInput);
        java.util.Arrays.sort(sortedOutput);
        Assert.assertArrayEquals("reversal must neither add, drop, nor mutate values",
                sortedInput, sortedOutput);
    }
}
