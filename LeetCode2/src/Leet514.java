/**
 * Created by sail on 3/4/17.
 * findRotateSteps
 */
public class Leet514 {
    int[] dp;
    char[] r, k;
    public int findRotateSteps(String ring, String key) {
        r = ring.toCharArray();
        int lr = r.length;
        dp = new int[lr];
        key = r[0] + key;
        k = key.toCharArray();

        int cnt = 0;
        for (int i = 1; i < k.length; i++) {
            cnt = dial(i);
        }
        return cnt + k.length - 1;
    }
    private int dial(int cur) {
        int ret = Integer.MAX_VALUE;
        if (cur == 1) {
            for (int i = 0; i < r.length; i++) {
                if (r[i] == k[cur]) {
                    dp[i] = calc(0, i);
                    ret = Math.min(ret, dp[i]);
                }
            }
        } else {
            for (int j = 0; j < r.length; j++) {
                if (r[j] == k[cur]) {
                    int cnt = Integer.MAX_VALUE;
                    for (int i = 0; i < r.length; i++) {
                        if (r[i] == k[cur - 1]) {
                            cnt = Math.min(cnt, calc(i, j) + dp[i]);
                        }
                    }
                    dp[j] = cnt;
                    ret = Math.min(ret, dp[j]);
                }
            }
        }
        //System.out.println(cur + " " + ret);
        return ret;
    }
    private int calc(int i, int j) {
        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        return Math.min(j - i, r.length - j + i);
    }

    private void run() {
        String ring = "godding", key = "gd";
        System.out.println(findRotateSteps(ring, key));
    }
    public static void main(String[] args) {
        new Leet514().run();
    }
}
