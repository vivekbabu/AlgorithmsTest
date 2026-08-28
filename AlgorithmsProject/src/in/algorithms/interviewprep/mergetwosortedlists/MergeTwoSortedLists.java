package in.algorithms.interviewprep.mergetwosortedlists;

// LeetCode 21: Merge Two Sorted Lists - https://leetcode.com/problems/merge-two-sorted-lists/description/
//
// You are given the heads of two sorted linked lists list1 and list2. Merge the two lists into
// one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.
//
// Constraints:
//   - The number of nodes in both lists is in the range [0, 50].
//   - -100 <= Node.val <= 100
//   - Both list1 and list2 are sorted in non-decreasing order.
public class MergeTwoSortedLists {

    /**
     * Merges two lists that are each sorted in non-decreasing order into a single sorted list,
     * splicing together the existing nodes rather than allocating new ones.
     *
     * @param list1 the head of the first sorted list; {@code null} for an empty list
     * @param list2 the head of the second sorted list; {@code null} for an empty list
     * @return the head of the merged sorted list; {@code null} only when both inputs are empty
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list2.next, list1);
        return list2;
    }
}
