/**
 * Created by sail on 9/14/16.
 * Code one more line :)
 */
public class Leet60 {
    public String getPermutation(int n, int k) {
        char[] num = new char[n];
        int permCnt = 1;
        for (int i = 1; i <= n; i++) {
            num[i - 1] = (char)('0' + i);
            permCnt *= i;
        }
        k--;
        StringBuilder sbd = new StringBuilder();
        for (int i = n; i > 0; i--) {
            permCnt /= i;
            int cur = k / permCnt;
            sbd.append(num[cur]);

            for (int j = cur; j < i - 1; j++) {
                num[j] = num[j + 1];
            }
            k %= permCnt;
        }
        return sbd.toString();
    }
}
