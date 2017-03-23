import java.util.Arrays;

/**
 * Created by sail on 12/14/16.
 * 280. Wiggle Sort
 */
public class Leet280 {
    public void wiggleSort(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            int a = nums[i-1];
            if ((i%2 == 1) == (a > nums[i])) {
                nums[i-1] = nums[i];
                nums[i] = a;
            }
        }
    }

    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++) {
            if(i % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
}
