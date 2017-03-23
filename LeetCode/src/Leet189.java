/**
 * Created by sail on 5/20/16.
 * Code one more line :)
 */
public class Leet189 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return ;
        if (k >= nums.length) k %= nums.length;
        int veryfirst = nums[0];
        int i = 0, tot = 0;
        do {
            int first = i + k;
            int pos = i + k;
            int pre = nums[i];
            do {
                int cur = nums[pos];
                nums[pos] = pre;
                pre = cur;
                pos = (pos + k) % nums.length;
                ++tot;
            } while (pos != first && tot != nums.length);
            i++;
        } while (tot != nums.length);
    }
}
