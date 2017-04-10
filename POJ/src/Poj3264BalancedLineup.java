import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * author:      SaiL1020
 * time:        4/2/17 6:43 PM
 * project:     Algorithm
 */
public class Poj3264BalancedLineup {
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

    int[] height;
    int[] idxMax;
    int[] idxMin;
    int N;
    public void run(){
        in = new FastScanner();
        out = new PrintWriter(System.out);

        N = in.nextInt();
        int Q = in.nextInt();
        height = new int[N + 1];
        idxMax = new int[N + 1];
        idxMin = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            height[i] = in.nextInt();
        }
        init();
//        for (int i = 1; i <= N; i++) {
//            out.println(idxMin[i] + " " + idxMax[i]);
//        }
//        out.println();
        for (int i = 0; i < Q; i++) {
            int L = in.nextInt();
            int R = in.nextInt();
            out.println(query(L, R));
        }
        out.close();
    }
    private void init() {
        for (int i = 1; i <= N; i++) {
            idxMax[i] = idxMin[i] = height[i];
            for (int j = 1; j < lowbit(i); j <<= 1) {
                idxMax[i] = Math.max(idxMax[i], idxMax[i - j]);
                idxMin[i] = Math.min(idxMin[i], idxMin[i - j]);
            }
        }
    }
    private int query(int l, int r) {
        int maxVal = height[r];
        int minVal = height[r];
        while (l != r) {
            // not in the interval, compare with single value
            maxVal = Math.max(maxVal, height[r]);
            minVal = Math.min(minVal, height[r]);
            // in some interval [k - lowbit(k) + 1, k]
            for (--r; r > 0 && r - lowbit(r) + 1 >= l; r -= lowbit(r)) {
                maxVal = Math.max(maxVal, idxMax[r]);
                minVal = Math.min(minVal, idxMin[r]);
            }
            //System.out.println(l + " " + r);
        }
        //out.println(minVal + " " + maxVal);
        return maxVal - minVal;
    }
    private int lowbit(int x) {
        return x & -x;
    }
    public static void main(String[] args) {
        new Poj3264BalancedLineup().run();
    }
}
/*
7 7
1
7
3
4
2
5
6
3 7
2 7
1 7
4 7
5 7
6 7
2 6
 */
