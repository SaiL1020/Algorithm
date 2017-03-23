import java.util.Scanner;

/**
 * Created by sail on 9/12/16.
 * Code one more line :)
 */
public class Leet69 {
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        double pre = 0, ans = 1, eps = 1e-8;
        while (Math.abs(ans - pre) > eps) {
            pre = ans;
            ans = (ans + x / ans) / 2.0;
        }
        return (int)ans;
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1, r = x - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (m <= x / m) l = m;
            else r = m;
        }
        return l;
    }

    public void run() {
        int k = -1;
        while (k != 0) {
            Scanner sc = new Scanner(System.in);
            k = sc.nextInt();
            System.out.println(mySqrt(k));
            System.out.println(mySqrt2(k));
        }
    }
    public static void main(String[] args) {
        new Leet69().run();
    }
}
