/**
 * Created by sail on 9/13/16.
 * Code one more line :)
 */
public class Leet396 {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        int add = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i * A[i];
            add += A[i];
        }
        int ret = ans;
        for (int i = 1; i < n; i++) {
            ans += add - n * A[n - i];
            ret = Math.max(ret, ans);
        }
        return ret;
    }
}
