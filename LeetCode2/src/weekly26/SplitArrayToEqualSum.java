package weekly26;

import java.util.HashSet;
import java.util.Set;

/**
 * author:      SaiL1020
 * time:        4/1/17 9:43 PM
 * project:     Algorithm
 */
public class SplitArrayToEqualSum {
//    public boolean splitArray(int[] nums) {
//        if (nums == null || nums.length < 7) return false;
//        int n = nums.length;
//        int[] sum = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            sum[i + 1] = sum[i] + nums[i];
//        }
//        for (int i = 1; i < n - 5; i++) {
//            for (int k = n - 2; k > 4; k--) {
//                if (sum[i] == sum[n] - sum[k + 1]) {
//                    System.out.println(sum[i] + " " + (sum[n] - sum[k + 1]));
//                    for (int j = i + 2; j <= k - 2; j++) {
//                        if (sum[j] - sum[i + 1] == sum[k] - sum[j + 1]) {
//                            if (sum[j] - sum[i + 1] == sum[i]) {
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7) return false;
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int j = 3; j < n - 3; ++j) {
            Set<Integer> sumSet = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i] == sum[j] - sum[i + 1])
                    sumSet.add(sum[i]);
            }
            for (int k = j + 2; k < n - 1; k++) {
                if (sum[k] - sum[j + 1] == sum[n] - sum[k + 1]) {
                    if (sumSet.contains(sum[k] - sum[j + 1]))
                        return true;
                }
            }
        }
        return false;
    }

    private void run() {
        System.out.println(splitArray(new int[]{1,2,1,2,1,2,1}));
    }
    public static void main(String[] args) {
        new SplitArrayToEqualSum().run();
    }
}