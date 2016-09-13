/**
 * Created by sail on 9/12/16.
 * Code one more line :)
 */
public class Leet300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] < dp[0])  { // new smallest
                dp[0] = nums[i];
            } else if (nums[i] > dp[len - 1]) { // biggest, expand
                dp[len++] = nums[i];
                //System.out.println(dp[len - 1]);
            } else {
                int index = binSearch(dp, -1, len - 1, nums[i]);
                //System.out.println("index: " + index);
                dp[index] = nums[i];
            }
        }
        return len;
    }
    public int binSearch(int[] dp, int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (dp[m] >= key) r = m;
            else l = m;
        }
        return r;
    }

    public void run() {
        int[] nums = new int[]{10,9,2,5,3,4};
        int ans = lengthOfLIS(nums);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        new Leet300().run();
    }
}
