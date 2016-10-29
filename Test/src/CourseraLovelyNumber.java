/**
 * Created by sail on 10/15/16.
 * Code one more line :)
 */

import java.util.*;
import java.io.*;

public class CourseraLovelyNumber {
    public int lovelyNumber(int a, int b) {
        int bit = 0, cnt = 0;
        for (int i = 1; i <= 9; i++) {
            bit |= 1 << i;
            cnt += dfs(i, bit, a, b);
            bit &= ~(1 << i);
        }
        return cnt;
    }
    private int dfs(int num, int bit, int l, int r) {
        int cnt = 0;
        if (num > r) return cnt;
        else if (l <= num && num <= r) cnt++;
        else {
            for (int i = 0; i <= 9; i++) {
                if ((bit & (1 << i)) != 0) continue;
                num = num * 10 + i;
                bit |= 1 << i;
                cnt += dfs(num, bit, l, r);
                bit &= ~(1 << i);
                num /= 10;
            }
        }
        return cnt;
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
        while (n-- > 0) {
            int a = in.nextInt(), b = in.nextInt();
            System.out.println(lovelyNumber(a, b));;
        }
        out.close();
    }

    public static void main(String[] args) {
        new CourseraLovelyNumber().run();
    }
}
