package Round407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * author:      SaiL1020
 * time:        3/29/17 12:05 PM
 * project:     Algorithm
 */
public class A407 {
    FastScanner in;
    PrintWriter out;

    private class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

    public void run(){
        in = new FastScanner();
        out = new PrintWriter(System.out);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] / k / 2;
            int rem = a[i] % (2 * k);
            if (rem != 0) {
                ans++;
                if (i + 1 == n) continue;
                if (rem <= k) {
                    a[i + 1] -= k;
                    if (a[i + 1] < 0) a[i + 1] = 0;
                }
            }
        }
        out.println(ans);
        out.close();
    }
    public static void main(String[] args) {
        new A407().run();
    }
}
