import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by sail on 10/10/16.
 * Code one more line :)
 */
public class GoDaddyBuildTheSequence {
    public List<String> subSequence(String s) {
        int sz = s.length();
        char[] ch = s.toCharArray();
        List<String> ans = new LinkedList<>();
        for (int st = 0; st < sz; st++) {
            for (int i = 0, cnt = st; cnt < sz; cnt++) {
                i += (1 << cnt);
                StringBuilder sbd = new StringBuilder();
                for (int j = 0; j < sz; j++) {
                    if ((i & (1 << j)) != 0) {
                        sbd.append(ch[j]);
                    }
                }
                if (sbd.length() != 0)
                    ans.add(sbd.toString());
            }
        }
        return ans;
    }
    private FastScanner in;
    private PrintWriter out;

    private class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
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

    private void run(){
        in = new FastScanner();
        out = new PrintWriter(System.out);
        String s = in.nextToken();

        List<String> ans = subSequence(s);
        out.println(ans.size());
        for (String str : ans) {
            out.println(str);
        }

        out.close();
    }
    public static void main(String[] args) {
        new GoDaddyBuildTheSequence().run();
    }
}
