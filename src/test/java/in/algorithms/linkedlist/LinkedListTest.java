package in.algorithms.linkedlist;

import in.algorithms.findnthlastnode.FindNthLastNode;
import in.algorithms.implementeddatastructures.Node;
import in.algorithms.linkedlist.removeduplicates.LinkedListFindStartOfLoop;
import in.algorithms.linkedlist.removeduplicates.LinkedListRemoveDuplicates;
import in.algorithms.linkedlist.reverse.ReverseByKNodes;
import in.algorithms.linkedlist.reverse.ReverseLinkedList;
import in.algorithms.linkedlistaddition.AddLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testLoopDetectionAndOrigin() {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3; // Cycle starts at n3

        Node<Integer> loopStart = LinkedListFindStartOfLoop.findStartOfLoop(n1);
        Assert.assertNotNull(loopStart);
        Assert.assertEquals(Integer.valueOf(3), loopStart.item);
    }

    @Test
    public void testRemoveDuplicates() {
        Node<Integer> head = new Node<>(1)
                .setNext(new Node<>(2)
                        .setNext(new Node<>(2)
                                .setNext(new Node<>(3)
                                        .setNext(new Node<>(1)))));

        LinkedListRemoveDuplicates.removeDuplicatesWithSet(head);

        Assert.assertEquals(Integer.valueOf(1), head.item);
        Assert.assertEquals(Integer.valueOf(2), head.next.item);
        Assert.assertEquals(Integer.valueOf(3), head.next.next.item);
        Assert.assertNull(head.next.next.next);
    }

    @Test
    public void testReverseLinkedList() {
        Node<Integer> head = new Node<>(1).setNext(new Node<>(2).setNext(new Node<>(3)));
        Node<Integer> reversed = ReverseLinkedList.reverse(head);

        Assert.assertEquals(Integer.valueOf(3), reversed.item);
        Assert.assertEquals(Integer.valueOf(2), reversed.next.item);
        Assert.assertEquals(Integer.valueOf(1), reversed.next.next.item);
        Assert.assertNull(reversed.next.next.next);
    }

    @Test
    public void testReverseByKGroup() {
        Node<Integer> head = new Node<>(1)
                .setNext(new Node<>(2)
                        .setNext(new Node<>(3)
                                .setNext(new Node<>(4)
                                        .setNext(new Node<>(5)))));

        Node<Integer> res = ReverseByKNodes.reverseKGroup(head, 2);
        Assert.assertEquals(Integer.valueOf(2), res.item);
        Assert.assertEquals(Integer.valueOf(1), res.next.item);
        Assert.assertEquals(Integer.valueOf(4), res.next.next.item);
        Assert.assertEquals(Integer.valueOf(3), res.next.next.next.item);
        Assert.assertEquals(Integer.valueOf(5), res.next.next.next.next.item);
    }

    @Test
    public void testFindNthLastNode() {
        Node<String> head = new Node<>("A")
                .setNext(new Node<>("B")
                        .setNext(new Node<>("C")
                                .setNext(new Node<>("D"))));

        Assert.assertEquals("D", FindNthLastNode.findNthLastNode(head, 1).item);
        Assert.assertEquals("C", FindNthLastNode.findNthLastNode(head, 2).item);
        Assert.assertEquals("A", FindNthLastNode.findNthLastNode(head, 4).item);
        Assert.assertNull(FindNthLastNode.findNthLastNode(head, 5));
    }

    @Test
    public void testAddLinkedLists() {
        // 7 -> 1 -> 6 (617) + 5 -> 9 -> 2 (295) = 2 -> 1 -> 9 (912)
        Node<Integer> l1 = new Node<>(7).setNext(new Node<>(1).setNext(new Node<>(6)));
        Node<Integer> l2 = new Node<>(5).setNext(new Node<>(9).setNext(new Node<>(2)));

        Node<Integer> sum = AddLinkedList.addLists(l1, l2);
        Assert.assertEquals(Integer.valueOf(2), sum.item);
        Assert.assertEquals(Integer.valueOf(1), sum.next.item);
        Assert.assertEquals(Integer.valueOf(9), sum.next.next.item);
        Assert.assertNull(sum.next.next.next);
    }
}
