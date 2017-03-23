import java.util.Arrays;

/**
 * Created by sail on 8/28/16.
 * Code one more line :)
 */
public class Leet279 {
    public int numSquares(int n) {
        int[] num = new int[n + 1];
        Arrays.fill(num, Integer.MAX_VALUE);
        num[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                num[j] = Math.min(num[j], num[j - (i * i)] + 1);
            }
        }
        for (int k: num) {
            System.out.print(k + " ");
        }
        System.out.println();
        return num[n];
    }
}
