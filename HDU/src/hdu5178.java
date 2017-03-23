import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Created by sail on 9/19/16.
 * Code one more line :)
 */
public class hdu5178 {
    public static void main(String[] args) throws Exception {
        int T, n, k;
        int[] a;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            k = Integer.parseInt(line[1]);
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(a);
            long ans = 0;
            for (int i = 0; i < n - 1; i++) {
                ans += (long)binarySearch(a, i, n, a[i] + k) - (long)i;
                //System.out.println(i + " " + ans);
            }
            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        bw.flush();
    }
    // search for [0, l] (r, n)
    public static int binarySearch(int[] a, int l, int r, int key) {
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (a[m] <= key) l = m;
            else r = m;
        }
        return r - 1;
    }
}
