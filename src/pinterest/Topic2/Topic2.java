package pinterest.Topic2;

public class Topic2 {

    public SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (position == 0) {
            newNode.next = llist;
            return newNode;
        }
        SinglyLinkedListNode current = llist;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return llist;
    }


    public boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        SinglyLinkedListNode turtle = head;
        SinglyLinkedListNode hare = head;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }

}
