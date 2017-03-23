import java.util.HashMap;
import java.util.Map;

/**
 * Created by sail on 9/14/16.
 * Code one more line :)
 */
public class Leet166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        if (a == 0) return "0";
        int sign = 1;
        if (a < 0 && b > 0 || a > 0 && b < 0) sign = -1;
        a = Math.abs(a);
        b = Math.abs(b);
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sbd = new StringBuilder();
        sbd.append(String.valueOf(a / b));
        if (a % b != 0) {
            sbd.append('.');
        }
        a = a - a / b * b;
        while (a != 0) {
            a *= 10;
            if (map.containsKey(a)) {
                sbd.insert(map.get(a), "(");
                sbd.append(')');
                break;
            }
            map.put(a, sbd.length());
            //System.out.println(a + " " + sbd.length());
            while (a < b) {
                a *= 10;
                sbd.append('0');
                map.put(a, sbd.length());
                //System.out.println(a + " " + sbd.length());
            }
            sbd.append(a / b);
            if (a % b == 0) break;
            a = a - a / b * b;
        }
        if (sign == -1) sbd.insert(0, "-");
        return sbd.toString();
    }

    public void run() {
        int a = 50, b = -8;
        System.out.println(fractionToDecimal(a, b));
    }
    public static void main(String[] args) {
        new Leet166().run();
    }
}
