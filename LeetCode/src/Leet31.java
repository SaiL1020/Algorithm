/**
 * Created by sail on 9/14/16.
 * Code one more line :)
 */
public class Leet31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i, k;
        for (i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i])
                break;
        }
        if (i == 0) {
            int r = nums.length - 1;
            while (i < r) swap(nums, i++, r--);
            return ;
        }
        int min = Integer.MAX_VALUE, j = -1;
        System.out.println(i);
        for (k = i; k < nums.length; k++) {
            if (nums[k] > nums[i - 1]) {
                if (nums[k] <= min) {
                    min = nums[k];
                    j = k;
                    System.out.println("--");
                }
            }
        }
        if (j != -1) {
            System.out.println("==");
            swap(nums, i - 1, j);
        }
        int r = nums.length - 1;
        while (i < r) swap(nums, i++, r--);
    }
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void run() {
        int[] nums = new int[]{2,3,1,3,3};
        nextPermutation(nums);
        for (int k : nums)
            System.out.print(k + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        new Leet31().run();
    }
}
