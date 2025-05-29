package pinterest.Topic3;

import java.util.Stack;

public class MyQueueWithTwoStacks {
    Stack<Integer> stackIn = new Stack<>();
    Stack<Integer> stackOut = new Stack<>();

    public void enqueue(Integer element) {
        stackIn.push(element);
    }

    public void dequeue() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
        if (!stackOut.empty()) {
            stackOut.pop();
        }
    }

    public int peek() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }
}
