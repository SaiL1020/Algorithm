package microsoft;

import java.util.Scanner;

/**
 * author:      SaiL1020
 * time:        3/31/17 9:13 AM
 * project:     Algorithm
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int N = sc.nextInt();
        System.out.println(solve(P, Q, N));
    }
    private static double solve(int P, int Q, int N) {
        double ans = 0;
        for (int i = 0; i < N; i++) {
            double prob = 1;
            int curP = i > 7 ? 0 : P / (1 << i);
            int step = 0;
            while (true) {
                ++step;
                if (curP < 100) {
                    ans += prob * step * curP / 100.0;
                } else {
                    ans += prob * step;
                    break;
                }
                prob *= (100 - curP) / 100.0;
                curP += Q;
            }
        }
        return ans;
    }
}
