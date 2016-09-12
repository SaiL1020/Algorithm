/**
 * Created by sail on 9/11/16.
 * Code one more line :)
 */
public class Leet209 {
    public int minSubArrayLen(int s, int[] nums) {
        int add = 0, st = 0, ed = 0, ans = nums.length + 1;
        while (ed < nums.length) {
            while (ed < nums.length && add < s) add += nums[ed++];
            if (add < s) break;
            while (st < ed && add >= s) add -= nums[st++];
            ans = Math.min(ans, ed - st + 1);
        }
        return ans == nums.length + 1 ? 0 : ans;
    }

    public void run() {
        int s = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        int ans = minSubArrayLen(s, nums);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        new Leet209().run();
    }
}
