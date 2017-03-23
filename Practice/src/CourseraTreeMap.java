import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sail on 10/15/16.
 * Coursera TreeMap
 */
public class CourseraTreeMap {
    public List<Integer> countNonZeros(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        for (Map.Entry entry : map.entrySet()) {
            len -= (int)entry.getValue();
            ans.add(len);
        }
        return ans;
    }

    private void run() {
        int[] nums = new int[]{1,2,2,3,4,3,3,3,4};
        List<Integer> list = countNonZeros(nums);
        for (int k : list) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new CourseraTreeMap().run();
    }
}
