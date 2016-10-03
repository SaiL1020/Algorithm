/**
 * Created by sail on 10/1/16.
 * Code one more line :)
 */
import java.io.*;
import java.util.*;
public class CF722C {
    private boolean[] vis;
    private int n;
    private long curMax;
    private int[] fa, a, p;
    private long[] ans, sum;
    public static void main(String[] args) {
        try {
            new CF722C().run();
        } catch (Exception e) {

        }
    }
    private void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        p = new int[n];
        ans = new long[n];
        fa = new int[n];
        sum = new long[n];
        vis = new boolean[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(line[i]) - 1;
            fa[i] = i;
        }
        curMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = curMax;
            solve(p[i]);
        }
        for (long k : ans) {
            System.out.println(k);
        }
    }
    private void solve(int p) {
        sum[p] = a[p];
        if (p > 0 && vis[p - 1]) union(p, p - 1);
        if (p < n - 1 && vis[p + 1]) union(p, p + 1);
        curMax = Math.max(curMax, sum[find(p)]);
        vis[p] = true;
    }

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        fa[x] = y;
        sum[y] += sum[x];
    }
}
