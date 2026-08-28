package in.algorithms.interviewprep.reverselinkedlist;

// LeetCode's standard singly-linked list node definition, as given in the problem statement.
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
