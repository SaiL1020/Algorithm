import java.util.Scanner;

/**
 * Created by sail on 4/30/16.
 */
public class Poj1157 {
    public static void main(String[] args) {
        int flowers, vases;
        int[][] valuesOfFlowerInVase;
        Scanner sc = new Scanner(System.in);

        flowers = sc.nextInt();
        vases = sc.nextInt();
        valuesOfFlowerInVase = new int[flowers + 1][vases + 1];

        for (int i = 1; i <= flowers; i++) {
            for (int j = 1; j <= vases; j++) {
                valuesOfFlowerInVase[i][j] = sc.nextInt();
            }
        }

        // max value { i flower in j vase }
        int[][] dp = new int[flowers + 1][vases + 1];
        for (int i = 1; i <= flowers; i++) {
            for (int j = i; j <= vases; j++) {
                dp[i][j] = dp[i - 1][j - 1] + valuesOfFlowerInVase[i][j];
                if (i != j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
//                System.out.print(i + " " + j + "=" + dp[i][j] + "\t");
            }
//            System.out.println();
        }

        System.out.println(dp[flowers][vases]);
    }
}
