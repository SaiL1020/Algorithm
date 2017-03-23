package VKCup2017R1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by sail on 3/18/17 11:41 AM.
 * Project: Algorithm.
 */
public class B {
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

    List<Integer>[] g;
    boolean[] vis;
    int edges;
    private boolean dfs(int i, Set<Integer> s) {
        if (g[i].size() != edges) return false;
        vis[i] = true;
        s.add(i);
        for (int j = 0; j < g[i].size(); j++) {
            int cur = g[i].get(j);
            if (!vis[cur]) {
                if (!dfs(cur, s))
                    return false;
            }
        }
        return true;
    }
    public void run(){
        in = new FastScanner();
        out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }
        vis = new boolean[n];
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            edges = g[i].size();
            if (edges == 0) continue;
            Set<Integer> s = new HashSet<>();
            ans = dfs(i, s);
            //System.out.println(i + " " + s.size());
            if (s.size() != edges + 1) ans = false;
            if (!ans) break;
        }
        out.println(ans ? "YES" : "NO");
        out.close();
    }
    public static void main(String[] args) {
        new B().run();
    }
}
