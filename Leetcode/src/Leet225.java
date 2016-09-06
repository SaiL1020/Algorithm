import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sail on 9/5/16.
 * Code one more line :)
 */
public class Leet225 {
}

class MyStack {
    Queue<Integer> que = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        que.add(x);
        int sz = que.size();
        while (--sz > 0) {
            que.add(que.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        que.poll();
    }

    // Get the top element.
    public int top() {
        return que.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return que.isEmpty();
    }
}