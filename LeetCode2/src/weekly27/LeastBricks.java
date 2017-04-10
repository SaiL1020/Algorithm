package weekly27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:      SaiL1020
 * time:        4/8/17 9:30 PM
 * project:     Algorithm
 */
public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (int val : map.values()) {
            if (val > max) {
                max = val;
            }
        }
        return wall.size() - max;
    }

    private void run() {
//        while (true) {
//            int n = new Scanner(System.in).nextInt();
//            System.out.println(nextGreaterElement(n));
//        }
    }
    public static void main(String[] args) {
        new LeastBricks().run();
    }
}
