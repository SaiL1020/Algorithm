import java.util.InputMismatchException;

/**
 * Created by sail on 6/10/16.
 * Code one more line :)
 */
public class Leet29 {
    public int divide(int dividend, int divisor) {
        int sign = 0;
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;

        long ldividend = dividend;
        long ldivisor = divisor;
        if ((dividend < 0 && divisor < 0) ||
                (dividend > 0 && divisor > 0)) {
            sign = 1;
        }
        ldividend = Math.abs((long)dividend);
        ldivisor = Math.abs((long)divisor);
        long adder = ldivisor, cnt = 1;
        long cur = 0, ret = 0;
        int ccnt = 0;
        while (cur <= ldividend - adder) {
            cur += adder;
            ret += cnt;
            if (cur < Integer.MAX_VALUE - adder - adder && cur + adder + adder <= ldividend) {
                adder += adder;
                cnt += cnt;
            } else {
                adder = ldivisor;
                cnt = 1;
            }
        }
        ret = sign == 1 ? ret : -ret;
        if (ret > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)ret;
    }
}
