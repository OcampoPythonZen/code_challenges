package pinterest.Topic6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Topic6Test {

    Topic6 topic6 = new Topic6();
    SolutionQHeap solutionQHeap = new SolutionQHeap();

    @Test
    public void shouldReturnRootWhenInsertIntoBinaryTree() {
        Node root = new Node(4); // Root node.
        root.left = new Node(2);
        root.right = new Node(7);
        /*
                4 -> root
               |  \
               2   7    ->  new nodes.
         */

        root.left.left = new Node(1);
        root.right.right = new Node(3);
        /*
                4 -> root
               |  \
               2   7    ->  new nodes.
              | \
             1   3    ->  new nodes.
         */
        int data = 6;
        Node updateRoot = topic6.insert(root, data);

        Assertions.assertEquals(4, root.data);
        Assertions.assertNotNull(updateRoot.right.left);
        Assertions.assertEquals(6, updateRoot.right.left.data);
    }

    @Test
    public void shouldReturnHeightWhenSeeTree() {
        Node root = new Node(1); // Root node.
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(10);
        root.left.left.left = new Node(20);
        root.right.right = new Node(4);
        /*
                1 -> root
               |  \
               2   3    ->  new nodes.
              |     \
             10      4
             |
            20
         */
        int result = topic6.height(root);
        Assertions.assertEquals(3, result);
    }


    @Test
    public void shouldQHeapWhenIsCompleted() {
        solutionQHeap.insert(2);
        solutionQHeap.insert(4);
        solutionQHeap.insert(1);
        System.out.println(solutionQHeap.pq);
        Assertions.assertEquals(3, solutionQHeap.pq.size());
        solutionQHeap.delete(4);
        Assertions.assertEquals(3, solutionQHeap.pq.size());
        Assertions.assertEquals(1, solutionQHeap.deleted.size());
        System.out.println(solutionQHeap.deleted);
        solutionQHeap.printMin();
    }


}
