/**
 * Created by sail on 9/11/16.
 * Code one more line :)
 */
public class Leet153 {
    public int findMin(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (nums[l] <= nums[r]) return nums[l];
        int mid = l + (r - l) / 2;
        System.out.println(nums[l] + " " + nums[mid] + " " + nums[r]);
        if (nums[mid] > nums[r])
            return search(nums, mid + 1, r);
        return search(nums, l + 1, mid);
    }

    public void run() {
        int[] nums = new int[]{3,2};
        int ans = findMin(nums);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        new Leet153().run();
    }
}
