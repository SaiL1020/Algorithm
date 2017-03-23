import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by sail on 12/8/16.
 * Remove Invalid Parentheses
 */
public class Leet301 {
    Set<String> ans;

    char[] ch;
    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();
        ch = s.toCharArray();
        int l = 0, r = 0;
        for (char c : ch) {
            if (c == '(') l++;
            else if (c == ')') {
                if (l > 0) l--;
                else r++;
            }
        }
        dfs(new StringBuilder(), 0, 0, l, r);
        return new ArrayList<>(ans);
    }
    private void dfs(StringBuilder sb, int k, int open, int l, int r) {
        if (l < 0 || r < 0 || open < 0) return;
        if (k == ch.length) {
            if (l == 0 && r == 0 && open == 0) ans.add(sb.toString());
            return;
        }
        int len = sb.length();
        if (ch[k] == '(') {
            dfs(sb, k + 1, open, l - 1, r);     // not use
            dfs(sb.append('('), k + 1, open + 1, l, r); // use
        } else if (ch[k] == ')') {
            dfs(sb, k + 1, open, l, r - 1);     // not use
            dfs(sb.append(')'), k + 1, open - 1, l, r); // use
        } else {
            dfs(sb.append(ch[k]), k + 1, open, l, r);
        }
        sb.setLength(len);
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
        //out = new PrintWriter(System.out);
        while (true) {
            String str = in.nextToken();
            System.out.println(removeInvalidParentheses(str));
        }
        //out.close();
    }

    public static void main(String[] args) {
        new Leet301().run();
    }
}
