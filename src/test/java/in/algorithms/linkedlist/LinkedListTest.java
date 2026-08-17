package in.algorithms.linkedlist;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.implementeddatastructures.Node;
import in.algorithms.implementeddatastructures.Queue;
import in.algorithms.linkedlist.removeduplicates.LinkedListRemoveDuplicates;
import in.algorithms.linkedlist.removeduplicates.LinkedListFindStartOfLoop;
import in.algorithms.findnthlastnode.FindNthLastNode;
import in.algorithms.linkedlistaddition.AddLinkedList;

public class LinkedListTest {

    private <T> Node<T> createList(T[] elements) {
        Node<T> head = null;
        Node<T> tail = null;
        for (T el : elements) {
            Node<T> node = new Node<T>(el);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

    @Test
    public void testRemoveDuplicates() {
        LinkedListRemoveDuplicates.main(new String[]{});

        LinkedListRemoveDuplicates remover = new LinkedListRemoveDuplicates();
        Node<Integer> list = createList(new Integer[]{8, 4, 8, 2, 1, 4, 8, 1, 2, 4, 1});
        Node<Integer> deduplicated = remover.removeDuplicates(list);
        Assert.assertNotNull(deduplicated);
    }

    @Test
    public void testFindStartOfLoop() {
        LinkedListFindStartOfLoop detector = new LinkedListFindStartOfLoop();

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> (back to 3)
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n4 = new Node<Integer>(4);
        Node<Integer> n5 = new Node<Integer>(5);
        Node<Integer> n6 = new Node<Integer>(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3; // Cycle starts at n3

        Node<Integer> loopStart = detector.findStartOfTheLoop(n1);
        Assert.assertNotNull(loopStart);
        Assert.assertEquals(Integer.valueOf(3), loopStart.item);
    }

    @Test
    public void testFindStartOfLoopWhenNoLoop() {
        LinkedListFindStartOfLoop detector = new LinkedListFindStartOfLoop();
        Node<Integer> list = createList(new Integer[]{1, 2, 3, 4, 5});

        Node<Integer> loopStart = detector.findStartOfTheLoop(list);
        Assert.assertNull(loopStart);
    }

    @Test
    public void testFindNthLastNode() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1).enqueue(2).enqueue(3).enqueue(4).enqueue(5);

        Assert.assertEquals(Integer.valueOf(4), FindNthLastNode.findNthLastNode(queue, 2));
        Assert.assertEquals(Integer.valueOf(5), FindNthLastNode.findNthLastNode(queue, 1));
        Assert.assertEquals(Integer.valueOf(1), FindNthLastNode.findNthLastNode(queue, 5));
    }

    @Test
    public void testAddLinkedList() {
        AddLinkedList.main(new String[]{});

        AddLinkedList adder = new AddLinkedList();
        Node<Integer> list1 = createList(new Integer[]{9, 8, 8, 9, 9});
        Node<Integer> list2 = createList(new Integer[]{7, 9, 2});
        Node<Integer> res = adder.addLists(list1, list2);
        Assert.assertNotNull(res);
    }
}
