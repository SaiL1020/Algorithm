package Round392;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by sail on 1/20/17.
 * Code one more line :)
 */
public class CF758B {
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

        int[] b = new int[4];
        int[] p = new int[26];
        char[] ch = in.nextToken().toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '!') {
                b[i % 4]++;
            } else {
                p[ch[i] - 'A'] = i % 4;
            }
        }
        out.println(b[p['R' - 'A']] + " " +
                    b[p['B' - 'A']] + " " +
                    b[p['Y' - 'A']] + " " +
                    b[p['G' - 'A']]);
        out.close();
    }
    public static void main(String[] args) {
        new CF758B().run();
    }
}
