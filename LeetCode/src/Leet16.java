import java.util.Arrays;

/**
 * Created by sail on 9/13/16.
 * Code one more line :)
 */
public class Leet16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, m = 1, r = nums.length - 1;
        int add = nums[l] + nums[m] + nums[r];
        int ans = add;
        while (l < m && m < r) {
            System.out.println(l + " " + m + " " + r);
            add = nums[l] + nums[m] + nums[r];
            if (Math.abs(add - target) <= Math.abs(ans - target)) {
                ans = add;
                if (ans == target)
                    return ans;
            }
            if (add > target) {
                if (r - 1 > m)
                    r--;
                else {
                    l++;
                    m = l + 1;
                }

            } else {
                if (m + 1 < r) m++;
                else {
                    l++;
                    m = l + 1;
                    System.out.println("l: " + l + " r: " + r);
                }
            }
        }
        return ans;
    }

    public void run() {
        int[] nums = new int[]{1,2,4,8,16,32,64,128};
        int tar = 82;
        System.out.println(threeSumClosest(nums, tar));
    }
    public static void main(String[] args) {
        new Leet16().run();
    }
}
