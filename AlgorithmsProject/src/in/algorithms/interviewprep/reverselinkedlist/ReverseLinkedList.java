package in.algorithms.interviewprep.reverselinkedlist;

// LeetCode 206: Reverse Linked List - https://leetcode.com/problems/reverse-linked-list/description/
//
// Given the head of a singly linked list, reverse the list and return the new head.
//
// Constraints:
//   - The number of nodes in the list is in the range [0, 5000].
//   - -5000 <= Node.val <= 5000
//
// Follow-up: solve it both iteratively and recursively.
public class ReverseLinkedList {

    /**
     * Reverses the singly linked list starting at {@code head} and returns the head of the
     * reversed list.
     *
     * @param head the head of the list to reverse; {@code null} for an empty list
     * @return the head of the reversed list; {@code null} when the input list is empty
     */
    public static ListNode reverseList(ListNode head) {

        if(head == null) return null;

        ListNode current = head;
        ListNode prev = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
