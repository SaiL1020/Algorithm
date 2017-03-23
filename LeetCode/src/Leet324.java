/**
 * Created by sail on 6/22/16.
 * Code one more line :)
 */
public class Leet324 {
    public void wiggleSort(int[] nums) {
        int median = findMedian(nums, 0, nums.length - 1, (nums.length + 1) / 2);
        System.out.println(median);


        int left = 0, right = nums.length - 1, mid = (nums.length - 1) / 2;
        int[] newnums = new int[nums.length];
        for (int num1 : nums) {
            if (num1 < median) newnums[left++] = num1;
            else if (num1 > median) newnums[right--] = num1;
        }
        while (left <= right) newnums[left++] = median;
//        while (right > mid) newnums[right--] = median;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(newnums[i] + " ");
        }
        System.out.println();
        right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i & 1) == 0 ? newnums[mid--] : newnums[right--];
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int findMedian(int[] nums, int L, int R, int k) {
        if (L >= R) return nums[R];
        int pos = partition(nums, L, R);
        int cnt = pos - L + 1;
        if (cnt == k) return nums[pos];
        return cnt > k ? findMedian(nums, L, pos - 1, k) : findMedian(nums, pos + 1, R, k - cnt);
    }

    public int partition(int[] nums, int L, int R) {
        int val = nums[L];
        int i = L, j = R + 1;
        for (;;) {
            while (++i < R && nums[i] < val) ;
            while (--j > L && nums[j] > val) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, L, j);
        return j;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
