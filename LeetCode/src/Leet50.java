/**
 * Created by sail on 9/3/16.
 * Code one more line :)
 */
public class Leet50 {
    public double myPow(double x, int n) {
        int sign = n < 0 ? -1 : 1;      // edge!!
        long ln = Math.abs((long) n);   // edge!!!
        double ans = 1;
        System.out.println(ln);
        while (ln > 0) {
            System.out.println(ln);
            if ((ln & 1) == 1) ans *= x;
            x *= x;
            ln >>= 1;

        }
        return sign == 1 ? ans : 1.0 / ans;
    }

    public static void main(String[] args) {
        double x = 1;
        int n = -2147483648;
        System.out.println(new Leet50().myPow(x, n));
    }
}
