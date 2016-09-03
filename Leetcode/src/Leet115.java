/**
 * Created by sail on 9/2/16.
 * Code one more line :)
 */
public class Leet115 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length() || (s.length() == t.length() && !s.equals(t))) return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length() && j <= i; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
