import java.util.Scanner;

/**
 * Created by sail on 9/12/16.
 * Code one more line :)
 */
public class Leet69 {
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
        }
    }
    public static void main(String[] args) {
        new Leet69().run();
    }
}
