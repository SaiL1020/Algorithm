/**
 * Created by sail on 9/10/16.
 * Code one more line :)
 */
public class Leet396 {
    public static int maxRotateFunction(int[] A) {
        int[] tot = new int[A.length];
        tot[0] = A[0];
        for (int i = 1; i < A.length; i++) tot[i] = tot[i - 1] + A[i];
        int ans = 0;
        for (int i = 0; i < A.length; i++) ans += i * A[i];
        int ret = ans;
        for (int i = A.length - 2, j = 1; i >= 0; i--, j++) {
//            System.out.println(ans + " " + tot[i] + " " + (A.length - 1) * A[i + 1] + " " + (tot[A.length - 1] - tot[i + 1]));
            ans = ans + tot[i] - (A.length - 1) * A[i + 1] + tot[A.length - 1] - tot[i + 1];
            ret = Math.max(ret, ans);
        }
        return ret;
    }

    public static void main(String[] args) {
        int ans = maxRotateFunction(new int[]{4,3,2,6});
        System.out.println(ans);
    }
}
