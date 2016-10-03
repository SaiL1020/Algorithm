/**
 * Created by sail on 10/2/16.
 * Code one more line :)
 */
public class Leet410 {
    private int[] narray;
    private long[] sum;
    private int M, N, Max;
    public int splitArray(int[] nums, int m) {
        narray = nums;
        N = nums.length;
        M = m;
        sum = new long[N];
        sum[0] = nums[0];
        Max = nums[0];
        for (int i = 1; i < N; i++) {
            Max = Math.max(Max, nums[i]);
            sum[i] = sum[i - 1] + nums[i];
        }
        if (m == 1) return (int) sum[N - 1];
        if (m >= N - 1) return Max;
        long l = Max - 1, r = sum[N - 1];
        while (l < r - 1) {
            long mid = l + (r - l) / 2;
            //System.out.println("11: " + l + " " + r + " " + mid);
            if (valid(mid)) r = mid;
            else l = mid;
            //System.out.println("12: " + l + " " + r + " " + mid);
        }
        return (int) r;
    }
    private boolean valid(long target) {
        int cnt = 0;
        long offset = 0;
        boolean first = true;
        int l = 0, r = N;
        while (l < N - 1) {
            if (first) {
                offset = 0;
                first = false;
            } else {
                offset = sum[l];
            }
            r = N;
            long cur = 0;
            while (l < r - 1) {
                int mid = l + (r - l) / 2;
                cur = sum[mid] - offset;
                if (cur <= target) l = mid;
                else r = mid;
            }
            //System.out.println(l + " " + r + " " + (cnt + 1));
            if (++cnt == M && l < N - 1) {
                return false;
            }
        }
        return true;
    }

    private void run() {
        int[] nums = new int[]{1,2,3,4,5};
        int m = 4;
        System.out.println(splitArray(nums, m));
    }
    public static void main(String[] args) {
        new Leet410().run();
    }
}
