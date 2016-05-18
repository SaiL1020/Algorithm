/**
 * Created by sail on 5/18/16.
 */

import java.util.*;

public class Leet239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        DecreasingQueue decQueue = new DecreasingQueue(nums.length);
        for (int i = 0; i < nums.length; i++) {
            decQueue.push(nums[i], i);
            while(decQueue.posMaxValue() <= i - k) decQueue.pop();
            if (i >= k - 1) ret.add(decQueue.maxValue());
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }

    class DecreasingQueue {
        private int[] queue, pos;
        private int front, rear;

        public DecreasingQueue(int size) {
            queue = new int[size];
            pos = new int[size];
            front = rear = 0;
        }

        public void push(int value, int position) {
            while (rear != front && queue[rear - 1] < value) --rear;
            queue[rear] = value;
            pos[rear++] = position;
        }

        public void pop() {
            front++;
        }

        public int maxValue() {
            return queue[front];
        }

        public int posMaxValue() {
            return pos[front];
        }
    }
}
