package Round407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * author:      SaiL1020
 * time:        3/29/17 12:38 PM
 * project:     Algorithm
 */
public class B407 {
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
    }
    private String solve(int b, int q, int l, Set<Integer> set) {
        if (Math.abs(b) > l) return "0";
        if (b == 0) return set.contains(0) ? "0" : "inf";
        if (q == 1) return set.contains(b) ? "0" : "inf";
        if (q == -1) return set.contains(b) && set.contains(-b) ? "0" : "inf";
        if (q == 0) return set.contains(0) ? (set.contains(b) ? "0": "1") : "inf";
        int ans = 0;
        while (true) {
            if (!set.contains(b)) ans++;
            if (Math.abs((long) b * q) > l) break;
            b *= q;
        }
        return String.valueOf(ans);
    }
    public void run(){
        in = new FastScanner();
        out = new PrintWriter(System.out);

        int b = in.nextInt();
        int q = in.nextInt();
        int l = in.nextInt();
        int m = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(in.nextInt());
        }

        out.println(solve(b,q,l,set));
        out.close();
    }
    public static void main(String[] args) {
        new B407().run();
    }
}