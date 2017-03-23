/**
 * Created by sail on 9/3/16.
 * Code one more line :)
 */
public class Leet53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Leet53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
