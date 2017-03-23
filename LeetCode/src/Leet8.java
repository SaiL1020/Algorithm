/**
 * Created by sail on 6/10/16.
 * Code one more line :)
 */
public class Leet8 {
    final long IMAX = Integer.MAX_VALUE, IMIN = Integer.MIN_VALUE;
    public int myAtoi(String str) {
        char[] ch = str.toCharArray();
        long real = 0;
        boolean hasNum = false, minus = false, plus = false;
        for (char aCh : ch) {
            //System.out.println(ch[i]);
            if (aCh == ' ') {
                if (hasNum || minus || plus) break;
            } else if (aCh == '-') {
                if (hasNum || minus || plus) break;
                minus = true;
            } else if (aCh == '+') {
                if (hasNum || minus || plus) break;
                plus = true;
            } else if (aCh < '0' || aCh > '9') {
                break;
            } else {
                real = real * 10 + aCh - '0';
                hasNum = true;
            }
            if (real > IMAX) break;
        }
        int ans;
        if (minus) real = -real;
        //System.out.println(real);
        if (real > IMAX) ans = (int)IMAX;
        else if (real < IMIN) ans = (int)IMIN;
        else ans = (int)real;
        return ans;
    }
}
