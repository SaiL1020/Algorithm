/**
 * Created by sail on 12/14/16.
 * 474. Ones and Zeroes
 */
public class Leet474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] cnt = count(str);
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = n; j >= cnt[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - cnt[0]][j - cnt[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    private int[] count(String s) {
        int[] cnt = new int[2];
        for (char ch : s.toCharArray()) {
            cnt[ch - '0']++;
        }
        return cnt;
    }
}
