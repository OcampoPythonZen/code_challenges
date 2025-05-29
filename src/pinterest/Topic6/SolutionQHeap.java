package pinterest.Topic6;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SolutionQHeap {

    public final PriorityQueue<Integer> pq = new PriorityQueue<>();
    public final Set<Integer> deleted = new HashSet<>();

    public void insert(int x) {
        pq.add(x);
    }

    public void delete(int x) {
        deleted.add(x);
    }

    public void printMin() {
        while (!pq.isEmpty() && deleted.contains(pq.peek())) {
            deleted.remove(pq.poll());
        }
        System.out.println(pq.peek());
    }
}
