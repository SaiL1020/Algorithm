import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sail on 9/12/16.
 * Code one more line :)
 */
public class Leet354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        sort(envelopes);
        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int index = binSearch(dp, -1, len, envelopes[i][1]);
            //if (index == n) index = 0;
            //System.out.println(index + " " + dp[index] + " " + envelopes[i][1]);
            dp[index] = envelopes[i][1];
            if (index == len) len++;
        }
        return len;
    }

    public void sort(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
    }

    public int binSearch(int[] dp, int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (dp[m] >= key) r = m;
            else l = m;
        }
        return r;
    }

    public void run() {
        int[][] nums = new int[][]{{5,4},{7,8},{6,7},{2,3}};
        int ans = maxEnvelopes(nums);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        new Leet354().run();
    }
}
