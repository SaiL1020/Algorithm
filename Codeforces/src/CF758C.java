import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by sail on 1/21/17.
 * Code one more line :)
 */
public class CF758C {
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

    /* method 1: O(m * n), simulation
    public void run(){
        in = new FastScanner();
        out = new PrintWriter(System.out);

        int n, m, x, y;
        long k, max, min, cur;
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextLong();
        x = in.nextInt();
        y = in.nextInt();
        if (n == 1) {
            max = min = cur = k / m;
            long rem = k % m;
            if (rem != 0) max++;
            if (rem >= y) cur++;
        } else {
            long[][] count = new long[n][m];
            long cycle = k / ((2 * n - 2) * m), rem = k % ((2 * n - 2) * m);
            Arrays.fill(count[0], cycle);
            Arrays.fill(count[n - 1], cycle);
            for (int i = 1; i < n - 1; i++) {
                Arrays.fill(count[i], cycle * 2);
            }
            for (int i = 0; i < n && rem > 0; i++) {
                for (int j = 0; j < m && rem > 0; j++, rem--) {
                    count[i][j]++;
                }
            }
            for (int i = n - 2; i > 0 && rem > 0; i--) {
                for (int j = 0; j < m && rem > 0; j++, rem--) {
                    count[i][j]++;
                }
            }
            max = 0;
            min = 1L << 60;
            cur = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    max = Math.max(max, count[i][j]);
                    min = Math.min(min, count[i][j]);
                    if (i == x - 1 && j == y - 1) cur = count[i][j];
                }
            }
        }
        out.println(max + " " + min + " " + cur);
        out.close();
    }
    */

    // method 1: O(m * n), simulation
    int n, m, x, y;
    long k;
    public void run() {
        in = new FastScanner();
        out = new PrintWriter(System.out);


        n = in.nextInt();
        m = in.nextInt();
        k = in.nextLong();
        x = in.nextInt();
        y = in.nextInt();
        out.println(Math.max(count(1,1), Math.max(count(2, 1), count(n - 1, 1)))
                    + " " + count(n, m) + " " + count(x, y));
        out.close();
    }
    private long count(int x, int y) {
        if (n == 1)
            return k / m + (k % m >= y ? 1 : 0);
        long period = (n * 2 - 2) * m;
        long trips = k / period;
        long rem = k % period;
        long need1 = (x - 1) * m + y;
        long need2 = (n - x - 1) * m + y + n * m;
        if (x == 1 || x == n)
            return trips + (need1 <= rem ? 1 : 0);
        return trips * 2 + (need1 <= rem ? 1 : 0) + (need2 <= rem ? 1 : 0);
    }
    public static void main(String[] args) {
        new CF758C().run();
    }
}
