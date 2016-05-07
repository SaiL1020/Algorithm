/**
 * Created by sail on 3/29/16.
 */

// First Missing Positive Number
public class Leet41 {
    public int Leet41 (int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int cur = nums[i];
            while (0 < cur && cur <= length && cur - 1 != i && nums[cur - 1] != cur) {
                int temp = nums[cur - 1];
                nums[cur - 1] = cur;
                nums[i] = temp;
                cur = nums[i];
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return length + 1;
    }
}
