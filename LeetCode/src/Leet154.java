/**
 * Created by sail on 9/11/16.
 * Code one more line :)
 */
public class Leet154 {
    public int findMin(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (nums[l] < nums[r] || l == r) return nums[l];
        int mid = l + (r - l) / 2;
        System.out.println(nums[l] + " " + nums[mid] + " " + nums[r] + "===" + l + " " + r);
        if (nums[mid] > nums[r])
            return search(nums, mid + 1, r);
        if (nums[mid] < nums[r])
            return search(nums, l + 1, mid);
        if (l == mid) return nums[l];
        int ll = search(nums, l, mid - 1);
        int rr = search(nums, mid + 1, r);
        return Math.min(ll, rr);
    }

    public void run() {
        int[] nums = new int[]{2,3,1};
        int ans = findMin(nums);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        new Leet154().run();
    }
}
