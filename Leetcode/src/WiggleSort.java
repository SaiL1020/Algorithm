import java.util.Arrays;

/**
 * Created by sail on 10/2/16.
 * Code one more line :)
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        /*  O(n logn)
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = tmp;
        }
        */
        // O(n)
        for (int i = 1; i < nums.length; i++) {
            if (isOdd(i) && nums[i] < nums[i - 1] ||
                    !isOdd(i) && nums[i] > nums[i - 1]) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            }
        }
    }
    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    public void run() {
        int[] nums = new int[]{1,2,5,3,4,6,9};
        wiggleSort(nums);
        for (int k : nums) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new WiggleSort().run();
    }
}
