import java.util.LinkedList;
import java.util.List;

/**
 * Created by sail on 10/10/16.
 * Code one more line :)
 */
public class Leet78 {
    public List<List<Integer>> subsets(int[] nums) {
        int sz = nums.length;
        int pow = (int)Math.pow(2, sz);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < pow; i++) {
            List<Integer> cur = new LinkedList<>();
            for (int j = 0; j < sz; j++) {
                if (((1 << j) & i) == 1) {
                    cur.add(nums[j]);
                }
            }
            ans.add(cur);
        }
        return ans;
    }
}
