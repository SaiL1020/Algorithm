/**
 * Created by sail on 10/10/16.
 * Code one more line :)
 */

import java.util.*;
import java.io.*;

public class GoDaddyArrangingCoins {
    public long[] coins(long[] sum) {
        long[] ans = new long[sum.length];
        for (int i = 0; i < sum.length; i++) {
            ans[i] = ((long)Math.sqrt(8 * sum[i] + 1) - 1) / 2;
        }
        return ans;
    }

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
        long[] input = new long[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextLong();
        }
        long[] ans = coins(input);
        for (long l : ans) {
            out.println(l);
        }
        out.close();
    }
    public static void main(String[] args) {
        new GoDaddyArrangingCoins().run();
    }
}
