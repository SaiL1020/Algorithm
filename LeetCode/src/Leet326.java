/**
 * Created by sail on 5/18/16.
 * isPowerOfThree
 */
public class Leet326 {
    public boolean isPowerOfThree(int n) {
        // elegant property :)
        final int MAX = Integer.MAX_VALUE;
        return n > 0 && pow3(floor(log3(MAX))) % n == 0;

        /*
         * naive method
         *
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return (n - 1 == 0) ? true : false;
        */
    }
    public int pow3(int x) { // base == 3
        return (int) Math.pow(3, x);
    }
    public int log3(int x) { // base == 3
        return (int) (Math.log(x) / Math.log(3));
    }
    public int floor(int x) { // floor of input
        return (int) Math.floor(x);
    }
}
