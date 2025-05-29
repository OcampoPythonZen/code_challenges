package pinterest.Topic2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Topic2Test {

    Topic2 topic2 = new Topic2();

    @Test
    public void shouldInsertNewNodeAtPositionZero() {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(1);
        node1.next = new SinglyLinkedListNode(2);
        SinglyLinkedListNode currentHead = node1;
        currentHead = topic2.insertNodeAtPosition(currentHead, 100, 0);
        Assertions.assertEquals(100, currentHead.data);
        currentHead = currentHead.next;
        Assertions.assertEquals(1, currentHead.data);
        currentHead = currentHead.next;
        Assertions.assertEquals(2, currentHead.data);
    }

    @Test
    public void shouldInsertInOtherPositionWhenPutOtherData() {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(1);
        node1.next = new SinglyLinkedListNode(2);
        SinglyLinkedListNode currentHead = node1;
        currentHead = topic2.insertNodeAtPosition(currentHead, 100, 2);
        Assertions.assertEquals(1, currentHead.data);
        currentHead = currentHead.next;
        Assertions.assertEquals(2, currentHead.data);
        currentHead = currentHead.next;
        Assertions.assertEquals(100, currentHead.data);
    }


    @Test
    public void shouldReturnTrueWhenIsCycle() {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        Assertions.assertTrue(topic2.hasCycle(node1));
    }

    @Test
    public void shouldReturnFalseWhenIsCycle() {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(6);
        node1.next = node2;
        node2.next = node3;
        Assertions.assertFalse(topic2.hasCycle(node1));
    }

    @Test
    public void shouldReturnFalseWhenHeadOrHareNextIsNull() {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(1);
        node1.next = null;
        Assertions.assertFalse(topic2.hasCycle(node1));
    }

    @Test
    public void shouldReturnFalseWhenHeadIsNull() {
        Assertions.assertFalse(topic2.hasCycle(null));
    }

    @Test
    public void shouldReturnFalseWhenListIsLongerAndNoCycle() {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode node4 = new SinglyLinkedListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Assertions.assertFalse(topic2.hasCycle(node1));
    }



}
