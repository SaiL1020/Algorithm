/**
 * Created by sail on 9/4/16.
 * Code one more line :)
 */
public class Leet152 {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(nums[i], Math.max(tmp * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(tmp * nums[i], min * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        //int ans = new Leet152().maxProduct(new int[]{2,-5,-2,-4,3});
        int ans = -2 / 10;
        System.out.println(ans);
    }
}
