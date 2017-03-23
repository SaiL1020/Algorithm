/**
 * Created by sail on 9/13/16.
 * Code one more line :)
 */
public class Leet34 {
    int[] arr;
    int key;
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        arr = nums;
        key = target;
        int l = search1(-1, nums.length - 1);
        int r = search2(0, nums.length);
        if (nums[l] != target || nums[r - 1] != target) return new int[]{-1, -1};
        return new int[]{l, r - 1};
    }

    public int search1(int l, int r) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (arr[m] >= key) r = m;
            else l = m;
        }
        return r;
    }

    public int search2(int l, int r) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (arr[m] > key) r = m;
            else l = m;
        }
        return r;
    }

    public void run() {
        int[] nums = new int[]{7,7,7};
        int[] ans = searchRange(nums, 7);
        System.out.println(ans[0] + " " + ans[1]);
    }
    public static void main(String[] args) {
        new Leet34().run();
    }
}
