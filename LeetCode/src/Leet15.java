import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by sail on 9/13/16.
 * Code one more line :)
 */
public class Leet15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        int l = 0, m, r;
        while (l < nums.length - 2) {
            if (nums[l] > 0) break;
            m = l + 1;
            r = nums.length - 1;
            if (l != 0 && nums[l] == nums[l - 1]) {
                l++;
                continue;
            }
            while (m < r) {
                //System.out.println(l + " " + m + " " + r);
                if (l != m - 1 && nums[m] == nums[m - 1]) {
                    m++;
                    continue;
                }
                int sum = nums[l] + nums[m] + nums[r];
                if (sum == 0) ans.add(Arrays.asList(nums[l], nums[m++], nums[r]));
                else if (sum < 0) m++;
                else r--;
            }
            l++;
        }
        return ans;
    }

    public void run() {
        int[] nums = new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,
                -5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,
                -12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,
                -2,-5,-11,1,3,-6};
        System.out.println(threeSum(nums));
    }
    public static void main(String[] args) {
        new Leet15().run();
    }
}
