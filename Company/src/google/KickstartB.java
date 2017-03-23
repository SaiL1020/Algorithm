package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by sail on 3/5/17.
 *
 */

//TODO finish KickStart2017 B
public class KickstartB {
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
    private boolean search(StringBuilder a, StringBuilder b, int i, int j) {
        while (i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)) {
            i++;
            j++;
        }
        if (!(a.charAt(i) == '*' || b.charAt(j) == '*')) return false;
        return true;
    }
    private void run() {
        in = new FastScanner();
        out = new PrintWriter(System.out);
        int T = in.nextInt();
        for (int index = 1; index <= T; index++) {
            StringBuilder a = new StringBuilder(in.nextToken()), b = new StringBuilder(in.nextToken());
            out.println("Case #" + index + ": " + (search(a, b, 0, 0) ? "TRUE" : "FALSE"));
        }
        out.flush();
        out.close();
    }
    public static void main(String[] args) {

    }
}
