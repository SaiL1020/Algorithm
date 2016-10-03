import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by sail on 9/21/16.
 * Code one more line :)
 */
public class Leet33 {
    public int search(int[] nums, int target) {
        int l = -1, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[l < 0 ? 0 : l] <= nums[m]) {
                if (nums[l < 0 ? 0 : l] <= target && target <= nums[m]) r = m;
                else l = m;
            } else {
                if (nums[m] < target && target <= nums[r]) l = m;
                else r = m;
            }
        }
        return nums[r] == target ? r : -1;
    }

    public void run() {
        int[] nums = new int[]{8,1,2,3,4,5,6,7};
        int k;
        Scanner sc = new Scanner(System.in);
        while (true) {
            k = sc.nextInt();
            if (k == -1) break;
            System.out.println(search(nums, k));
        }
    }
    public static void main(String[] args) {
        new Leet33().run();
    }
}
