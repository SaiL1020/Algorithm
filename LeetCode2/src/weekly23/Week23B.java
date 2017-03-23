package weekly23;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sail on 3/11/17.
 * Minimum Time Difference
 */
public class Week23B {
    public int findMinDifference(List<String> timePoints) {
        int[] mins = new int[timePoints.size()];
        int ret = 2000;
        for (int i = 0; i < timePoints.size(); i++) {
            mins[i] = toMin(timePoints.get(i));
        }
        Arrays.sort(mins);
        for (int i = 0; i < mins.length - 1; i++) {
            ret = Math.min(ret, mins[i + 1] - mins[i]);
        }
        return Math.min(ret, 1440 - mins[mins.length - 1] + mins[0]);
    }
    private int toMin(String str) {
        String[] s = str.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    private void run() {
        String[] str = {"23:50","00:00","00:05"};
        List<String> list = Arrays.asList(str);
        System.out.println(findMinDifference(list));
    }
    public static void main(String[] args) {
        new Week23B().run();
    }
}
