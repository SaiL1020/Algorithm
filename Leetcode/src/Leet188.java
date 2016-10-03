import java.util.Arrays;

/**
 * Created by sail on 9/21/16.
 * Code one more line :)
 */
public class Leet188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length, ans = 0;
        int[] sell = new int[n], buy = new int[n];
        Arrays.fill(sell, Integer.MIN_VALUE);
        if (k <= n / 2) {
            for (int i = 1; i < n; i++) {
                sell[i] = Math.max(sell[i], buy[i - 1] + prices[i]);
                buy[i] = Math.max(buy[i], sell[i - 1] - prices[i]);
                ans = Math.max(ans, sell[i]);
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    ans += prices[i] - prices[i - 1];
                }
            }
        }
        return ans;
    }
}
