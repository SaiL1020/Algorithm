/**
 * Created by sail on 9/13/16.
 * Code one more line :)
 */
public class Leet35 {
    int[] arr;
    int key;
    public int searchInsert(int[] nums, int target) {
        arr = nums;
        key = target;
        return search(-1, nums.length);
    }
    public int search(int l, int r) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (arr[m] >= key) r = m;
            else l = m;
        }
        return r;
    }

    public void run() {
        int[] nums = new int[]{1,3,5,6};
        int ans = searchInsert(nums, 8);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        new Leet35().run();
    }
}
