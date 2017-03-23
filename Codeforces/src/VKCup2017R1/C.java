package VKCup2017R1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by sail on 3/18/17 12:13 PM.
 * Project: Algorithm.
 */
public class C {
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

        String nextLine() { String line = ""; try { line = br.readLine(); } catch (Exception e) {} return line;}
    }

    public void run(){
        in = new FastScanner();
        out = new PrintWriter(System.out);

        int n = in.nextInt();
        int k = in.nextInt();
        String[] list = in.nextLine().split(" ");
        String[] names = new String[52];
        int index = 0;
        for (char i = 'A'; i < 'A' + 26; i++) {
            names[index++] = String.valueOf(i);
        }
        for (char i = 'a'; i < 'a' + 26; i++) {
            names[index++] = "A" + String.valueOf(i);
        }

        String[] ans = new String[n];
        int cur = 0, pre = -1;
        index = 0;
        while (index < n - k + 1 && list[index].equals("NO")) {
            index++;
        }
        if (index != 0) {
            for (int i = 0; i <= index; i++) {
                ans[i] = names[cur];
            }
            cur++;
        }
        for (int i = index; i < n - k + 1; i++) {
            if (list[i].equals("YES")) {
                if (pre == -1) {
                    for (int j = index == 0 ? i : i + 1; j < i + k; j++) {
                        ans[j] = names[cur++];
                    }
                } else {
                    for (int j = Math.max(pre, i); j < i + k; j++) {
                        ans[j] = names[cur++];
                    }
                }
                pre = i + k;
            } else {
                break;
            }
        }
        if (pre != n) {
            if (pre != -1) {
                for (int i = pre - k; i < n - k; i++) {
                    if (list[i + 1].equals("YES")) {
                        ans[i + k] = names[cur++];
                    } else {
                        ans[i + k] = ans[i + 1];
                    }
                }
            } else {
                --cur;
                for (int i = index + 1; i < n; i++) {
                    ans[i] = names[cur];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != 0)
                out.print(" ");
            out.print(ans[i]);
        }
        out.println();
        out.close();
    }
    public static void main(String[] args) {
        new C().run();
    }
}
