import java.util.HashSet;
import java.util.Set;

/**
 * Created by sail on 12/14/16.
 * 421. Maximum XOR of Two Numbers in an Array
 */
public class Leet421 {
    class Trie {
        Trie[] next;
        Trie() {
            next = new Trie[2];
        }
    }
    Trie root;
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        root = new Trie();
        for (int n : nums) {
            Trie cur = root;
            for (int i = 30; i >= 0; i--) {
                int mask = 1 << i;
                int b = (mask & n) != 0 ? 1 : 0;
                if (cur.next[b] == null) {
                    cur.next[b] = new Trie();
                }
                cur = cur.next[b];
            }
        }
        int max = 0;
        for (int n : nums) {
            Trie cur = root;
            int curSum = 0;
            for (int i = 30; i >= 0; i--) {
                int mask = 1 << i;
                int b = (mask & n) != 0 ? 1 : 0;
                if (cur.next[b ^ 1] != null) {
                    curSum += (1 << i);
                    cur = cur.next[b ^ 1];
                } else {
                    cur = cur.next[b];
                }
            }
            max = Math.max(max, curSum);
        }
        return max;
    }

    public int findMaximumXOR2(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){

            // reserve Left bits and ignore Right bits
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }

            int tmp = max | (1 << i);

            // in each iteration, there are pair(s) whose Left bits can XOR to max
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
