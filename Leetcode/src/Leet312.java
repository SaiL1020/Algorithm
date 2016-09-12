/**
 * Created by sail on 9/11/16.
 * Code one more line :)
 */
public class Leet312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] nn = new int[n + 2];
        nn[0] = nn[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            nn[i + 1] = nums[i];
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n - k + 1 ; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][x-1] + nn[i-1]*nn[x]*nn[j+1] + dp[x+1][j]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Leet312().maxCoins(new int[]{3,1,5,8}));
    }
}
