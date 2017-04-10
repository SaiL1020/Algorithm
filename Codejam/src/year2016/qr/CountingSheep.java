package year2016.qr;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by sail on 4/8/16.
 * Think of the least power of 10 greater than N:
 * The leftmost digit will occur at least every 10 steps.
 */
public class CountingSheep {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = cin.nextInt();
            System.out.println("Case #" + i + ": " + (N == 0 ? "INSOMNIA" : solve(N)));
        }
    }

    public static int solve(int N) {
        HashSet<Integer> digit = new HashSet<Integer>();
        int ret = 1;
        for (int i = 1; digit.size() != 10; i++) {
            int cur = N * i;
            ret = cur;
            while (cur != 0) {
                digit.add(cur % 10);
                cur /= 10;
            }
        }
        return ret;
    }
}
