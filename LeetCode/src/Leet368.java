import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sail on 12/14/16.
 * largestDivisibleSubset
 */
public class Leet368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max = 0, index = -1;
        int[] cnt = new int[n], pre = new int[n];
        Arrays.fill(cnt, 1);
        Arrays.fill(pre, -1);
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (cnt[i] < cnt[j] + 1) {
                        cnt[i] = cnt[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (cnt[i] > max) {
                max = cnt[i];
                index = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (index != -1) {
            //System.out.println(pre[index]);
            ans.add(nums[index]);
            index = pre[index];
        }
        return ans;
    }
}
