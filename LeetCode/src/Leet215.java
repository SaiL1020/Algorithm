/**
 * Created by sail on 9/11/16.
 * Code one more line :)
 */
public class Leet215 {
    int[] arr;
    int K;
    public int findKthLargest(int[] nums, int k) {
        arr = nums;
        K = k - 1;
        return search(0, nums.length - 1);
    }
    public int search(int l, int r) {
        if (l > r) return Integer.MAX_VALUE;
        int p = arr[r];
        int k = l;
        for (int i = l; i < r; i++) {
            if (arr[i] >= p)
                swap(i, k++);
        }
        swap(k, r);
        if (k == K) return arr[k];
        else if (k < K) return search(k + 1, r);
        else return search(l, k - 1);
    }
    public void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public void run() {
        int k = 6;
        int[] nums = new int[]{2,3,1,5,6,4};
        int ans = findKthLargest(nums, k);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        new Leet215().run();
    }
}
