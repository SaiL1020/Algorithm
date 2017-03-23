/**
 * Created by sail on 9/11/16.
 * Code one more line :)
 */
public class Leet33 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    public int binarySearch(int[] nums, int l, int r, int tar) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        System.out.println(nums[l] + " " + nums[r] + " " + nums[mid]);
        if (nums[mid] == tar) return mid;
        if (nums[l] < nums[r]) {
            if (nums[mid] < tar) return binarySearch(nums, mid + 1, r, tar);
            return binarySearch(nums, l, mid - 1, tar);
        }
        int ll = binarySearch(nums, l, mid - 1, tar);
        int rr = binarySearch(nums, mid + 1, r, tar);
        return Math.max(ll, rr);
    }

    public void run() {
        int s = 4;
        int[] nums = new int[]{4,5,5,6,7,0,0,1,2,3,4};
        int ans = search(nums, s);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        new Leet33().run();
    }
}
