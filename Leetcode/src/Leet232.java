import java.util.Stack;

/**
 * Created by sail on 9/3/16.
 * Code one more line :)
 */
public class Leet232 {

}

class MyQueue {
    Stack<Integer> sta1 = new Stack<>();
    Stack<Integer> sta2 = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        sta1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        sta2.pop();
    }

    // Get the front element.
    public int peek() {
        if (sta2.isEmpty()) {
            while (!sta1.isEmpty()) {
                sta2.push(sta1.pop());
            }
        }
        return sta2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return sta1.isEmpty() && sta2.isEmpty();
    }
}