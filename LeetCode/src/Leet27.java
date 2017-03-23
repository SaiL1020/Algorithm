/**
 * Created by sail on 8/31/16.
 * Code one more line :)
 */
public class Leet27 {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length;
        while (l < r) {
            if (nums[l] == val) {
                while (l < r && nums[--r] == val) ;
                nums[l] = nums[r];
            }
            l++;
        }
        return r;
    }
}
