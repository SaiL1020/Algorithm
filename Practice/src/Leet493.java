import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sail on 2/11/17.
 * TLE -> slow
 * large case around 200ms
 */
public class Leet493 {
    Map<Long, Integer> bit;
    final long START = 1L << 32;
    final long END = START << 1;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        bit = new HashMap<>();
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += getsum(nums[i] - 1);

            // even with optimization here
            if (nums[i] < Integer.MAX_VALUE / 2)
                update(nums[i] * 2L);
        }
        return ans;
    }
    long lowbit(long i) {
        return i & -i;
    }
    void update(long x) {
        for (x += START ; x <= END; x += lowbit(x)) {
            bit.put(x, bit.getOrDefault(x, 0) + 1);
        }
    }
    int getsum(long x) {
        int sum = 0;
        for (x += START ; x > 0; x -= lowbit(x)) {
            sum += bit.getOrDefault(x, 0);
        }
        return sum;
    }

    private void run() {
        String[] line = new Scanner(System.in).nextLine().split(",");
        int[] nums = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();

        long startTime = System.currentTimeMillis();
        System.out.println(reversePairs(nums));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
    public static void main(String[] args) {
        new Leet493().run();
    }
}
