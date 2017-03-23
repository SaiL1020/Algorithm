package weekly24;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sail
 * time 3/19/17 12:39 AM
 * project Algorithm
 */
public class ContestMatch {
    public String findContestMatch(int n) {
        Deque<String> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.add(String.valueOf(i));
        }
        while (dq.size() > 1) {
            int size = dq.size();
            Deque<String> tmp = new LinkedList<>();
            for (int i = 0; i < size / 2; i++) {
                tmp.add("(" + dq.pollFirst() + "," + dq.pollLast() + ")");
            }
            dq = tmp;
        }
        return dq.poll();
    }

    private void run() {
        for (int i = 2; i <= 16; i *= 2) {
            System.out.println(findContestMatch(i));
        }
    }
    public static void main(String[] args) {
        new ContestMatch().run();
    }
}
